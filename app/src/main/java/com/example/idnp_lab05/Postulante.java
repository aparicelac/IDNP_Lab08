package com.example.idnp_lab05;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Postulante implements Serializable {
    //Atributos
    private String dni;
    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;
    private String fecha_nacimiento;
    private String colegio;
    private String carrera;

    //Constructores
    public Postulante() {

    }

    protected Postulante(Parcel in) {
        dni = in.readString();
        apellido_paterno = in.readString();
        apellido_materno = in.readString();
        nombres = in.readString();
        fecha_nacimiento = in.readString();
        colegio = in.readString();
        carrera = in.readString();
    }



    //Métodos setters y getters
    public String getCodigo() {
        return dni;
    }

    public void setCodigo(String codigo) {
        this.dni = codigo;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /*
    @Override
    public String toString() {
        return "Postulante{" +
                "apellido_paterno='" + apellido_paterno + "\'" +
                ", apellido_materno='" + apellido_materno + "\'" +
                ", nombres='" + nombres + "\'" +
                ", fecha_nacimiento='" + fecha_nacimiento + "\'" +
                ", colegio='" + colegio + "\'" +
                ", carrera='" + carrera + "\'" +
                ", codigo='" + codigo + "\'" +
                "}";
    }
    */

    @Override
    public String toString() {
        return "Postulante " + dni + "\t" +
                "  Apellido_paterno: " + apellido_paterno +
                ", Apellido_materno: " + apellido_materno +
                ", Nombres: " + nombres +
                ", Fecha_nacimiento: " + fecha_nacimiento +
                ", Colegio: " + colegio +
                ", Carrera: " + carrera;
    }
}
