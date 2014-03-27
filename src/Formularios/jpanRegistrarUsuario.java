
package Formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import ClasesPrincipales.*;
import java.awt.Color;

import javax.swing.*;
import java.io.*;

public class jpanRegistrarUsuario extends jpanFondo implements ActionListener,Runnable{
    
    //etiquetas
    private JLabel jlblTitulo,jlblInstrucciones, jlblNombres, jlblApPaterno, jlblApMaterno;
    private JLabel jlblSexo,jlblEdad, jlblFechaDeNaciemiento,jlblContraseña; //registro de paciente  //subclase de javax.swing
    private JLabel jlblDireccion, jlblDNI, jlblTelefono, jlblEmail, jlblMensaje;
    //campos de texto
    private JTextField jtxfNombres, jtxfApPaterno, jtxfApMaterno, jtxfEdad;
    private JTextField jtxfDireccion, jtxfDNI, jtxfTelefono, jtxfEmail, jtxfFechaDeNacimiento ;    
    private JPasswordField jpsfContraseña;
    //Botones
    private JRadioButton jrbtFemenino, jrbtMasculino;
    private JButton jbtnRegistrar,jbtnRegresar,jbtnLimpiar;
    //otros
    private jpanFondo jpanelFondo;
    private Administrador admin;
    private File P,A;
    private Paciente p;    
    private jlblFondo encabezado; ;
    
    public jpanRegistrarUsuario(jpanFondo jpanelFondo,File P,File A) {        
        this.jpanelFondo=jpanelFondo;
        this.P=P;
        this.A=A;
        p=new Paciente();
        iniciarComponentes();
    }
    public void iniciarComponentes(){
        
        this.setLayout(null);
        encabezado=new jlblFondo();
        this.add(encabezado);
        
        jlblTitulo = new JLabel("REGISTRO DEL PACIENTE");
        jlblTitulo.setForeground(Color.BLUE);
        jlblInstrucciones=new JLabel("Ingrese su informacion personal en el siguiente formulario.");
        jlblNombres = new JLabel("Nombre:");
        jlblApPaterno = new JLabel("Apellido paterno:");
        jlblApMaterno = new JLabel("Apellido materno:");
        jlblSexo=new JLabel("Sexo:");
        jlblEdad = new JLabel("Edad:");
        jlblFechaDeNaciemiento = new JLabel("Fecha de nacimiento:");
        jlblDNI = new JLabel("D.N.I");
        jlblDireccion = new JLabel("Direccion");
        jlblTelefono = new JLabel("Telefono");
        jlblEmail = new JLabel("Email");
        jlblContraseña=new JLabel("Contraseña");
        jlblMensaje = new JLabel("Todos los campos son obligatorios");
        
        jbtnRegistrar=new JButton("Registrar");
        jbtnRegresar=new JButton("Cancelar");
        jbtnLimpiar=new JButton("Limpiar");
        
        jlblTitulo.setBounds(397,70,300,20);
        jlblInstrucciones.setBounds(267,100, 500, 40);
        
        jlblNombres.setBounds(287,150,200,20);
        jlblApPaterno.setBounds(287,175,200,20);
        jlblApMaterno.setBounds(287,200,200,20);        
        jlblSexo.setBounds(287,225,200,20);
        jlblEdad.setBounds(287,250,200,20);
        jlblFechaDeNaciemiento.setBounds(287,275,200,20);
        jlblDNI.setBounds(287,300,200,20);
        jlblDireccion.setBounds(287,325,200,20);
        jlblTelefono.setBounds(287,350,200,20);
        jlblEmail.setBounds(287,375,200,20);
        jlblContraseña.setBounds(287,400,200,20);
        jlblMensaje.setBounds(347,430,210,20);
        
        jbtnRegistrar.setBounds(254,480,120,20);
        jbtnRegresar.setBounds(384,480,120,20);        
        jbtnLimpiar.setBounds(514,480,120,20);
        
        jtxfNombres = new JTextField();
        jtxfApPaterno = new JTextField();
        jtxfApMaterno = new JTextField();        
        jrbtFemenino = new JRadioButton("Femenino");
        jrbtMasculino = new JRadioButton("Masculino");
        jtxfEdad = new JTextField();
        jtxfFechaDeNacimiento = new JTextField();
        jtxfDNI = new JTextField();
        jtxfDireccion = new JTextField();
        jtxfTelefono = new JTextField();
        jtxfEmail = new JTextField();
        jpsfContraseña=new JPasswordField();
        
        jtxfNombres.setBounds(427,150,150,18);
        jtxfApPaterno.setBounds(427,175,150,18);
        jtxfApMaterno.setBounds(427,200,150,18);
        jrbtMasculino.setBounds(420,225,100,20);
        jrbtFemenino.setBounds(500,225,100,20);        
        jtxfEdad.setBounds(427,250,150,18);
        jtxfFechaDeNacimiento.setBounds(427,275,150,18);
        jtxfDNI.setBounds(427,300,150,18);
        jtxfDireccion.setBounds(427,325,150,18);
        jtxfTelefono.setBounds(427,350,150,18);
        jtxfEmail.setBounds(427,375,150,18);
        jpsfContraseña.setBounds(427,400,150,18);
        
        jrbtFemenino.setOpaque(false);
        jrbtMasculino.setOpaque(false);

        jrbtFemenino.addActionListener(this);
        jrbtMasculino.addActionListener(this);
        jbtnRegistrar.addActionListener(this);
        jbtnRegresar.addActionListener(this);
        jbtnLimpiar.addActionListener(this);
        
        this.add(jlblTitulo);
        this.add(jlblInstrucciones);
        this.add(jlblNombres);
        this.add(jlblApPaterno);
        this.add(jlblApMaterno);
        this.add(jlblFechaDeNaciemiento);
        this.add(jlblEdad);
        this.add(jlblSexo);
        this.add(jlblDNI);
        this.add(jlblDireccion);
        this.add(jlblTelefono);
        this.add(jlblEmail);
        this.add(jlblContraseña);
        this.add(jlblMensaje);
        this.add((jtxfNombres));
        this.add(jtxfApPaterno);
        this.add(jtxfApMaterno);
        this.add(jtxfEdad);
        this.add(jtxfFechaDeNacimiento);
        this.add(jtxfDNI);
        this.add(jtxfDireccion);
        this.add(jtxfTelefono);
        this.add(jtxfEmail);
        this.add(jpsfContraseña);
        this.add(jrbtFemenino);
        this.add(jrbtMasculino);
        this.add(jbtnRegistrar);
        this.add(jbtnRegresar);
        this.add(jbtnLimpiar);

    }
    
