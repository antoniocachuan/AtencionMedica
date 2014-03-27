
package Formularios;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class jlblFondo extends JLabel{
    
     private ImageIcon imagen;

    public jlblFondo(){
        imagen=new ImageIcon("src\\Imagenes\\backGround.png");
        this.setIcon(imagen);
        setBounds(0,0,874,612);
    }
    public jlblFondo(String m){
        imagen=new ImageIcon(m);
        this.setIcon(imagen);
        setBounds(0,0,1000,612);
    }
     public jlblFondo(String m,int x,int y){
        imagen=new ImageIcon(m);
        this.setIcon(imagen);
        setBounds(0,0,x,y);
    }
}
