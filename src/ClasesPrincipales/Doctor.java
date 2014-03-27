/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;
import java.io.*;
/**
 *
 * @author Antonio
 */
public class Doctor extends Persona{
    
    private String Especialidad;
    private int Calificacion;
    private int cmp;
    private int clave;
    private final int TAM=140;
    

    public int getCmp() {
        return cmp;
    }

    public void setCmp(int cmp) {
        this.cmp = cmp;
    }
      public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
       //Cita C[];

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = (Especialidad.length()>15)?Especialidad.substring(0,15):Especialidad;;
    }

    public Doctor(String Especialidad, String nombre, String apPaterno, String apMaterno, int Calificacion, int cmp,int clave) {
        this.Especialidad = Especialidad;
        this.setNombre(nombre);
        this.setApPaterno(apPaterno);
        this.setApMaterno(apMaterno);
        this.Calificacion=Calificacion;
        this.cmp=cmp;
        this.clave=clave;
        
    }
    
    public Doctor(){}
 
    

     public void grabarDatos(RandomAccessFile mfa2) throws IOException{
        //primero guardamos los datos que nos serviran para comprobar al paciente
       // mfa.writeShort(valido);
         //System.out.println("clave: "+getClave()+" "+getCalificacion());
         mfa2.writeUTF(getNombre());//32
         mfa2.writeUTF(getApPaterno());//32
         mfa2.writeUTF(getApMaterno());   //32
         mfa2.writeInt(getCalificacion()); //4
         mfa2.writeUTF(getEspecialidad());//32
         mfa2.writeInt(getCmp());//4
         mfa2.writeInt(getClave());//4
    } 
    
    public void recuperar(File F,int clave){
        //Doctor p=new Doctor();
        
        try{
            RandomAccessFile mfa2=new RandomAccessFile(F,"rw"); 
          if(posicionarPunteroRecuperar(mfa2,clave))          
               leerDatos(mfa2);
            
        }catch(Exception e){//IOException y FileNotFoundException
            System.out.println("cagao===> Finquin se la come dobleada (y no va ser!!)");
        }    
    }
    
     public void leerDatos(RandomAccessFile mfa2) throws IOException{
        setNombre(mfa2.readUTF());
        setApPaterno(mfa2.readUTF());   
        setApMaterno(mfa2.readUTF());
        setCalificacion(mfa2.readInt());
        setEspecialidad(mfa2.readUTF());
        setCmp(mfa2.readInt());
        setClave(mfa2.readInt());
    }
    /**
     * @return the Calificacion
     */
    public int getCalificacion() {
        return Calificacion;
    }
    
     public boolean posicionarPunteroRecuperar(RandomAccessFile mfa2,int clave)throws IOException{
       mfa2.seek(dezplasamiento(clave));
       return (true);
    }
     
    public long dezplasamiento(int n){
        return TAM*(n);
    } 

    /**
     * @param Calificacion the Calificacion to set
     */
    public void setCalificacion(int Calificacion) {
        this.Calificacion = Calificacion;
    }
}
