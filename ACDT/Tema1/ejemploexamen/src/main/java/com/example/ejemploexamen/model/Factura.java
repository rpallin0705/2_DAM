package com.example.ejemploexamen.model;
import java.util.Objects;

public class Factura {

    private int numeroFactura;
    private int numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private float importe;


    public Factura() {
    }

    public Factura(int numeroFactura, int numeroHabitacion, TipoHabitacion tipoHabitacion, float importe) {
        this.numeroFactura = numeroFactura;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.importe = importe;
    }

    public int getNumeroFactura() {
        return this.numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getNumeroHabitacion() {
        return this.numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return this.tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public float getImporte() {
        return this.importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Factura numeroFactura(int numeroFactura) {
        setNumeroFactura(numeroFactura);
        return this;
    }

    public Factura numeroHabitacion(int numeroHabitacion) {
        setNumeroHabitacion(numeroHabitacion);
        return this;
    }

    public Factura tipoHabitacion(TipoHabitacion tipoHabitacion) {
        setTipoHabitacion(tipoHabitacion);
        return this;
    }

    public Factura importe(float importe) {
        setImporte(importe);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Factura)) {
            return false;
        }
        Factura factura = (Factura) o;
        return numeroFactura == factura.numeroFactura && numeroHabitacion == factura.numeroHabitacion && Objects.equals(tipoHabitacion, factura.tipoHabitacion) && importe == factura.importe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroFactura, numeroHabitacion, tipoHabitacion, importe);
    }

    @Override
    public String toString() {
        return "{" +
            " numeroFactura='" + getNumeroFactura() + "'" +
            ", numeroHabitacion='" + getNumeroHabitacion() + "'" +
            ", tipoHabitacion='" + getTipoHabitacion() + "'" +
            ", importe='" + getImporte() + "'" +
            "}";
    }

    
}
