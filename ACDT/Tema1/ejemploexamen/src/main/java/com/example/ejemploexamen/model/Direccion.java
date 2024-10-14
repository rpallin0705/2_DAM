package com.example.ejemploexamen.model;

import java.util.Objects;

public class Direccion {
    private TipoVia tipoVia;
    private String nombreVia;
    private CodigoPostal codigoPostal;

    public Direccion() {
    }

    public Direccion(TipoVia tipoVia, String nombreVia, CodigoPostal codigoPostal) {
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.codigoPostal = codigoPostal;
    }

    public TipoVia getTipoVia() {
        return this.tipoVia;
    }

    public void setTipoVia(TipoVia tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return this.nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public CodigoPostal getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(CodigoPostal codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Direccion tipoVia(TipoVia tipoVia) {
        setTipoVia(tipoVia);
        return this;
    }

    public Direccion nombreVia(String nombreVia) {
        setNombreVia(nombreVia);
        return this;
    }

    public Direccion codigoPostal(CodigoPostal codigoPostal) {
        setCodigoPostal(codigoPostal);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Direccion)) {
            return false;
        }
        Direccion direccion = (Direccion) o;
        return Objects.equals(tipoVia, direccion.tipoVia) && Objects.equals(nombreVia, direccion.nombreVia)
                && Objects.equals(codigoPostal, direccion.codigoPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoVia, nombreVia, codigoPostal);
    }

    @Override
    public String toString() {
        return "{" +
                " tipoVia='" + getTipoVia() + "'" +
                ", nombreVia='" + getNombreVia() + "'" +
                ", codigoPostal='" + getCodigoPostal() + "'" +
                "}";
    }

}
