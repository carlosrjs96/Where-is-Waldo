/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import personajeswaldo.Personaje;

public class Principales extends Personaje{
    //private NodeType type;
    private int value;
    private Boolean pressed;
    private JLabel label;
    private String imgName;
    private String imgNameFounded;

    /*public Principales(String _imgName,String _imgNameFounded) {
        super(_imgName);
        this.imgName = _imgName;
        this.imgNameFounded = _imgNameFounded;
        this.label = new JLabel();
        this.pressed = false;
        this.value = 0;
        setImage(this.imgName);
        addEvent(this.imgNameFounded);
    }*/
    
    public Principales(){
        this.label = new JLabel();
        this.pressed = false;
        this.value = 0;
    }
    
   
    @Override
    public void setImage(String _imgName){
        this.label.setIcon(new ImageIcon("src\\Imagenes\\PERSONAJES\\PRINCIPALES\\" + _imgName));
        this.imgName = _imgName;
    }
    
    @Override
    public void addEvent(String imgNameFounded){       
            this.label.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println("Personaje Principal Encontrado");
                    setState(imgNameFounded);
                }
            });
    }
    
    @Override
    public void setState(String imgName){
        if(this.pressed == false){
            label.setIcon(new ImageIcon("src\\Imagenes\\PERSONAJES\\PRINCIPALES\\"+imgName));
            Dimension size = label.getPreferredSize();
            label.setBounds(label.getX(),label.getY(), size.width, size.height);
            this.pressed = true;
            this.value = 1;
        }
        
    }
    
    @Override
    public Personaje clonar(){
        Principales obj = new Principales();
        obj.setImage(this.getImgName());
        obj.addEvent(this.getImgNameFounded());
        //obj.setArma( this.getArma() )
        /*Principales personaje = null;
        try {
            personaje = (Principales)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
        return obj;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Boolean getPressed() {
        return pressed;
    }

    @Override
    public void setPressed(Boolean pressed) {
        this.pressed = pressed;
    }

    @Override
    public JLabel getLabel() {
        return label;
    }

    @Override
    public void setLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public String getImgName() {
        return imgName;
    }

    @Override
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String getImgNameFounded() {
        return imgNameFounded;
    }

    @Override
    public void setImgNameFounded(String imgNameFounded) {
        this.imgNameFounded = imgNameFounded;
    }
}
