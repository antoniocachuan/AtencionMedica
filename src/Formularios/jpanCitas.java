
package Formularios;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class jpanCitas extends jpanFondo implements ActionListener,Runnable{
    private jpanFondo jpanelFondo;//panel base    
    private jlblFondo fondo; ;
    
    private JLabel jlblTitulo;
    
    
    public jpanCitas(jpanFondo fondo){
        this.jpanelFondo = fondo;
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        this.setLayout(null);
        fondo = new jlblFondo();
        this.add(fondo);
        
        jlblTitulo=new JLabel("Modulo de Citas");
        jlblTitulo.setBounds(150,50,200,20);
        this.add(jlblTitulo);
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
            
    }
}
