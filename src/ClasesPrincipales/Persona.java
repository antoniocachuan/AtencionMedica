
package ClasesPrincipales;

public abstract class Persona {
    
    /************************ atributos ***********************/
    private int DNI;//4
    
    private String nombre;//32
    private String apPaterno;//32
    private String apMaterno;//32
    private String sexo;//20
    private String fechaDeNacimiento;//22
    private int edad;//4
    private String direccion;//102
    private int telefono;//4
    private String email;//62
    
    /************************** getters ************************/
    public int getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

   /************************** setters ************************/
    public void setDNI(int DNI) {//4 bytes
        this.DNI = ((DNI+"").length()>8)?Integer.parseInt((DNI+"").substring(0,8)):DNI;//solo 8 digitos
    }

    public void setNombre(String nombre) {//32 bytes
        this.nombre = (nombre.length()>15)?nombre.substring(0,15):nombre;//15 caracteres
    }

    public void setApPaterno(String apPaterno) {//32 bytes
        this.apPaterno = (apPaterno.length()>15)?apPaterno.substring(0,15):apPaterno;//15 caracteres
    }

    public void setApMaterno(String apMaterno) {//32 bytes
        this.apMaterno = (apMaterno.length()>15)?apMaterno.substring(0,15):apMaterno;//15 caracteres
    }

    public void setSexo(String sexo) {//20 bytes
        this.sexo = (sexo.length()>9)?sexo.substring(0,9):sexo;//9 caracteres
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {//22 bytes
        this.fechaDeNacimiento = (fechaDeNacimiento.length()>15)?fechaDeNacimiento.substring(0,10):fechaDeNacimiento;//10 caracteres(dd/mm/aaaa)
    }

    public void setEdad(int edad) {//4 bytes
        this.edad = edad;//sin limite
    }

    public void setDireccion(String direccion) {//102 bytes
        this.direccion = (direccion.length()>50)?direccion.substring(0,50):direccion;//50 caracteres
    }

    public void setTelefono(int telefono) {//4 bytes
        this.telefono = telefono;
    }

    public void setEmail(String email) {//62 bytes
        this.email = (email.length()>30)?email.substring(0,30):email;//30caracteres
    }


    
  
    /***********************************************************/

}