    @Override
    public void run(){
    }
    
    public boolean esNumero(String cad){//verifica si una cadena es numerica
        boolean es=true;        
        try{
            Integer.parseInt(cad);
        }catch(NumberFormatException e){
            es=false;
        }
        return es;
        
    }
        
    public boolean validarDatos(){        
        boolean error1= true;//error de campos vacios
        boolean error2=true;//error de tipo de dato
        String mensaje = "",mensaje2="Los siguientes campos deben ser numericos:\n";
        
        //nombres
        if(jtxfNombres.getText().trim().length()==0){
            error1 = false;
            mensaje+="\n Nombre";
        }else
            p.setNombre(jtxfNombres.getText());
        
        //Apellido Paterno
        if(jtxfApPaterno.getText().trim().length()==0){
            error1 = false;
            mensaje+="\n Apellido Paterno";
        }else
            p.setApPaterno(jtxfApPaterno.getText());
        
        //Apellido Materno
        if(jtxfApMaterno.getText().trim().length()==0){
            error1 = false;
            mensaje+="\n  Apellido Materno";
        }else
            p.setApMaterno(jtxfApMaterno.getText());
        
        //Sexo
        if(!jrbtFemenino.isSelected() && !jrbtMasculino.isSelected()){
            error1 = false;
            mensaje+="\n Sexo";
        }else
            p.setSexo(jrbtFemenino.isSelected()?"Femenino":"Masculino");
        
        //Fecha de Nacimiento
        if(jtxfFechaDeNacimiento.getText().trim().length()==0){
            error1 = false;
            mensaje+="\n Fecha de Nacimiento";
        }else
            p.setFechaDeNacimiento(jtxfFechaDeNacimiento.getText());
        
        //edad
        if(jtxfEdad.getText().trim().length()==0 ){
            error1 = false;
            mensaje+="\n Edad";
        }else{
            if(esNumero(jtxfEdad.getText()))
                p.setEdad(Integer.parseInt(jtxfEdad.getText()));
            else{
                mensaje2+=" Edad\n";
                error2=false;
            }
        }
        
        //DNI
        if( jtxfDNI.getText().trim().length()==0){
            error1 = false;
            mensaje+="\n DNI";
        }else
            if(esNumero(jtxfDNI.getText()))
                p.setDNI(Integer.parseInt(jtxfDNI.getText()));
            else{                
                mensaje2+=" DNI\n";
                error2=false;
            }
                
        //Direccion
        if( jtxfDireccion.getText().trim().length()==0  ){
            error1 = false;
            mensaje+="\n Direccion";
        }else
            p.setDireccion(jtxfDireccion.getText());
        
        //Telefono
        if(jtxfTelefono.getText().trim().length()==0 ){
            error1 = false;
            mensaje+="\n Telefono";
        }else
            if(esNumero(jtxfTelefono.getText()) )
                p.setTelefono(Integer.parseInt(jtxfTelefono.getText()));
            else{
                mensaje2+=" Telefono\n";
                error2=false;
            }

        //email
        if(jtxfEmail.getText().trim().length()==0 ){
            error1 = false;
            mensaje+="\n Email";
        }else
            p.setEmail(jtxfEmail.getText());
        
        //contraseña
        if(jpsfContraseña.getPassword().toString().trim().length()==0 ){
            error1 = false;
            mensaje+="\n Contraseña";
        }else
            p.setContraseña(String.valueOf(jpsfContraseña.getPassword()));
        
        
        if(!error1){
            JOptionPane.showMessageDialog(null,"Los siguiente campos estan vacios:"+mensaje+
            "\nPor favor, proceda a llenarlos para concretar su registro","Validando el Formulario",
            JOptionPane.WARNING_MESSAGE);
        }
        if(!error2){            
            JOptionPane.showMessageDialog(null,mensaje2+"\nPor favor corrijalos para concretar su registro","Validando el Formulario",
            JOptionPane.WARNING_MESSAGE);
        }
        
        return error1 && error2;
    }
    
