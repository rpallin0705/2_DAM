package com.example.ejemploexamen.model;
import java.util.Objects;

public class CodigoPostal {
    private int cPostal;
    private String localidad;
    private String provincia;


    public CodigoPostal() {
    }

    public CodigoPostal(int cPostal, String localidad, String provincia) {
        this.cPostal = cPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public int getCPostal() {
        return this.cPostal;
    }

    public void setCPostal(int cPostal) {
        this.cPostal = cPostal;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public CodigoPostal cPostal(int cPostal) {
        setCPostal(cPostal);
        return this;
    }

    public CodigoPostal localidad(String localidad) {
        setLocalidad(localidad);
        return this;
    }

    public CodigoPostal provincia(String provincia) {
        setProvincia(provincia);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CodigoPostal)) {
            return false;
        }
        CodigoPostal codigoPostal = (CodigoPostal) o;
        return cPostal == codigoPostal.cPostal && Objects.equals(localidad, codigoPostal.localidad) && Objects.equals(provincia, codigoPostal.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cPostal, localidad, provincia);
    }

    @Override
    public String toString() {
        return "{" +
            " cPostal='" + getCPostal() + "'" +
            ", localidad='" + getLocalidad() + "'" +
            ", provincia='" + getProvincia() + "'" +
            "}";
    }
    
}
