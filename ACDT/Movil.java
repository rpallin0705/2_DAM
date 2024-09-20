package com.iesvdc.acceso.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;

/**
 * Clase que representa un móvil con su marca, modelo, precio y cantidad de stock.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movil {
    private String marca;
    private String modelo;
    private double procesador;
    private int ram;
    private boolean soporte5G;

    
}
