
package Formularios;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ClasesPrincipales.*;
import java.io.*;


public class jpanAccederUsuario extends jpanFondo implements ActionListener,Runnable{
 
    private JLabel jlblUsuario,jlblContraseña;
    private JTextField jtxtUsuario;
    private JPasswordField jpwfContraseña;
    private JButton jbtnAcceder;
    private JRadioButton jrbtPaciente,jrbtAdministrador;    
    private jpanFondo jpanelFondo;
    private jpanBarraMenu jpanelBarra;
    private jpanPaciente JpanelPaciente;
    private File P,A,Ac;
    private jlblFondo fondo; ;
    
    public jpanAccederUsuario(jpanFondo jpanelFondo,jpanBarraMenu jpanelBarra,jpanPaciente jPaciente,File P, File A,File Ac) {
        this.jpanelBarra=jpanelBarra;
        this.jpanelFondo=jpanelFondo;
        this.JpanelPaciente=jPaciente;
        this.P=P;
        this.A=A;
        this.Ac=Ac;
        iniciarComponentes();
    }

    public void iniciarComponentes(){
        this.setLayout(null);
 
        fondo = new jlblFondo();
        this.add(fondo);
        
        jlblUsuario = new JLabel("Usuario");
        jlblUsuario.setIcon(imagen("user.png"));
        jlblContraseña = new JLabel("Clave");
        jlblContraseña.setIcon(imagen("key.png"));
        jtxtUsuario = new JTextField();
        jpwfContraseña = new JPasswordField();
        jbtnAcceder = new JButton("Ingresar");
        jrbtPaciente = new JRadioButton("Paciente");
        jrbtAdministrador = new JRadioButton("Administrador");
        

        jlblUsuario.setBounds(350,200,80,20);
        jtxtUsuario.setBounds(420,200,140,20);
        jlblContraseña.setBounds(350,240,80,20); 
        jpwfContraseña.setBounds(420,240,140,20);
        jbtnAcceder.setBounds(380,320,165,20);
        jrbtPaciente.setBounds(360,280,75,20);
        jrbtAdministrador.setBounds(450,280,110,20); 
        
        jbtnAcceder.addActionListener(this);       
        jrbtPaciente.addActionListener(this);
        jrbtAdministrador.addActionListener(this);
        
        jrbtPaciente.setOpaque(false);
        jrbtAdministrador.setOpaque(false);        

        
        this.add(jlblUsuario);
        this.add(jtxtUsuario);
        this.add(jlblContraseña);
        this.add(jpwfContraseña);
        this.add(jbtnAcceder);
        this.add(jrbtAdministrador);
        this.add(jrbtPaciente);
        this.add(jrbtPaciente);
        this.add(jrbtAdministrador);    
        

    }

    @Override
    public void actionPerformed(ActionEvent e){
        String usuario=jtxtUsuario.getText();
        String pas=jpwfContraseña.getPassword().toString();
        /*************************** Accion del boton "ACCEDER" *************************/
        if(e.getSource() == jbtnAcceder){
            
            try{
//                int DNI=Integer.parseInt(usuario);        Valida el DNI        
                if(jrbtPaciente.isSelected()){
//                {
//                    if(VerificarPaciente(DNI)){                        
                        JpanelPaciente.RecuperarDatos();

                        ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Paciente");
                        limpiar();

//                    }else
//                        JOptionPane.showMessageDialog(null,"Usuario o Contraseña incorrecta","Acceder usuario",JOptionPane.ERROR_MESSAGE);                                   
                }
                else{
//                    if(jrbtAdministrador.isSelected()&&VerificarAdministrador()){
                     if(jrbtAdministrador.isSelected()){
                        ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Administrador"); 
                        limpiar();
                    }}
//                    else 
//                        JOptionPane.showMessageDialog(null,"Seleccione el tipo de usuario","Acceder usuario",JOptionPane.ERROR_MESSAGE);           
                    
                jpanelBarra.cambiarEstadoDeLaBarraConectado();
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Debe Ingresar un Usuario valido","Acceder usuario",JOptionPane.ERROR_MESSAGE);                                
                limpiar();
            }
            
            
            
        }
        //fin de la accion del boton acceder


        if(e.getSource() == jrbtAdministrador)
            jrbtPaciente.setSelected(false);
        if(e.getSource() == jrbtPaciente)
            jrbtAdministrador.setSelected(false);
        
    }
    
    public boolean VerificarPaciente(int cod){
        Paciente p=new Paciente();
        p.setDNI(cod);
        p.recuperar(P, cod);
        if(p.getContraseña()!=null && p.getContraseña().equals(String.valueOf(jpwfContraseña.getPassword()))){
           if(escribirActual(p))
               return true;
           else
               return true;   
        }else
            return true; 
    }
    
    public boolean VerificarAdministrador(){        
        //metodo para verificar la existencia de un administrador
        return true;
    }
    
    public boolean escribirActual(Paciente p){
        //archivo para guardar la persona con la que se esta trabajando
        RandomAccessFile a;
        boolean estado=true;
        try{
            a=new RandomAccessFile(Ac,"rw");  
            p.grabarDatos(a);
            a.close();
            Ac.deleteOnExit();//se eliminara una vez que se cierre el programa
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al iniciar sesion\nIntentelo nuevamente","Acceder usuario",JOptionPane.ERROR_MESSAGE);                                
            estado=false;
            limpiar();
        }
        return estado;
    }
    

    public void limpiar(){
        jtxtUsuario.setText("");
        jpwfContraseña .setText("");        
        jrbtPaciente.setSelected(false);        
        jrbtAdministrador.setSelected(false);
    }

    @Override
    public void run(){
    }

}