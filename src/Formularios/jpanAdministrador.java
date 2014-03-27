
package Formularios;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

public class jpanAdministrador  extends jpanFondo implements ActionListener,Runnable{
    private jpanFondo jpanelFondo;
    private JLabel jlblTitulo;
    private JButton jbtnRegPaciente,jbtnRegAdmin;
    private JToolBar Bar;    
    private jlblFondo encabezado; ;
    
    public jpanAdministrador(jpanFondo jpanelFondo) {
        this.jpanelFondo = jpanelFondo;
        iniciarComponentes();
    }

    public void iniciarComponentes(){
        this.setLayout(null);
        
        encabezado = new jlblFondo();
        this.add(encabezado);
        
        jlblTitulo = new JLabel("BIENVENIDO A LA CLINICA");
        jlblTitulo.setBounds(150,70,250,20);


        jbtnRegPaciente=new JButton ("Registrar Paciente");        
        jbtnRegPaciente.setBounds(15,180,200,20);        
        jbtnRegPaciente.addActionListener(this); 
        
        jbtnRegAdmin=new JButton ("Registrar Administrador");        
        jbtnRegAdmin.setBounds(15,210,200,20);        
        jbtnRegAdmin.addActionListener(this); 

        this.add(jlblTitulo);
        this.add(jbtnRegPaciente);        
        this.add(jbtnRegAdmin);
    }
   

    public void limpiar(){
    }
    

    
    public void actionPerformed(ActionEvent e){

        if(e.getSource() ==jbtnRegPaciente){
           ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Registro");
           limpiar();
        }
    }
   
    public void run(){

	}

}