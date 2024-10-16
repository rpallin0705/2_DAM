package com.iesvdc.acceso.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "proyecto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proyecto {

    @XmlElement(required = true)
    private String nombre;
    @XmlElement(required = true)
    private String descripcion;
    @XmlElement(required = true)
    private List<Tareas> tareas;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, List<Tareas> tareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tareas = tareas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Tareas> getTareas() {
        return this.tareas;
    }

    public void setTareas(List<Tareas> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"nombre\":\"%s\"," +
                        "\"descripcion\":\"%s\"," +
                        "\"tareas\": %s}",
                getNombre(),
                getDescripcion(),
                getTareas());

    }

}
