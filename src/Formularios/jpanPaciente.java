
package Formularios;

import ClasesPrincipales.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.io.*;

public class jpanPaciente extends jpanFondo implements ActionListener,Runnable{
    
    private Paciente P;
    private jpanFondo jpanelFondo;
    private JLabel jFoto;
    private JScrollPane jscrpanMostrar;
    private jlblFondo encabezado;
    private JTable jtabMostrar;
    private JLabel jlblInfo;
    private JButton jbtnIR,jbtnCambioPas;
    private JSeparator jSepara;
    private JRadioButton jrbtHistorial,jrbtCitas,jrbtMedicos;
    private File PA;
    private File p;
    
    public jpanPaciente(jpanFondo fondo,File PA,File p){
        this.jpanelFondo = fondo;
        this.PA=PA;
        this.p=p;
        iniciarComponentes();
    }

    public void iniciarComponentes(){

        this.setLayout(null);
        encabezado = new jlblFondo();
        this.add(encabezado);

        jFoto = new JLabel();
        jFoto.setIcon(imagen("fotos/fotoDefault.png"));

        jrbtHistorial = new JRadioButton(" Historial Medico");
        jrbtCitas = new JRadioButton(" Registro de Citas ");
        jrbtMedicos = new JRadioButton(" Medicos ");
        jbtnCambioPas = new JButton(" Cambiar Contraseña ");
        jbtnIR = new JButton("IR");
        jscrpanMostrar = new JScrollPane();
        jtabMostrar = new JTable();
        jlblInfo=new JLabel();
        jlblInfo.setIcon(imagen("infoDefault.png"));
        
        jSepara = new JSeparator();
        jtabMostrar.setModel(new DefaultTableModel(new Object[][]{
            {"NOMBRE:",null},
            {"APELLIDO PATERNO:",null},
            {"APELLIDO MATERNO:",null},
            {"DNI:",null},
            {"SEXO:",null},
            {"FECHA NACIMIENTO",null},
            {"DIRECCION",null},
            {"TELEFONO",null},
            {"EMAIL",null},
        },
                new String []{"","DATOS PERSONALES"}
        ));
        jtabMostrar.getColumn("").setPreferredWidth(10); //Obtienes la columna        
        jtabMostrar.getColumn("DATOS PERSONALES").setPreferredWidth(150); //Obtienes la columna
        jtabMostrar.setTableHeader(null);
        jtabMostrar.setRowHeight(18);
        
        jscrpanMostrar.setViewportView(jtabMostrar);
        jFoto.setBorder(LineBorder.createGrayLineBorder());
        
        jFoto.setBounds(155,100,150,164);  
        jscrpanMostrar.setBounds(320,100,400,165);  
        jbtnCambioPas.setBounds(550,275,170,25);
        jSepara.setBounds(155,315,564,1);
        jlblInfo.setBounds(155,334,564,197);
        jbtnIR.setBounds(620,500,85,20);
        
        jrbtHistorial.setBounds(160,339,180,20);
          jrbtHistorial.setIcon(imagen("historial.png"));
          jrbtHistorial.setForeground(new Color(255,255,255));
        jrbtCitas.setBounds(160,370,180,20);
          jrbtCitas.setIcon(imagen("citas.png"));        
          jrbtCitas.setForeground(new Color(255,255,255));
        jrbtMedicos.setBounds(160,401,180,20); 
          jrbtMedicos.setIcon(imagen("medicos.png"));  
          jrbtMedicos.setForeground(new Color(255,255,255));
          
        jbtnCambioPas.addActionListener(this);
        jrbtHistorial.addActionListener(this);
        jrbtCitas.addActionListener(this);
        jrbtMedicos.addActionListener(this);
        jbtnIR.addActionListener(this);

        jtabMostrar.setEnabled(false);
        jscrpanMostrar.setEnabled(false);
        jrbtHistorial.setOpaque(false);
        jrbtCitas.setOpaque(false);
        jrbtMedicos.setOpaque(false);
        jbtnIR.setVisible(false);

        this.add(jFoto);
        this.add(jrbtHistorial);
        this.add(jrbtCitas);
        this.add(jrbtMedicos);
        this.add(jbtnIR);
        this.add(jscrpanMostrar);
        this.add(jlblInfo);
        this.add(jbtnCambioPas);
        this.add(jSepara);

    }

