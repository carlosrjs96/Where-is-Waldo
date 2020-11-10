/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import personajeswaldo.*;
/**
 *
 * @author Carlos
 */
public class EscenarioController {
    Escenario escenario;
    FondoPanel fondoPanel;
    ArrayList<Personaje> listaPrincipales; 
    ArrayList<Personaje> listaDummy;
    ArrayList<Personaje> listaPrincipalesEncontrados;
    int randomNumberX;
    int randomNumberY;
    PersonajesEnum tipoPersonaje;
    PersonajeFactory fabrica;
    JLabel title ;
    
    public EscenarioController(Escenario _escenario,FondoPanel _fondoPanel,
                               ArrayList<Personaje> _listaPrincipales, 
                               ArrayList<Personaje> _listaDummy){
        
        escenario = _escenario;
        fondoPanel = _fondoPanel;
        listaPrincipales = _listaPrincipales; 
        listaDummy= _listaDummy;
        fabrica = new PersonajeFactory();
        title = new JLabel();
        listaPrincipalesEncontrados = new ArrayList<Personaje>();
        __init__();
    }
    
    public void __init__(){
        //update();
        crearEscenario();
    }
    public void crearEscenario(){
        
        this.fondoPanel.setLayout(null);
        this.escenario.setContentPane(fondoPanel);
        this.fondoPanel.add(this.title);
        cargarPrincipales();
        cargarDummy();
        addEvent();
    }
    
    public void cargarPrincipales(){
        System.out.println("CARGAR PRINCIPALES :" + this.listaPrincipales.size());
        for(int i = 0 ; i < this.listaPrincipales.size() ; i++){
            Personaje personaje = this.listaPrincipales.get(i).clonar();
            //Personaje personaje = fabrica.getInstance(tipoPersonaje.PRINCIPAL);
            //System.out.println("IMGEN: " + this.listaPrincipales.get(i).getImgName());
            //System.out.println("IMGEN FOUNDED: " + this.listaPrincipales.get(i).getImgNameFounded());
            //personaje.setImage(this.listaPrincipales.get(i).getImgName());
            //personaje.addEvent(this.listaPrincipales.get(i).getImgNameFounded());
            randomNumberX= (int)(Math.random() * (fondoPanel.getMaxX() - fondoPanel.getMinX() + 1) + fondoPanel.getMinX());
            randomNumberY= (int)(Math.random() * (fondoPanel.getMaxY() - fondoPanel.getMinY() + 1) + fondoPanel.getMinY());
            Dimension size = personaje.getLabel().getPreferredSize();
            personaje.getLabel().setBounds(randomNumberX, randomNumberY, size.width, size.height);
            fondoPanel.add(personaje.getLabel());
            listaPrincipalesEncontrados.add(personaje);
        }
    }
    
    public void cargarDummy() {
        System.out.println("CARGAR DUMMY :" + this.listaDummy.size());
        int cont1 = 0;
        int cont = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < this.listaDummy.size(); i++) {
                Personaje personaje = this.listaDummy.get(i).clonar();
                //Personaje personaje = fabrica.getInstance(tipoPersonaje.DUMMY);
                //personaje.setImage(this.listaDummy.get(i).getImgName());
                //System.out.println("DUMMY # "+ j +" : " + personaje.getImgName());
                randomNumberX = (int) (Math.random() * (fondoPanel.getMaxX() - fondoPanel.getMinX() + 1) + fondoPanel.getMinX());
                randomNumberY = (int) (Math.random() * (fondoPanel.getMaxY() - fondoPanel.getMinY() + 1) + fondoPanel.getMinY());
                Dimension size = personaje.getLabel().getPreferredSize();
                personaje.getLabel().setBounds(randomNumberX, randomNumberY, size.width, size.height);
                //System.out.println("DUMMY # "+ j +" : LABEL->>>" + personaje.getLabel().getBounds());
                fondoPanel.add(personaje.getLabel());
            }
        }
        System.out.println("TOTAL PANEL COMPONENTS ->>>> " + fondoPanel.getComponentCount());
    }
    
    public boolean checkWinner(){
        System.out.println("CHECK WINNER");
        int cont = 0;
        for(int i = 0; i < this.listaPrincipalesEncontrados.size(); i++){
            if(this.listaPrincipalesEncontrados.get(i).getValue() == 1){
               cont++; 
            }
        } 
        System.out.println("CHECK CONTADOR : "+cont);
        if(cont == this.listaPrincipalesEncontrados.size()){
            System.out.println("CHECK TRUE");
            return true;
        }else{
            return false;
        }
    }
    
    public void addEvent(){       
            this.fondoPanel.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    update();
                }
            });
    }
    
    public void update(){
        if(checkWinner() == true){
            System.out.println("WheckWinner Ganaste");
            drawTitle();
        }
    }
    public void drawTitle(){
        JOptionPane.showMessageDialog(this.escenario, "GANASTE :)");
        this.escenario.dispose();
        /*this.title.setBounds(200,150, 1000, 200);
        this.title.setText("GANASTE :)");
        this.title.setFont(new Font("AR DARLING", Font.BOLD, 110));
        this.title.setForeground(Color.WHITE);   */
    }
}
