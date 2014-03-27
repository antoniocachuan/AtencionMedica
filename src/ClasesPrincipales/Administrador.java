
package ClasesPrincipales;
import java.io.*;

public class Administrador extends Persona {
    public String Fecha;

    public boolean archivar(File F,Paciente p){
        
        boolean estado=true;        
        try{
            RandomAccessFile mfa=new RandomAccessFile(F,"rw"); 
            if(p.posicionarPunteroGrabar(mfa))//si es posible grabar
                p.grabarDatos(mfa);
            else
                estado=false;            
        }catch(IOException e){
            estado=false;
        }
        return estado;        
    }
    
    public Paciente verPaciente(File F,int i)throws EOFException{
        Paciente p=new Paciente();
        try{
            RandomAccessFile mfa=new RandomAccessFile(F,"rw");   
            mfa.seek(p.dezplasamiento(i));            
            p.leerDatos(mfa);
        }catch(IOException e){
            
        }
        return p;            
    }


}