    public void limpiar(){
        jtxfNombres.setText("");
        jtxfApPaterno.setText("");
        jtxfApMaterno.setText("");
        jtxfFechaDeNacimiento.setText("");
        jtxfEdad.setText("");
        jrbtFemenino.setSelected(false);
        jrbtMasculino.setSelected(false);
        jtxfDNI.setText("");
        jtxfDireccion.setText("");
        jtxfTelefono.setText("");
        jtxfEmail.setText("");
        jpsfContraseña.setText("");
    }
    
    public void  EfectuarRegistro() throws Exception{
        int opc=JOptionPane.showOptionDialog(null,"Verifique la informacion ingresada:"+p.mostrarDatos()+"\n¿Desea concretar su registro?","Validando el Formulario",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null,null,null);
        boolean flag;
        if(opc==0){//SI
            p.setValido((short)1);
            admin=new Administrador();
            flag=admin.archivar(P, p);
            if(flag){
                JOptionPane.showMessageDialog(null,"Se ha registrado el Paciente con exito","Registro Exitoso",JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Administrador");
            }
            else
                JOptionPane.showMessageDialog(null,"Se ha producido un error al archivar al paciente","Registro Fallido",JOptionPane.ERROR_MESSAGE);
                
          
        }

        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == jrbtFemenino){
            jrbtMasculino.setSelected(false);
        }
        
        if(e.getSource() == jrbtMasculino){
            jrbtFemenino.setSelected(false);
        }
        
        if(e.getSource() == jbtnRegistrar){            
            if(validarDatos())
                try{
                    EfectuarRegistro();
                }catch(Exception ex){
                     JOptionPane.showMessageDialog(null,"Error al realizar el Registro,"
                      + " por favor reincie el programa","Error de Registro",JOptionPane.ERROR_MESSAGE);
                }
        }
        
        if(e.getSource() == jbtnRegresar){           
            ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Administrador");            
            limpiar();
        }
        
        if(e.getSource() == jbtnLimpiar){                       
            limpiar();
        }
        
    }    
}