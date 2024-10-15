package com.iesvdc.acceso.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reponsable")
@XmlAccessorType(XmlAccessType.FIELD)
public class Responsable {
    
    @XmlElement
    private String nombre;
    @XmlElement
    private Puesto puesto;
    @XmlElement
    private String correoElectronico;
    @XmlElement
    private int experiencia;


    public Responsable() {
    }


    public Responsable(String nombre, Puesto puesto, String correoElectronico, int experiencia) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.correoElectronico = correoElectronico;
        this.experiencia = experiencia;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Puesto getPuesto() {
        return this.puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"nombre\":\"%s\"," +
                        "\"puesto\":\"%s\"," +
                        "\"experiencia\":\"%s\"," +
                        "\"correoElectronico\": %s}",
                getNombre(),
                getPuesto(),
                getCorreoElectronico(),
                getExperiencia());

    }

}
