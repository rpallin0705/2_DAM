package com.iesvdc.acceso.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    @XmlElement(required = true)
    private String nombre;
    @XmlElement(required = true)
    private String apellidos;
    @XmlElement(required = true)
    private String email;
    @XmlElement(required = true)
    private int numeroDNI;
    @XmlElement(required = true)
    private char letraDNI;
    @XmlElement(required = true)
    private LocalDate fechaNacimiento;
    @XmlElement(required = true)
    private Sexo sexo;
    @XmlElement(required = true)
    private List<Direccion> direcciones;

    public Persona() { 
        this.direcciones = new ArrayList<>();
    }

    public Persona(String nombre, String apellidos, String email, int numeroDNI, char letraDNI,
            LocalDate fechaNacimiento, Sexo sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.numeroDNI = numeroDNI;
        this.letraDNI = letraDNI;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direcciones = new ArrayList<>();
    }

    private List<Direccion> getDirecciones() {
        return this.direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public void addDireccion(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    public void removeDireccion(Direccion direccion) {
        this.direcciones.removeIf(d -> d.equals(direccion));
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroDNI() {
        return this.numeroDNI;
    }

    public void setNumeroDNI(int numeroDNI) {
        this.numeroDNI = numeroDNI;
    }

    public char getLetraDNI() {
        return this.letraDNI;
    }

    public void setLetraDNI(char letraDNI) {
        this.letraDNI = letraDNI;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Persona apellidos(String apellidos) {
        setApellidos(apellidos);
        return this;
    }

    public Persona email(String email) {
        setEmail(email);
        return this;
    }

    public Persona numeroDNI(int numeroDNI) {
        setNumeroDNI(numeroDNI);
        return this;
    }

    public Persona letraDNI(char letraDNI) {
        setLetraDNI(letraDNI);
        return this;
    }

    public Persona fechaNacimiento(LocalDate fechaNacimiento) {
        setFechaNacimiento(fechaNacimiento);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos)
                && Objects.equals(email, persona.email) && numeroDNI == persona.numeroDNI
                && letraDNI == persona.letraDNI && Objects.equals(fechaNacimiento, persona.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, email, numeroDNI, letraDNI, fechaNacimiento);
    }

    @Override
    public String toString() {
        return String.format(
                "{\"nombre\":\"%s\"," +
                        "\"apellidos\":\"%s\"," +
                        "\"sexo\":\"%s\"," +
                        "\"email\":\"%s\"," +
                        "\"numeroDNI\":\"%d\"," +
                        "\"letraDNI\":\"%c\"," +
                        "\"fechaNacimiento\":\"%s\"}",
                getNombre(),
                getApellidos(),
                getSexo(),
                getEmail(),
                getNumeroDNI(),
                getLetraDNI(),
                getFechaNacimiento());
    }

}
