
package Formularios;

import ClasesPrincipales.Paciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class jpanHistorial extends jpanFondo implements ActionListener,Runnable{

    private jpanFondo jpanelFondo;//panel base    
    private jlblFondo fondo; ;
    private JScrollPane jscrpanMostrar;
    private JLabel jlblTitulo;
    private JButton btnver[],btnmodificar[];
    private JTable tabla;
    private int nrodefilas;
    File PA=new File("src\\Archivos\\PersonaActual.dat");
    Paciente Paci;
    int dni;
    private Historial_Medico hm[];
    public jpanHistorial(jpanFondo fondo){

        this.jpanelFondo = fondo;
       // this.dni=dni;
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){

        this.setLayout(null);
        fondo = new jlblFondo();
        this.add(fondo);
        jlblTitulo=new JLabel("Modulo de Historiales");
        jlblTitulo.setBounds(150,50,200,20);
        this.add(jlblTitulo);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nro");
        modelo.addColumn("Codigo Cita");
        modelo.addColumn("Especialidad");
        modelo.addColumn("Medico");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addRow(new String [] {"1","12","11","34","45"});
        modelo.addRow(new String [] {"2","12","11","34","45"});
        modelo.addRow(new String [] {"3","12","11","34","45"});
        modelo.addRow(new String [] {"4","12","11","34","45"});
        modelo.addRow(new String [] {"5","12","11","34","45"});
        modelo.addRow(new String [] {"6","22"});
        tabla = new JTable(modelo);
        TableColumn columna = tabla.getColumn("Nro");
        columna.setPreferredWidth(22);
        tabla.setRowHeight(22);
        nrodefilas=tabla.getRowCount();
        jscrpanMostrar=new JScrollPane();
        btnver=new JButton[tabla.getRowCount()];
        hm=new Historial_Medico[tabla.getRowCount()];
        btnmodificar=new JButton[tabla.getRowCount()];
        int a=0;
        
        for(int i=0;i<tabla.getRowCount();i++){
        //Boton ver
        btnver[i]=new JButton();
        btnver[i].addActionListener(this);
        btnver[i].setBounds(520,120+a,18, 18);
        this.add(btnver[i]);
        btnver[i].setIcon(imagen("/HM/lupa.png"));

        //Boton modificar
        btnmodificar[i]=new JButton();
        btnmodificar[i].addActionListener(this);
        btnmodificar[i].setBounds(540,120+a,18,18);
        this.add(btnmodificar[i]);
        btnmodificar[i].setIcon(imagen("/HM/lapiz.gif"));
        a=a+22;
        }
        jscrpanMostrar.setViewportView(tabla);
        jscrpanMostrar.setBounds(120,100,400,10+(23*(tabla.getRowCount())));
        this.add(jscrpanMostrar);
        RandomAccessFile b;
      try{
                    b = new RandomAccessFile(PA,"rw");
                    Paci.leerDatos(b);

                    if(Paci.posicionarPunteroRecuperar(b,Paci)){
                        dni=Paci.getDNI();
                        b.close();
                    }else{
                       b.close();
                    }
                }catch(Exception d){

                }

    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
            for(int i=0;i<nrodefilas;i++){

                if(e.getSource().equals(btnver[i])){
                hm[i]=new Historial_Medico(null, true,dni,"Paci",Integer.parseInt(tabla.getValueAt(i, 1).toString()));
                hm[i].setVisible(true);

                }
                if(e.getSource().equals(btnmodificar[i])){
                hm[i]=new Historial_Medico(null, true,dni,"Admi",Integer.parseInt(tabla.getValueAt(i, 1).toString()));

                //hm[i]=new Historial_Medico(null, true,dni,"Admi",);
                hm[i].setVisible(true);
                }


            }
            
    }
}
