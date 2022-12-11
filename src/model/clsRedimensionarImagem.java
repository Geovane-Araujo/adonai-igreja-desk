package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author Charleston Anjos
 */
public class clsRedimensionarImagem {
   
    /*
     * @param receber icone, largura e altura desejeda
     * @return retorna a imagem redimensionada
     */
    public ImageIcon redimensionar(JLabel jLabel, int xLargura, int yAltura){
       
        ImageIcon img = new ImageIcon (jLabel.getIcon().toString());  
        img.setImage(img.getImage().getScaledInstance(xLargura, yAltura, 100));
       
        return img;
    }
   
}
