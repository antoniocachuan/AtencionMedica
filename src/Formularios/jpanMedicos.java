
//Antonio 

package Formularios;

import ClasesPrincipales.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class jpanMedicos  extends jpanFondo implements ActionListener,Runnable{
    private jpanFondo jpanelFondo;//panel base    
    private jlblFondo fondo; ;
    
    private JLabel jlblTitulo;
    private JLabel Horarios;
    private JLabel Votacion;
    
    private JComboBox jComboBoxEspecialidades;
    private JComboBox jComboBoxDoctores;
    private JLabel jLabelEspecialidad;
    private JLabel jLabelDoctores;
    private JLabel jLabelCita;
    private JLabel jLabelHorario;
    private JSeparator jSeparatorVentana;
    private JSeparator jSeparator2;
    private JButton jButtonMostrar;
    private JTextField jTextFieldCita;
    private JLabel auxLabel;
    private JTable jTableDoc;
    private JScrollPane jDoc;
    private JLabel jCalificacion;
    private JButton satisfaccion;
    private JButton insatisfaccion;
    
    private Doctor D[];
    private Doctor Auxiliar;
    
    private File Doctores,aux;
    
   // RandomAccessFile mfa2 = null;
    
    public jpanMedicos(jpanFondo fondo,File D){
        this.jpanelFondo = fondo;
        Doctores=D;//
        Auxiliar=new Doctor();
        generarDoctores();
        iniciarComponentes();
        
    }
    
    public void iniciarComponentes(){
        auxLabel=new JLabel();
        Votacion=new JLabel();
        jComboBoxEspecialidades = new JComboBox();
        jComboBoxDoctores = new JComboBox();
        jSeparatorVentana=new JSeparator();
        jDoc=new JScrollPane();
        jTableDoc=new JTable();
        satisfaccion=new JButton();
       insatisfaccion=new JButton();
        
        generaCombo1();
      /*  jTableDoc.setModel(new DefaultTableModel(new Object[][]{
            {"NOMBRE",null},
            {"APELLIDO",null},
            {"ESPECIALIDAD",null},
            {"CMP",null},
            {"CALIFICACION",null}
        },
                new String []{"DATOS","DOCTOR"}
        ));*/
        
      
        this.setLayout(null);
        fondo = new jlblFondo();
        this.add(fondo);
        
        jButtonMostrar=new JButton();
        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.setBounds(55, 370, 100, 20);
        jButtonMostrar.setEnabled(false);
        this.add(jButtonMostrar);
        
        jSeparatorVentana.setForeground(new java.awt.Color(51, 51, 255));
        jSeparatorVentana.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparatorVentana.setBounds(230, 130, 110, 390);
        this.add(jSeparatorVentana);
        
        jlblTitulo=new JLabel("Modulo de Medicos");
        jlblTitulo.setBounds(350,50,200,50);
        this.add(jlblTitulo);
        
        jLabelEspecialidad=new JLabel("Especialidad");
        jLabelEspecialidad.setText("Especialidad");
        jLabelEspecialidad.setBounds(30, 180, 120, 20);
        this.add(jLabelEspecialidad);
        
        jLabelDoctores=new JLabel("Doctores");
        jLabelDoctores.setText("Doctores");
        jLabelDoctores.setBounds(30, 260, 120, 20);
        jComboBoxDoctores.setEnabled(false);
        this.add(jLabelDoctores);
        
        jComboBoxDoctores.setBounds(30, 280, 150, 20);
       // jComboBoxDoctores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cardiologia", "Oncologia", "Neumologia", "Odontologia", "Gastroenterologia", "Urologia", "Reumatologia" }));
        this.add(jComboBoxDoctores);
        this.add(jComboBoxEspecialidades);
        
        
    
        
         //ActivaCombo2((String) jComboBoxEspecialidades.getSelectedItem());
     
        
        
        
        //ActivaCombo3((String) jComboBoxDoctores.getSelectedItem());
        satisfaccion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisfaccionActionPerformed(evt);
            }
            });
         insatisfaccion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insatisfaccionActionPerformed(evt);
            }
            });
       // this.add(satisfaccion);
    }
    
    public void generaCombo1(){
        jComboBoxEspecialidades.removeAllItems();
        jComboBoxEspecialidades.setBounds(30, 200, 150, 20);
        jComboBoxEspecialidades.addItem("");
        jComboBoxEspecialidades.addItem("Cardiologia");
        jComboBoxEspecialidades.addItem("Oncologia");
        jComboBoxEspecialidades.addItem("Neumologia");
        jComboBoxEspecialidades.addItem("Odontologia");
        jComboBoxEspecialidades.addItem("Gastroenterologia");
        jComboBoxEspecialidades.addItem("Urologia");
        jComboBoxEspecialidades.addItem("Reumatologia");
        jComboBoxEspecialidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ActivaCombo2((String) jComboBoxEspecialidades.getSelectedItem());
            }
         });
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
           
    }
        
    public void generarDoctores(){
        boolean aux=false;
        D=new Doctor[21];
        D[0]=new Doctor("Cardiologia","Angela","Rojas","Rodriguez",1,10500,0);
        D[1]=new Doctor("Cardiologia","Braulio","Borjas","Santiago",1,10600,1);
        D[2]=new Doctor("Cardiologia","Claudia","Camacho","Lincol",1,10700,2);
        D[3]=new Doctor("Oncologia","Cesar","Caceres","Valle",1,10800,3);
        D[4]=new Doctor("Oncologia","Erick","Lopez","Paredes",1,10900,4);
        D[5]=new Doctor("Oncologia","Antonio","Cachuan","Alipazaga",1,11000,5);
        D[6]=new Doctor("Neumologia","Martin","Smith","Sanchez",1,11100,6);
        D[7]=new Doctor("Neumologia","Emilio","Contreras","Ramirez",1,11200,7);
        D[8]=new Doctor("Neumologia","Alexandra","Montes","Reto",1,11300,8);
        D[9]=new Doctor("Odontologia","Tomas","Salsedo","Pecho",1,11400,9);
        D[10]=new Doctor("Odontologia","Ines","Perez","Berrio",1,11500,10);
        D[11]=new Doctor("Odontologia","Flavio","Medrano","Salazar",1,11600,11);
        D[12]=new Doctor("Gastroenterologia","Brian","Medina","Regalado",1,11700,12);
        D[13]=new Doctor("Gastroenterologia","Rocio","Salgado","Noli",1,11800,13);
        D[14]=new Doctor("Gastroenterologia","Eduardo","Flores","Flores",1,11900,14);
        D[15]=new Doctor("Urologia","Dayanna","Palomino","Gonzaga",1,12000,15);
        D[16]=new Doctor("Urologia","Gonzalo","Rios","Saldarriaga",1,12100,16);
        D[17]=new Doctor("Urologia","Krystel","Garcia","Rivera",1,12200,17);
        D[18]=new Doctor("Reumatologia","Pedro","Chavez","Prado",1,12300,18);
        D[19]=new Doctor("Reumatologia","Pamela","Vargas","Leon",1,12400,19);
        D[20]=new Doctor("Reumatologia","Sharon","Campos","Trujillo",1,12500,20);
        for(int i=0;i<D.length;i++){
               aux=archivar(D[i]);
        }
     
   /*     try {
            generarArchivos();
        } catch (IOException ex) {
            Logger.getLogger(jpanMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void generarArchivos() throws IOException {
        
        for(int i=0;i<D.length;i++){
             mfa2.writeUTF(D[i].getNombre());
             mfa2.writeUTF(D[i].getApPaterno());
             mfa2.writeUTF(D[i].getApMaterno());   
             mfa2.writeInt(D[i].getCalificacion());   
        }
    */
    }
    
    
     public boolean archivar(Doctor Doc){
        boolean estado=true;
        try{
            RandomAccessFile mfa2=new RandomAccessFile(Doctores,"rw"); 
            posicionarPunteroArchivar(mfa2,Doc);
            //for(i=0;i<D.length;i++){
           //     D[i].grabarDatos(mfa2);
           //     System.out.println("salde");
           // }
            Doc.grabarDatos(mfa2);
        }catch(IOException e){
            System.out.println(e.getMessage()+e.toString());
            estado=false;
        }
        return estado;        
    }
     
   public void posicionarPunteroArchivar(RandomAccessFile mfa,Doctor Doc)throws IOException{
       int pos;
       pos=Doc.getClave();
       
       mfa.seek(Doc.dezplasamiento(pos)); 
       //try{
          // valido=mfa.readShort();
          // while(valido==1){
            //   pos++;
            //   mfa.seek(p.dezplasamiento(pos));
            //   valido=mfa.readShort();
         //  }
       //}catch(EOFException e){
       //    mfa.seek(p.dezplasamiento(pos));
      // }
    }  
     
     
    public void ActivaCombo2(String SeleccionCombo1){
        jComboBoxDoctores.removeAllItems(); 
        
        
       if(SeleccionCombo1.equals("Cardiologia")){
            
            jButtonMostrar.setEnabled(true);
            jComboBoxDoctores.setEnabled(true);
            jComboBoxDoctores.addItem("");
            jComboBoxDoctores.addItem("Angela Rojas R.");
            jComboBoxDoctores.addItem("Braulio Borjas S.");
            jComboBoxDoctores.addItem("Claudia Camacho L.");    
        }
        if(SeleccionCombo1.equals("Oncologia")){
            jButtonMostrar.setEnabled(true);
            jComboBoxDoctores.setEnabled(true);
            jComboBoxDoctores.addItem("");
            jComboBoxDoctores.addItem("Cesar Caceres V.");
            jComboBoxDoctores.addItem("Erick Lopez P.");
            jComboBoxDoctores.addItem("Antonio Cachuan A.");
        }
        if(SeleccionCombo1.equals("Neumologia")){
            jButtonMostrar.setEnabled(true);
            jComboBoxDoctores.setEnabled(true);
            jComboBoxDoctores.addItem("");
            jComboBoxDoctores.addItem("Martin Smith S.");
            jComboBoxDoctores.addItem("Emilio Contreras R.");
            jComboBoxDoctores.addItem("Alexandra Montes R.");
        }
        if(SeleccionCombo1.equals("Odontologia")){
            jButtonMostrar.setEnabled(true);
            jComboBoxDoctores.setEnabled(true);
            jComboBoxDoctores.addItem("");
            jComboBoxDoctores.addItem("Tomas Salsedo P.");
            jComboBoxDoctores.addItem("Ines Peres B.");
            jComboBoxDoctores.addItem("Flavio Medrano R.");
        }
        if(SeleccionCombo1.equals("Gastroenterologia")){
            jButtonMostrar.setEnabled(true);
            jComboBoxDoctores.setEnabled(true);
            jComboBoxDoctores.addItem("");
            jComboBoxDoctores.addItem("Brian Medina R.");
            jComboBoxDoctores.addItem("Rocio Salgado N.");
            jComboBoxDoctores.addItem("Eduardo Flores F.");
        }
        if(SeleccionCombo1.equals("Urologia")){
            jButtonMostrar.setEnabled(true);
            jComboBoxDoctores.setEnabled(true);
            jComboBoxDoctores.addItem("");
            jComboBoxDoctores.addItem("Dayanna Palomino G.");
            jComboBoxDoctores.addItem("Gonzalo Rios S.");
            jComboBoxDoctores.addItem("Krystel Garcia R.");
        }
         if(SeleccionCombo1.equals("Reumatologia")){
            jButtonMostrar.setEnabled(true);
            jComboBoxDoctores.setEnabled(true);
            jComboBoxDoctores.addItem("");
            jComboBoxDoctores.addItem("Pedro Chavez P.");
            jComboBoxDoctores.addItem("Pamela vargas L.");
            jComboBoxDoctores.addItem("Sharon Campos T.");
        }
         
         jComboBoxDoctores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent rg0) {
                ActivaCombo3((String) jComboBoxDoctores.getSelectedItem());
               
            }
            // Se rellenan los valores de combo2 iniciales.
            //ActivaCombo2((String) jComboBoxEspecialidades.getSelectedItem());
         });
         
    }
 
     public void ActivaCombo3(String SeleccionCombo2){ 
         Horarios=new JLabel();
      try{
            if(SeleccionCombo2.equals("Angela Rojas R.")){
                jButtonMostrar.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        Horarios.setIcon(imagen("medicos/h1.png"));
                        Horarios.setBounds(250,360,423,50);
                        auxLabel.setBorder(LineBorder.createGrayLineBorder());
                        auxLabel.setIcon(imagen("medicos/female22.png"));
                        auxLabel.setBounds(250,120,200,200);
                        ventanaDoctor();
                        RecuperarDoctor(0);
                    
                    }
                });
            }
         
         
         if(SeleccionCombo2.equals("Braulio Borjas S.")){
              
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h2.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctorH.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(1);
                }
            });
         }
         
          if(SeleccionCombo2.equals("medicos/Claudia Camacho L.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h3.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/female.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(2);
                }
            });
         }
         
         if(SeleccionCombo2.equals("Cesar Caceres V.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                     ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h4.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctorP.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(3);
                    
                }
            });
         }
         
         if(SeleccionCombo2.equals("Erick Lopez P.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h5.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctor1.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(4);
                }
            });
         }
         if(SeleccionCombo2.equals("Antonio Cachuan A.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h6.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctorP.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(5);
                }
            });
         }
         if(SeleccionCombo2.equals("Martin Smith S.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h1.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctorH.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(6);
                }
            });
         }
         if(SeleccionCombo2.equals("Emilio Contreras R.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h2.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctorH.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(7);
                }
            });
         }
         if(SeleccionCombo2.equals("Alexandra Montes R.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h3.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/female666.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(8);
                }
            });
         }
         if(SeleccionCombo2.equals("Tomas Salsedo P.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h4.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctor1.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(9);
                }
            });
         }
         if(SeleccionCombo2.equals("Ines Peres B.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h5.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/female22.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(10);
                }
            });
         }
         if(SeleccionCombo2.equals("Flavio Medrano R.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h6.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctorH.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(11);
                }
            });
         }
         if(SeleccionCombo2.equals("Brian Medina R.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                     Horarios.setIcon(imagen("medicos/h1.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctorP.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(12);
                }
            });
         }
         if(SeleccionCombo2.equals("Rocio Salgado N.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                     Horarios.setIcon(imagen("medicos/h2.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/female.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(13);
                }
            });
         }
         if(SeleccionCombo2.equals("Eduardo Flores F.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                     Horarios.setIcon(imagen("medicos/h3.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctorH.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(14);
                }
            });
         }
         if(SeleccionCombo2.equals("Dayanna Palomino G.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                     Horarios.setIcon(imagen("medicos/h5.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/female.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(15);
                }
            });
         }
         if(SeleccionCombo2.equals("Gonzalo Rios S.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h6.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctor1.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(16);
                }
            });
         }
         if(SeleccionCombo2.equals("Krystel Garcia R.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h1.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/female666.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(17);
                }
            });
         }
          if(SeleccionCombo2.equals("Pedro Chavez P.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h2.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/doctor1.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(18);
                }
            });
         }
         if(SeleccionCombo2.equals("Pamela vargas L.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h3.png"));
                    Horarios.setBounds(250,360,423,50);
                    auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/female22.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(19);
                }
            });
         }
          if(SeleccionCombo2.equals("Sharon Campos T.")){
            jButtonMostrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    ventanaDoctor();
                    Horarios.setIcon(imagen("medicos/h4.png"));
                    Horarios.setBounds(250,360,423,50);
                     auxLabel.setBorder(LineBorder.createGrayLineBorder());
                    auxLabel.setIcon(imagen("medicos/female666.png"));
                    auxLabel.setBounds(250,120,200,200);
                    RecuperarDoctor(20);
                }
            });
         }
         this.add(auxLabel);
         this.add(Horarios);
     
        }catch(NullPointerException e){
             generaCombo1();
         }
      }
     
     private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {
         
         System.out.println("sale");
    }
     
    public void ventanaDoctor(){
       
       this.add(insatisfaccion);
       this.add(satisfaccion);
       satisfaccion.setIcon(imagen("youtub.png"));
       satisfaccion.setBounds(480,530,27,23);
       insatisfaccion.setIcon(imagen("youtub2.png"));
       insatisfaccion.setBounds(520,530,27,23);
       
       
       jLabelCita=new JLabel();
       jLabelHorario=new JLabel();
       jCalificacion=new JLabel();
       jSeparator2=new JSeparator();
       this.add(jCalificacion);
       jCalificacion.setText("Puntuar");
       jCalificacion.setBounds(250,490,100,20);
       jCalificacion.setFont(new java.awt.Font("Arial", 1, 14)); 
       //jCalificacion.setVisible(true);
       
       jSeparator2.setOrientation(javax.swing.SwingConstants.HORIZONTAL);
        jSeparator2.setBounds(250, 520, 110, 390);
        jSeparator2.setForeground(new java.awt.Color(51, 51, 255));
        this.add(jSeparator2);
       
       this.add(jLabelHorario);
       this.add(jLabelCita);
       jLabelHorario.setText("Horario de atencion "/*+ (String) jComboBoxDoctores.getSelectedItem()*/);
       jLabelHorario.setBounds(250, 320, 280, 30);
       jLabelHorario.setFont(new java.awt.Font("Arial", 1, 16));
       jLabelCita.setFont(new java.awt.Font("Arial", 1, 12)); 
       jLabelCita.setText("Numero de cita");
       jLabelCita.setBounds(250, 530, 120, 20);
       
        jTextFieldCita=new JTextField();
        
         this.add(jTextFieldCita);
        jTextFieldCita.setBounds(380, 530, 80, 23);
        jTextFieldCita.setVisible(true);
        jLabelCita.setVisible(true);
        
        jDoc.setViewportView(jTableDoc);
                //this.add(auxLabel);
        jDoc.setBounds(480,150,250,147);
        this.add(jDoc);
        
       
    } 
    
    public void RecuperarDoctor(int clave){
            Auxiliar.recuperar(Doctores, clave);
         jTableDoc.setModel(new DefaultTableModel(new Object[][]{
            {"Nombre",Auxiliar.getNombre()},
            {"Apellidos",Auxiliar.getApPaterno()+" "+Auxiliar.getApMaterno()},
            {"Especialidad",Auxiliar.getEspecialidad()},
            {"CMP",Auxiliar.getCmp()},
            {"Calificacion",Auxiliar.getCalificacion()}
        },
                new String []{"DATOS","DOCTOR"}
        ));
         jTableDoc.setEnabled(false);
    }
     
     
    private void satisfaccionActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String verifica;
        boolean sigue;
        verifica=jTextFieldCita.getText();
        sigue=verificarcita(verifica);
        if(sigue){
           Auxiliar.setCalificacion(Auxiliar.getCalificacion()+1);
           Votacion.setText("Gracias.");
           archivar(Auxiliar);
           actualizarPantalla();
        }
        else{
            Votacion.setText("No es posible.");
        }
        Votacion.setBounds(480,530,120,20);
        satisfaccion.setVisible(false);
        insatisfaccion.setVisible(false);
        this.add(Votacion);
    }  
    
    private void insatisfaccionActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String verifica;
        boolean sigue;
        verifica=jTextFieldCita.getText();
        sigue=verificarcita(verifica);
        if(sigue){
           Auxiliar.setCalificacion(Auxiliar.getCalificacion()-1);
           Votacion.setText("Gracias.");
           archivar(Auxiliar);
           actualizarPantalla();
        }
        else{
            Votacion.setText("No es posible.");
        }
        Votacion.setBounds(480,530,220,20);
        satisfaccion.setVisible(false);
        insatisfaccion.setVisible(false);
        this.add(Votacion);
    }  
    
    
    public boolean verificarcita(String numaverificar){
        return true;
    }
    
    public int obtenerCodigo(){
        return Auxiliar.getClave();
    }
    
    public void actualizarPantalla(){
        jTableDoc.removeAll();
        jTableDoc.setModel(new DefaultTableModel(new Object[][]{
            {"Nombre",Auxiliar.getNombre()},
            {"Apellidos",Auxiliar.getApPaterno()+" "+Auxiliar.getApMaterno()},
            {"Especialidad",Auxiliar.getEspecialidad()},
            {"CMP",Auxiliar.getCmp()},
            {"Calificacion",Auxiliar.getCalificacion()}
        },
                new String []{"DATOS","DOCTOR"}
        ));
        jTableDoc.setEnabled(false);
    
    }

}
