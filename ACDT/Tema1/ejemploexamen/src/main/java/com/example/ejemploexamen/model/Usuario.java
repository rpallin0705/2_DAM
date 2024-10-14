package com.example.ejemploexamen.model;

import java.util.List;
import java.util.Objects;

public class Usuario {
    /*
     * Usuario:
- Nombre
- Apellidos
- Dirección

Departamento de
Informática
IES VIRGEN DEL CARMEN
Paseo de la Estación nº 44
23008 Jaén
Tel. 953366942 – Fax: 953366944
www.iesvirgendelcarmen.com
Examen de Acceso a Datos
CFGS DAM Tema 2 y 3 12/03/2020 Página 2 de 2
- Email
Dirección:
- Tipo de Vía
- Denominación Vía
- Código Postal
Código Postal:
- Código
- Ciudad
Reserva:
- Número de reserva
- fecha entrada
- hora entrada
- fecha salida
Factura:
- Número de factura
- Número de habitación
- Tipo de habitación
- Importe

     */
    private String nombre;
    private String apellidos;
    private String email;
    private List<Direccion> direcciones;
    private List<Reserva> reservas;
    private List<Factura> facturas;



    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String email, List<Direccion> direcciones, List<Reserva> reservas, List<Factura> facturas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.direcciones = direcciones;
        this.reservas = reservas;
        this.facturas = facturas;
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

    public List<Direccion> getDirecciones() {
        return this.direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Factura> getFacturas() {
        return this.facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Usuario nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Usuario apellidos(String apellidos) {
        setApellidos(apellidos);
        return this;
    }

    public Usuario email(String email) {
        setEmail(email);
        return this;
    }

    public Usuario direcciones(List<Direccion> direcciones) {
        setDirecciones(direcciones);
        return this;
    }

    public Usuario reservas(List<Reserva> reservas) {
        setReservas(reservas);
        return this;
    }

    public Usuario facturas(List<Factura> facturas) {
        setFacturas(facturas);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(email, usuario.email) && Objects.equals(direcciones, usuario.direcciones) && Objects.equals(reservas, usuario.reservas) && Objects.equals(facturas, usuario.facturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, email, direcciones, reservas, facturas);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", email='" + getEmail() + "'" +
            ", direcciones='" + getDirecciones() + "'" +
            ", reservas='" + getReservas() + "'" +
            ", facturas='" + getFacturas() + "'" +
            "}";
    }


}