    public void RecuperarDatos(){
        P = new Paciente();
        File PA=new File("src\\Archivos\\PersonaActual.dat");
        RandomAccessFile a;
        try{
            a=new RandomAccessFile(PA,"rw");
            P.leerDatos(a);
            jtabMostrar.setValueAt(P.getNombre(),0,1);
            jtabMostrar.setValueAt(P.getApPaterno(),1,1);
            jtabMostrar.setValueAt(P.getApMaterno(),2,1);
            jtabMostrar.setValueAt(P.getDNI(),3,1);
            jtabMostrar.setValueAt(P.getSexo(),4,1);
            jtabMostrar.setValueAt(P.getFechaDeNacimiento(),5,1);
            jtabMostrar.setValueAt(P.getDireccion(),6,1);
            jtabMostrar.setValueAt(P.getTelefono(),7,1);
            jtabMostrar.setValueAt(P.getEmail(),8,1);
            a.close();
            jFoto.setIcon(imagen("fotos/"+P.getDNI()+".png"));
        }catch(Exception e){

        }
        
        
    }
    



    @Override
    public void actionPerformed(ActionEvent e) {

        String pass2;
       // File R1 = new File("src\\Archivos\\Pacientes.dat");
        RandomAccessFile b;
        Paciente P1 = new Paciente();
        if(e.getSource() == jbtnCambioPas){
            if (0 == JOptionPane.showConfirmDialog(this,"¿Seguro que desea cambiar su contraseña ?")){
                pass2=JOptionPane.showInputDialog(" INGRESE SU NUEVA CONTRASEÑA CONTRASEÑA ");
                                
                try{
                    b = new RandomAccessFile(p,"rw");
                    P1.leerDatos(b);
                    P.setContraseña(pass2);
                    if(P1.posicionarPunteroRecuperar(b,P)){
                        P.grabarDatos(b);
                        b.close();
                    }else{
                       b.close();
                    }
                }catch(Exception d){

                }

            }

        }

        if(e.getSource() == jrbtHistorial){
            if(!jrbtHistorial.isSelected()) {
                //jbtnIR.setEnabled(false);
                jbtnIR.setVisible(false);
                jlblInfo.setIcon(imagen("infoDefault.png"));
            }else{
                //jbtnIR.setEnabled(true);
                //Historial_Medico HM= new Historial_Medico(null, true,P.getDNI());
                //HM.setVisible(true);
                jbtnIR.setVisible(true);
                jlblInfo.setIcon(imagen("infoHistorial.png"));
            }
            jrbtMedicos.setSelected(false);
            jrbtCitas.setSelected(false);

        }
        
        if(e.getSource() == jrbtMedicos){            
            if(!jrbtMedicos.isSelected()){
                jlblInfo.setIcon(imagen("infoDefault.png"));
                //jbtnIR.setEnabled(false);
                jbtnIR.setVisible(false);                
            }else{
                //jbtnIR.setEnabled(true);                
                jbtnIR.setVisible(true);
                jlblInfo.setIcon(imagen("infoMedicos.png"));                
            }
            jrbtHistorial.setSelected(false);
            jrbtCitas.setSelected(false);
        }
        
        if(e.getSource() == jrbtCitas){
            if(!jrbtCitas.isSelected()){
                jlblInfo.setIcon(imagen("infoDefault.png"));
                //jbtnIR.setEnabled(false);
                jbtnIR.setVisible(false);
            }else{
                //jbtnIR.setEnabled(true);                
                jbtnIR.setVisible(true);
                jlblInfo.setIcon(imagen("infoCitas.png"));
            }
            jrbtHistorial.setSelected(false);
            jrbtMedicos.setSelected(false);

        }

        if(e.getSource() == jbtnIR){
            if(jrbtHistorial.isSelected()){
                ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Historial");
            }
            if(jrbtMedicos.isSelected()){
                ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Medicos");
            }
            if(jrbtCitas.isSelected()){
                ((CardLayout)jpanelFondo.getLayout()).show(jpanelFondo,"Citas");
            }
            jbtnIR.setEnabled(false);
            jrbtHistorial.setSelected(false);
            jrbtCitas.setSelected(false);
            jrbtMedicos.setSelected(false);
            jlblInfo.setIcon(imagen("infoDefault.png"));
            
        }

    }


}