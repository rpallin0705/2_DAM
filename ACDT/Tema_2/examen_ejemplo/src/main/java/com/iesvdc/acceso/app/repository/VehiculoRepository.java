package com.iesvdc.acceso.app.repository;

import java.util.List;

import com.iesvdc.acceso.app.model.Vehiculo;

public interface VehiculoRepository {
    Vehiculo save(Vehiculo vehiculo);
    List<Vehiculo> findAll();
}
