package com.example.ejemploexamen.model;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {
    private int nReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva() {
    }

    public Reserva(int nReserva, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.nReserva = nReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public int getNReserva() {
        return this.nReserva;
    }

    public void setNReserva(int nReserva) {
        this.nReserva = nReserva;
    }

    public LocalDate getFechaEntrada() {
        return this.fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return this.fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Reserva nReserva(int nReserva) {
        setNReserva(nReserva);
        return this;
    }

    public Reserva fechaEntrada(LocalDate fechaEntrada) {
        setFechaEntrada(fechaEntrada);
        return this;
    }

    public Reserva fechaSalida(LocalDate fechaSalida) {
        setFechaSalida(fechaSalida);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Reserva)) {
            return false;
        }
        Reserva reserva = (Reserva) o;
        return nReserva == reserva.nReserva && Objects.equals(fechaEntrada, reserva.fechaEntrada)
                && Objects.equals(fechaSalida, reserva.fechaSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nReserva, fechaEntrada, fechaSalida);
    }

    @Override
    public String toString() {
        return "{" +
                " nReserva='" + getNReserva() + "'" +
                ", fechaEntrada='" + getFechaEntrada() + "'" +
                ", fechaSalida='" + getFechaSalida() + "'" +
                "}";
    }

}
