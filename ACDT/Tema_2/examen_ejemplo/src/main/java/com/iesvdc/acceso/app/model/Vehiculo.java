package com.iesvdc.acceso.app.model;
import java.util.Objects;

public class Vehiculo {
    // Atributos basados en la tabla Vehiculo
    private int idVehiculo;
    private String marca;
    private String modelo;
    private int anio;
    private double precio;
    private String combustible;


    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int anio, double precio, String combustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.combustible = combustible;
    }

    public int getIdVehiculo() {
        return this.idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCombustible() {
        return this.combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Vehiculo idVehiculo(int idVehiculo) {
        setIdVehiculo(idVehiculo);
        return this;
    }

    public Vehiculo marca(String marca) {
        setMarca(marca);
        return this;
    }

    public Vehiculo modelo(String modelo) {
        setModelo(modelo);
        return this;
    }

    public Vehiculo anio(int anio) {
        setAnio(anio);
        return this;
    }

    public Vehiculo precio(double precio) {
        setPrecio(precio);
        return this;
    }

    public Vehiculo combustible(String combustible) {
        setCombustible(combustible);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return idVehiculo == vehiculo.idVehiculo && Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo) && anio == vehiculo.anio && precio == vehiculo.precio && Objects.equals(combustible, vehiculo.combustible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVehiculo, marca, modelo, anio, precio, combustible);
    }

    @Override
    public String toString() {
        return "{" +
            " idVehiculo='" + getIdVehiculo() + "'" +
            ", marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", anio='" + getAnio() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", combustible='" + getCombustible() + "'" +
            "}";
    }
    
}
