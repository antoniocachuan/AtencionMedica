
package Formularios;

import java.awt.Color;
import javax.swing.*;

public class jpanFondo extends JPanel implements Runnable{

    protected Color colorDeFondo;   
    private JLabel anuncio1,anuncio2;
    
    public jpanFondo() {
        this.setLayout(null);
    }
    
    public ImageIcon imagen(String nombre){
        return new ImageIcon(getClass().getResource("/Imagenes/"+nombre));
        
    }

    public void run(){
    }
    
 }
