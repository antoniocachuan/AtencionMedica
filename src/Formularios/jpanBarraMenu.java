
package Formularios;

import javax.swing.*;
import java.io.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu.Separator;
import java.awt.Desktop;

public class jpanBarraMenu extends jpanFondo implements ActionListener{
        
    private JMenuBar jmnbBarra;
    private JMenu jmnArchivo,jmnAyuda,jmnPaciente; //pestañas de la barra
    private JMenuItem jmniInciarSesion, jmniCerrarSesion,jmniSalir;//opciones de la pestaña archivo
    private JMenuItem jmniManual, jmniAcercaDe;//opciones de la pestaña Ayuda
    private JMenuItem jmniHome,jmniHistorial, jmniCitas, jmniMedicos;
    File Ac,Manual ;
    private jpanFondo jpanelFondo;

    public jpanBarraMenu(jpanFondo jpanelFondo,File Ac,File Manual) {
        this.jpanelFondo = jpanelFondo;
        this.Ac=Ac;
        this.Manual=Manual;
        iniciarComponentes();
    }

    public void iniciarComponentes(){
        this.setLayout(null);

        jmnbBarra = new JMenuBar();
        jmnbBarra.setBounds(0,0,874,20);

        //Pestañas
        jmnArchivo = new JMenu("Archivo");
        jmnAyuda = new JMenu("Ayuda");
        jmnPaciente = new JMenu("Paciente");
        jmnPaciente.setEnabled(false);
        //opciones de la pestaña Archivo
        jmniInciarSesion = new JMenuItem("Iniciar Sesion");  //instancia de la barra de menu JMenuIteam de javax.swing
        jmniInciarSesion.setIcon(imagen( "logIn.png"));        
        jmniCerrarSesion = new JMenuItem("Cerrar Sesion");
        jmniCerrarSesion.setIcon(imagen("logOut.png"));        
        jmniCerrarSesion.setEnabled(false);
        
        jmniSalir = new JMenuItem("Salir");
        jmniSalir.setIcon(imagen("exit.png"));

        //opciones de la pestaña Ayuda
        jmniManual=new JMenuItem("Ver Manual");
        jmniManual.setIcon(imagen("manual.png"));  
        jmniAcercaDe=new JMenuItem("Acerca de este Software");        
        jmniAcercaDe.setIcon(imagen("about.png"));  
        
        //opciones de la pestaña Paciente
        jmniHome=new JMenuItem("Principal");
        jmniHome.setIcon(imagen("home.png"));
        jmniHistorial=new JMenuItem("Historial");
        jmniHistorial.setIcon(imagen("historial.png")); 
        jmniCitas=new JMenuItem("Citas");        
        jmniCitas.setIcon(imagen("citas.png"));  
        jmniMedicos=new JMenuItem("Medicos");   
        jmniMedicos.setIcon(imagen("medicos.png"));  
        
        //"escuchar" el mouse
        jmniInciarSesion.addActionListener(this);
        jmniCerrarSesion.addActionListener(this);
        jmniSalir.addActionListener(this);   
        jmniHome.addActionListener(this);   
        jmniHistorial.addActionListener(this); 
        jmniCitas.addActionListener(this); 
        jmniMedicos.addActionListener(this); 
        jmniManual.addActionListener(this); 
        //añadir opciones a las pestañas de la barra de menu

        jmnArchivo.add(jmniInciarSesion);
        jmnArchivo.add(new Separator());
        jmnArchivo.add(jmniCerrarSesion);
        jmnArchivo.add(new Separator());
        jmnArchivo.add(jmniSalir); 
        
        jmnAyuda.add(jmniManual);         
        jmnAyuda.add(new Separator());
        jmnAyuda.add(jmniAcercaDe);
        
        jmnPaciente.add(jmniHome);        
        jmnPaciente.add(new Separator());
        jmnPaciente.add(jmniHistorial);
        jmnPaciente.add(new Separator());
        jmnPaciente.add(jmniCitas);
        jmnPaciente.add(new Separator());
        jmnPaciente.add(jmniMedicos);
        //añadir pestañas(menu) a la barra

        jmnbBarra.add(jmnArchivo);
        jmnbBarra.add(jmnPaciente);
        jmnbBarra.add(jmnAyuda);

        this.add(jmnbBarra);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == jmniInciarSesion){
            ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Acceso");
        }
        
        if(e.getSource() == jmniCerrarSesion){
            this.cambiarEstadoDeLaBarraDesconectado();
            Ac.delete();
            ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Portada");
        }
        
        if(e.getSource() == jmniSalir){
            int opc = JOptionPane.showConfirmDialog(null,"Desea salir del sistema","Salir",JOptionPane.YES_NO_OPTION);
            if(opc == 0)
            System.exit(0);
        }
                
        if(e.getSource() == jmniHome){
            ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Paciente");
        }

        if(e.getSource() == jmniHistorial){
            ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Historial");
        }
        
        if(e.getSource() == jmniCitas){
            ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Citas");
        }
        
        if(e.getSource() == jmniMedicos){
            ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Medicos");
        }
        
        if(e.getSource() == jmniManual){
            try {
                Desktop.getDesktop().open(Manual);
            } catch(IllegalArgumentException exc) {
               JOptionPane.showMessageDialog(null,"El Manual no esta Disponible","Error",JOptionPane.ERROR_MESSAGE);//,imagen("manualNoDisponible.png"));            }
            }catch(IOException e2){
               JOptionPane.showMessageDialog(null,"No tiene ningun lector de pdf instalado\nPor favor Instale uno para poder visualizar el manual","Error",JOptionPane.ERROR_MESSAGE);//,imagen("manualNoDisponible.png"));            } 
            }
 
        }        
    }

    public void cambiarEstadoDeLaBarraConectado(){
        jmniCerrarSesion.setEnabled(true);
        jmniInciarSesion.setEnabled(false);
        jmnPaciente.setEnabled(true);
    }
    
    public void cambiarEstadoDeLaBarraDesconectado(){
        jmniCerrarSesion.setEnabled(false);
        jmniInciarSesion.setEnabled(true);        
        jmnPaciente.setEnabled(false);
    }
}
