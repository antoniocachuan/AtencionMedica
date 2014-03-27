
package ClasesPrincipales;
import java.io.*;

public class ARchivar {
    //clase para probar los metodos q vayan creando
 /*   public static void main(String[] args)throws Exception{

        int i=1;
        Administrador a=new Administrador();
        Paciente p=new Paciente();
        File F=new File("src\\Archivos\\Pacientes.dat");
        RandomAccessFile mfa=new RandomAccessFile(F,"rw");

        
       // try{
            while(i<2074){
                p=a.verPaciente(F,i);
                if(p.getValido()!=0)System.out.println(p.mostrarDatos()+"\n--------------------\n");
                i++;
            }
       // }catch(EOFException e){
           // i=-1;
       /// }
        
     
        

        Paciente p=new Paciente();
        p.setValido((short)1);
        p.setNombre("1234");
        p.setContraseña("abc");
        p.setApPaterno("ninanya");
        p.setApMaterno("cerrón");
        p.setSexo("Masculino");
        p.setFechaDeNacimiento("11/04/93");
        p.setEdad(18);
        p.setDNI(12345678);
        p.setDireccion("");
        p.setTelefono(3430191);
        p.setEmail("abc@hotmail.com");

        File F=new File("src\\Archivos\\Pacientes.dat");  
        RandomAccessFile r=new RandomAccessFile(F,"rw");
        
       r.seek(348*2073);
        try{
            System.out.println( r.readShort());
       }catch(EOFException e){
            System.out.println("se acabo el archivo");
            p.grabarDatos(r);
        }
        
        
        
        File F=new File("src\\Archivos\\Pacientes.dat");  
      // RandomAccessFile r=new RandomAccessFile(F,"rw"); 
        Paciente p=new Paciente();
        p.recuperar(F,12345678) ;

        System.out.println(p.mostrarDatos());
        String.valueOf(null);
        
   }
    public void sout(){
        System.out.println(getClass().getResource("/Archivos/Pacientes.dat"));
        //getClass().getR
    }*/
}
