/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DataAccess;
import Modelo.*;
import Vista.Escenario;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import personajeswaldo.*;

public class MenuController {
    private Escenario escenario;
    private FondoPanel fondoPanel;
    private JLabel title ;
    private DataAccess data;

    public MenuController(Escenario _escenario,FondoPanel _fondoPanel, DataAccess _data){
        escenario = _escenario;
        fondoPanel = _fondoPanel;
        data = _data;
        title = new JLabel();
        __init__();
    }
    
    public void __init__(){
        fondoPanel.setLayout(null);
        escenario.setContentPane(fondoPanel);
        drawScenesButtons();
        drawTitle();
    }
    
    public void drawScenesButtons(){
        for(int i = 0 ; i<data.getListaEscenarios().size() ; i++){
            JButton button = new JButton();
            button.setBounds(570, 100+i*22, 300, 20);
            button.setText(data.getListaEscenarios().get(i).getName());
            button.setFont(new Font("Astoria Sans", Font.BOLD, 15));
            //System.out.println(this.data.getListaPrincipales().toString());
            addEvent(this.data.getListaEscenarios().get(i),button,this.data.getListaPrincipales(),this.data.getListaDummy());
            fondoPanel.add(button);
        }
    }    
    
    public void drawTitle(){
        title.setBounds(570, 10, 300, 100);
        title.setText("Escenarios");
        title.setFont(new Font("AR DARLING", Font.BOLD, 55));
        title.setForeground(Color.red);
        fondoPanel.add(title);
    }
    
    public void addEvent(FondoPanel scene, JButton button, ArrayList<Personaje> listaPrincipales, ArrayList<Personaje> listaDummy){       
            button.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println("ESCENA ELEGIDA: "+scene.getName());
                    Escenario escenario1 = new Escenario();
                    EscenarioController escenarioControlador = new EscenarioController(escenario1,scene,listaPrincipales,listaDummy);
                    escenario1.setVisible(true);
                }
            });
    }
}
