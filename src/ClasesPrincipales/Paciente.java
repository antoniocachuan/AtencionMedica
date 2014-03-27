
package ClasesPrincipales;

import java.io.*;

public class Paciente extends Persona {
    /************************ atributos ***********************/     
    
    private short valido=0;//2 bytes
    private final int TAM=314+32+2;//348 bytes en total
    protected String contraseña;//32
    
    /************************* Metodos *************************/
    public Paciente(){
    }    
    
    public String mostrarDatos(){
        return "\n\n\t Nombre: " + getNombre() +
               "\n\t Apellido paterno: " + getApPaterno()+
               "\n\t Apellido materno: " + getApMaterno()+
               "\n\n\t DNI: " + getDNI()+
               "\n\t Edad: " + getEdad() +
               "\n\t Sexo: " +getSexo()+
               "\n\t Fecha de nacimiento: " + getFechaDeNacimiento() +
               "\n\n\t Direccion: " + getDireccion()+
               "\n\t Telefono: " + getTelefono() +
               "\n\t Email: " + getEmail();
                
    }

    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = (contraseña.length()>15)?contraseña.substring(0,15):contraseña;
    }   
    public void setValido(short v){//0:invalido  1:valido
        valido=v;
    }
    public short getValido(){
        return valido;
    }
    
    public int hash(){        
        int aux1=0,aux2=0;
        int C[]=new int [4];
        int B[]=new int [4];
        int fin=0;
        aux2=getDNI()%10000;
        aux1=getDNI()/10000;
        for(int i=3;i>=0;i--){
            C[i]=aux1/(int)Math.pow(10, i);
            aux1=aux1%(int)Math.pow(10, i);
            B[i]=aux2/(int)Math.pow(10, i);
            aux2=aux2%(int)Math.pow(10, i);
        }
        aux1=0;
        for (int i=0;i<4;i++){
            fin=fin+B[i];
            aux1=aux1+C[i];        
        }
        fin=fin+aux1;
        fin=fin*101;
        aux1=(fin/100)*2;
        fin=(int)Math.pow(aux1,2);
        fin=fin/10;
        if(fin%2!=0)
            fin=fin+1;
        return fin;
    }
    
    //metodo para recuperar a una persona
    public void recuperar(File F,int DNI){
        Paciente p=new Paciente();
        p.setDNI(DNI);
        try{
            RandomAccessFile mfa=new RandomAccessFile(F,"rw"); 
            if(posicionarPunteroRecuperar(mfa,p))          
                leerDatos(mfa);
            
        }catch(Exception e){//IOException y FileNotFoundException
        }    
    }
    
    public boolean posicionarPunteroRecuperar(RandomAccessFile mfa,Paciente p)throws IOException{
       int pos;       
       pos=p.hash();
       mfa.seek(dezplasamiento(pos));
       while(mfa.readShort()==1 && mfa.readInt()!=p.getDNI()){//mientras el registro no sea el buscado
           pos++;//aumentamos una posicion
           mfa.seek(dezplasamiento(pos));//nos dezplazamos a la nueva posicion            
       }
       
       mfa.seek(dezplasamiento(pos));
       
       if(mfa.readShort()==0)
           return false;
       else{
            mfa.seek(dezplasamiento(pos));
           return true;
       }
       
    
    }
    public boolean posicionarPunteroGrabar(RandomAccessFile mfa)throws IOException{
        int pos=hash();
        int dni;
        try{
                mfa.seek(dezplasamiento(pos));
                if(mfa.readShort()==0){//campo vacio
                    mfa.seek(dezplasamiento(pos));//retrocedemos xk hemos leido un campo
                    return true;//apto para archivar
                }else{
                    mfa.seek(dezplasamiento(pos));
                    while(mfa.readShort()==1){//mientras el campo sea valido
                        dni=mfa.readInt();
                        if(getDNI()==dni){//si el elemento ya existe
                            return false;//no se puede archivar
                        }
                        else{
                            pos++;
                            mfa.seek(dezplasamiento(pos));
                        }
                    }

                //si llega hasta aqui signigica que ningun campo tiene el mismo codigo
                //y encontramos un campo vacio
                mfa.seek(dezplasamiento(pos));//retrocedemos xk hemos leido un campo
                return true;
            }
        }catch(EOFException e){//SE HA SUPERADO EL FINAL DEL ARCHIVO
            mfa.seek(dezplasamiento(pos));//retrocedemos xk hemos leido un campo
            return true;
        }
    }
    //metodo para escribir los datos en un archivo
    public void grabarDatos(RandomAccessFile mfa) throws IOException{
        //primero guardamos los datos que nos serviran para comprobar al paciente
        mfa.writeShort(valido);
        mfa.writeInt(getDNI());        
        mfa.writeUTF(contraseña);
        //Luego guardamos el resto de los datos
        mfa.writeUTF(getNombre());
        mfa.writeUTF(getApPaterno());
        mfa.writeUTF(getApMaterno());
        mfa.writeUTF(getSexo());
        mfa.writeUTF(getFechaDeNacimiento());
        mfa.writeInt(getEdad());
        mfa.writeUTF(getDireccion());
        mfa.writeInt(getTelefono());        
        mfa.writeUTF(getEmail());

    }
    //metodo para leer datos en un archivo    
    public void leerDatos(RandomAccessFile mfa) throws IOException{
        valido=mfa.readShort();
        setDNI(mfa.readInt());             
        contraseña=mfa.readUTF();
        setNombre(mfa.readUTF());   
        setApPaterno(mfa.readUTF());
        setApMaterno(mfa.readUTF());
        setSexo(mfa.readUTF());
        setFechaDeNacimiento(mfa.readUTF());
        setEdad(mfa.readInt());
        setDireccion(mfa.readUTF());
        setTelefono(mfa.readInt());        
        setEmail(mfa.readUTF());
    }

    

    public long dezplasamiento(int n){
        return TAM*(n-1);
    }
    /***********************************************************/
}

