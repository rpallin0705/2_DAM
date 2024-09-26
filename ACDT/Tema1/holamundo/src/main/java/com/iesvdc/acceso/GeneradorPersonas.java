package com.iesvdc.acceso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.iesvdc.acceso.model.Persona;
import com.iesvdc.acceso.model.Sexo;

public class GeneradorPersonas {
    private List<String> listaNombresHombres;
    private List<String> listaNombresMujeres;
    private List<String> listaApellidos;

    void loadData(String archivoNombreMujer, String archivoNombreHombre, String archivoApellidos) {

        try {
            this.listaApellidos = Files.readAllLines(Paths.get(archivoApellidos));
            this.listaNombresHombres = Files.readAllLines(Paths.get(archivoNombreHombre));
            this.listaNombresMujeres = Files.readAllLines(Paths.get(archivoNombreMujer));
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getLocalizedMessage());
        }
    }

    String getRandom(List<String> lista){
        return listaApellidos.get(0);
    }
    
    Persona getRandomPersona() {
        Persona persona = new Persona();

        persona.setApellidos(getRandom(listaApellidos));

        persona.setNombre(getRandom(listaNombresHombres));

        return null;
    }
}