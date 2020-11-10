/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos
 */
public class FondoPanel extends javax.swing.JPanel{
    private Image img;
    private String imgName;
    private String name;
    int minX;//[1000, 562]
    int maxX;
    int minY;//[1000, 562]
    int maxY;

    public FondoPanel(int _minX,int _maxX,int _minY,int _maxY,String _imgName,String _name) {
        this.maxX = _maxX;
        this.maxY = _maxY;
        this.minX = _minX;
        this.minY = _minY;
        this.imgName = _imgName;
        this.name = _name;
    }
    
    public FondoPanel(String _imgName,String _name) {
        this.maxX = 0;
        this.maxY = 0;
        this.minX = 0;
        this.minY = 0;
        this.imgName = _imgName;
        this.name = _name;
    }
    
    @Override
    public void paint(Graphics g){
        img = new ImageIcon(getClass().getResource("/Imagenes/ESCENARIOS/"+imgName)).getImage();
        g.drawImage(img,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        //setLayout(null);
        super.paint(g);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
