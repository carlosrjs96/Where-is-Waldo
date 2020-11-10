/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import personajeswaldo.Personaje;
/**
 *
 * @author Carlos
 */
public class Dummy extends Personaje{
    //private NodeType type;
    private int value;
    private Boolean pressed;
    private JLabel label;
    private String imgName;
    private String imgNameFounded;

   /* public Dummy(String _imgName) {
        super(_imgName);
        this.imgName = _imgName;
        this.label = new JLabel();
        this.pressed = false;
        this.value = 0;
        setImage(this.imgName);
    }*/
    
    public Dummy() {
        this.label = new JLabel();
        this.pressed = false;
        this.value = 0;
    }
    
    @Override
    public Personaje clonar(){
        Dummy obj = new Dummy();
        obj.setImage(this.getImgName());
        //obj.setArma( this.getArma() )
        return obj;
        /*Dummy personaje = null;
        try {
            personaje = (Dummy)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return personaje;*/
    }
    
    
    @Override
    public void addEvent(String imgNameFounded){ 
    
    }
    
    @Override
    public void setState(String imgName){
    }
   
    @Override
    public void setImage(String _imgName){
        this.label.setIcon(new ImageIcon("src\\Imagenes\\PERSONAJES\\DUMMY\\" + _imgName));
        this.imgName = _imgName;
        
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean getPressed() {
        return pressed;
    }

    public void setPressed(Boolean pressed) {
        this.pressed = pressed;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgNameFounded() {
        return imgNameFounded;
    }

    public void setImgNameFounded(String imgNameFounded) {
        this.imgNameFounded = imgNameFounded;
    }
}
