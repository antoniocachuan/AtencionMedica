
package Formularios;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.CardLayout;

public class jfrmPrincipal extends JFrame {
    //ventanas
    private jpanFondo jpanelFondo;//panel en donde se posicionan los demas paneles
    private jpanBarraMenu jpanelBarra;
    private jpanPortada jpanelPortada;
    private jpanAccederUsuario jpanelAccederUsuario;
    private jpanRegistrarUsuario jpanelRegistrarUsuario;
    private jpanPaciente jpanelPaciente;
    private jpanAdministrador jpanelAdministrador;
    private jpanMedicos jpanelMedicos;
    private jpanHistorial jpanelHistorial;
    private jpanCitas jpanelCitas;
    
    //archivos
    private File Pacientes,Administradores,Actual,Doctores,Manual;
    
    
    public jfrmPrincipal(){
        //archivos en paquete, funciona en netbeans, pero no en .jar
        Pacientes=new File("src\\Archivos\\Pacientes.dat");     
        Administradores=new File("src\\Archivos\\Administradores.dat");
        Actual=new File("src\\Archivos\\PersonaActual.dat");
        Doctores=new File("src\\Archivos\\Doctores.dat");
        Manual= new File("src\\Archivos\\manual.pdf");
        
        //, funciona en netbeans, pero no en .jar
       /* Pacientes=new File(archivo("Pacientes.dat"));     
        Administradores=new File(archivo("Administradores.dat"));
        Actual=new File(archivo("PersonaActual.dat"));
        Doctores=new File(archivo("Doctores.dat"));
        Manual=new File(archivo("Manual.dat"));*/
        
        //archivos relativos(funciona en ambos, pero hay q guardarlos antes de generar en .jar
       /* Pacientes=new File("Pacientes.dat");     
        Administradores=new File("Administradores.dat");
        Actual=new File("PersonaActual.dat");
        Doctores=new File("Doctores.dat")
        Manual=new File("Manual.dat")*/
        
        
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        this.setTitle("Software Atencion a Pacientes");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png")));
        this.setResizable(false); 
        this.setSize(880,660);//(400,470);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        jpanelFondo = new jpanFondo();
        jpanelFondo.setBounds(0,20,874,612);
        jpanelFondo.setLayout(new CardLayout());
        
        jpanelBarra = new jpanBarraMenu(jpanelFondo,Actual,Manual);
        jpanelBarra.setBounds(0,0,874,20);
     
        jpanelPortada = new jpanPortada(jpanelFondo);
        valoresPanel(jpanelPortada,"Portada");
        
        jpanelPaciente = new jpanPaciente(jpanelFondo,Actual,Pacientes);
        valoresPanel(jpanelPaciente,"Paciente");   
        
        jpanelAccederUsuario = new jpanAccederUsuario(jpanelFondo,jpanelBarra,jpanelPaciente,Pacientes,Administradores,Actual);
        valoresPanel(jpanelAccederUsuario,"Acceso");

        jpanelRegistrarUsuario = new jpanRegistrarUsuario(jpanelFondo,Pacientes,Administradores);
        valoresPanel(jpanelRegistrarUsuario,"Registro");
        
        
        jpanelAdministrador = new jpanAdministrador(jpanelFondo);
        valoresPanel(jpanelAdministrador,"Administrador");  
        
        jpanelMedicos=new jpanMedicos(jpanelFondo,Doctores);
        valoresPanel(jpanelMedicos,"Medicos");
        
        
        jpanelHistorial=new jpanHistorial(jpanelFondo);
        valoresPanel(jpanelHistorial,"Historial");
        
        
        jpanelCitas=new jpanCitas(jpanelFondo);
        valoresPanel(jpanelCitas,"Citas");
        
        this.add(jpanelFondo);
        this.add(jpanelBarra);

 
        
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
    public void valoresPanel(jpanFondo panelReferencia, String nombre){
        jpanelFondo.add(panelReferencia,nombre);
        panelReferencia.setBackground(new Color(255,255,255));//color de las ventanas
        
    }
   
    public static void main(String[] args) {
       new jfrmPrincipal().setVisible(true);

    }
    /*
    public String archivo(String cad){
        String ruta=getClass().getResource("/Archivos/"+cad).toString().substring(6);
        for(int i=0;i<ruta.length()-2;i++){
            if(ruta.substring(i,i+3).equals("%20")){
                ruta=ruta.substring(0,i)+" "+ruta.substring(i+3,ruta.length());
            }
        }
        return ruta;
    }*/
}
