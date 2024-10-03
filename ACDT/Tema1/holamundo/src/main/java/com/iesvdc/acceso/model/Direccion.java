package com.iesvdc.acceso.model;

import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Direccion {
    @XmlAttribute
    private long idDireccion;
    @XmlAttribute
    private String nombreVia;
    @XmlAttribute
    private TipoVia tipoVia;
    @XmlAttribute
    private int numero;
    @XmlAttribute
    private String detalle;

    public Direccion() {
    }

    public Direccion(long idDireccion, String nombreVia, TipoVia tipoVia, int numero, String detalle) {
        this.idDireccion = idDireccion;
        this.nombreVia = nombreVia;
        this.tipoVia = tipoVia;
        this.numero = numero;
        this.detalle = detalle;
    }

    public long getIdDireccion() {
        return this.idDireccion;
    }

    public void setIdDireccion(long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNombreVia() {
        return this.nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public TipoVia getTipoVia() {
        return this.tipoVia;
    }

    public void setTipoVia(TipoVia tipoVia) {
        this.tipoVia = tipoVia;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDetalle() {
        return this.detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Direccion idDireccion(long idDireccion) {
        setIdDireccion(idDireccion);
        return this;
    }

    public Direccion nombreVia(String nombreVia) {
        setNombreVia(nombreVia);
        return this;
    }

    public Direccion tipoVia(TipoVia tipoVia) {
        setTipoVia(tipoVia);
        return this;
    }

    public Direccion numero(int numero) {
        setNumero(numero);
        return this;
    }

    public Direccion detalle(String detalle) {
        setDetalle(detalle);
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
        return idDireccion == direccion.idDireccion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDireccion, nombreVia, tipoVia, numero, detalle);
    }

    @Override
    public String toString() {
        return "{" +
                " idDireccion='" + getIdDireccion() + "'" +
                ", nombreVia='" + getNombreVia() + "'" +
                ", tipoVia='" + getTipoVia() + "'" +
                ", numero='" + getNumero() + "'" +
                ", detalle='" + getDetalle() + "'" +
                "}";
    }

}
