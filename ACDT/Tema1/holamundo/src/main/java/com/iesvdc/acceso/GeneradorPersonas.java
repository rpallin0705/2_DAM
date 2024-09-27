package com.iesvdc.acceso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import com.iesvdc.acceso.model.DniException;
import com.iesvdc.acceso.model.Persona;
import com.iesvdc.acceso.model.Sexo;

/**
 * Clase general para cargar archivos de texto con nombres y apellidos 
 * y generar aleatoriamente listas de personas
 */
public class GeneradorPersonas {
    private List<String> listaNombresHombres;
    private List<String> listaNombresMujeres;
    private List<String> listaApellidos;


    /**
     * Configuración inicial para indicar donde están los archivos de texto
     * con nombres y apellidos.
     * Cada línea contiene un nombre o apellidos.
     * @param archivoNombreMujer El nombre del archivo que contiene los nombres de las mujeres
     * @param archivoNombreHombre El nombre del archivo que contiene los nombres de los hombres
     * @param archivoApellidos El nombre del archivo que contiene los apellidos
     */
    public void loadData(String archivoNombreMujer, String archivoNombreHombre, String archivoApellidos) {

        try {
            this.listaApellidos = Files.readAllLines(Paths.get(archivoApellidos));
            this.listaNombresHombres = Files.readAllLines(Paths.get(archivoNombreHombre));
            this.listaNombresMujeres = Files.readAllLines(Paths.get(archivoNombreMujer));
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getLocalizedMessage());
        }
    }

    /**
     * Devuelve un nombre aleatorio de la lista
     * @param lista La lista de nombres o apellidos
     * @return String aleatorio de la lista
     */
    private String getRandomString(List<String> lista){
        return lista.get(generateRandomInt(lista.size()));
    }

    /**
     * Genera un numero aleatorio entre 0 (incluído) y max (excluído)
     * @param max El límite superior
     * @return Int aleatorio 0...max-1
     */
    private static int generateRandomInt(int max){
        return new Random().nextInt(max);
    }

    /**
     * Generador aleatorio del ENUM Sexo
     * @return Sexo
     */
    private Sexo getRandomSexo(){
        return Sexo.values()[generateRandomInt(Sexo.values().length)];
    }
    
    /**
         * El correo es :
         * primera letra del nombre
         * primer apellido sin espacios
         * segundo apellido sin espacios
         * todo en minusculas
         * quitamos acentos, letra ñ y ç
         * @TODO
        */
    private String getEmail(Persona persona){
        return "";
    }

    /**
     * Nos devuelve una persona generada aleatoriamente
     * @return Persona
     */
    Persona getRandomPersona() {
        Persona persona = new Persona();

        persona.setApellidos(getRandomString(listaApellidos));

        
        persona.setSexo(getRandomSexo());

        switch (persona.getSexo()) {
            case HOMBRE:
                persona.setNombre(getRandomString(listaNombresHombres));
                break;
            case MUJER:
                persona.setNombre(getRandomString(listaNombresMujeres));
                break;
            default:
                persona.setNombre(generateRandomInt(2) == 0 ? 
                    getRandomString(listaNombresHombres) : 
                    getRandomString(listaNombresMujeres));
                break;
        }
            persona.setNombre(getRandomString(listaNombresHombres));

            persona.setEmail(getEmail(persona));
                
        return null;
    }

    /**
     * Dado un número DNI (número entero entre 1.000.000 y 99.999.999)
     * @param nDNI
     * @return
     */
    public char calcularLetraDNI(int nDNI) throws DniException{
        if(nDNI < 1000000 || nDNI > 99999999) {
            throw new DniException("El DNI no es válido");
        }
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        return caracteres.charAt(nDNI % 23);
    }
}