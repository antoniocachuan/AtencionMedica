/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClasesPrincipales;

import ClasesPrincipales.Doctor;
import ClasesPrincipales.Paciente;

/**
 *
 * @author Redi
 */
public class Consulta {
private Paciente paci; // el paciente que posee el historial
private Cita cita[]; //Doctores que vieron al paciente
private Double Estatura,Peso;
private String Sangre,estado_ingreso,estado_psicologico,observaciones,temperatura,presion,recetas;
private String Alergias[]=new String[4];

    public String getRecetas() {
        return recetas;
    }

    public void setRecetas(String recetas) {
        this.recetas = recetas;
    }
//Datos que se agregan al paciente


    public String[] getAlergias() {
        return Alergias;
    }

    public void setAlergias(String[] Alergias) {
        this.Alergias = Alergias;
    }

    public Double getEstatura() {
        return Estatura;
    }

    public void setEstatura(Double Estatura) {
        this.Estatura = Estatura;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double Peso) {
        this.Peso = Peso;
    }

    public String getSangre() {
        return Sangre;
    }

    public void setSangre(String Sangre) {
        this.Sangre = Sangre;
    }

    public String getEstado_ingreso() {
        return estado_ingreso;
    }

    public void setEstado_ingreso(String estado_ingreso) {
        this.estado_ingreso = estado_ingreso;
    }

    public String getEstado_psicologico() {
        return estado_psicologico;
    }

    public void setEstado_psicologico(String estado_psicologico) {
        this.estado_psicologico = estado_psicologico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
    

}
