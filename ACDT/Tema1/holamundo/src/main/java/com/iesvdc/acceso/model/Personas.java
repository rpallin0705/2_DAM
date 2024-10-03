package com.iesvdc.acceso.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.iesvdc.acceso.error.DniException;
import com.iesvdc.acceso.error.LoadDataException;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * Clase general para cargar archivos de texto con nombres y apellidos
 * y generar aleatoriamente listas de personas
 */
// Se añaden las anotaciones para que el serializador sepa como tratar la clase
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Personas {

    private List<Persona> listaPersonas;

    // Se añade la anotación para que el serializador no incluya el atributo en el XML
    @XmlTransient
    private List<String> listaNombresHombres;
    @XmlTransient
    private List<String> listaNombresMujeres;
    @XmlTransient
    private List<String> listaApellidos;
    @XmlTransient
    private static final Random random = new Random();

    public Personas() {
        this.listaPersonas = new ArrayList<>();
    }

    /**
     * Configuración inicial para indicar donde están los archivos de texto
     * con nombres y apellidos.
     * Cada línea contiene un nombre o apellidos.
     * 
     * @param archivoNombreMujer  El nombre del archivo que contiene los nombres de
     *                            las mujeres
     * @param archivoNombreHombre El nombre del archivo que contiene los nombres de
     *                            los hombres
     * @param archivoApellidos    El nombre del archivo que contiene los apellidos
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
     * 
     * @param lista La lista de nombres o apellidos
     * @return String aleatorio de la lista
     */
    private String getRandomString(List<String> lista) {
        return lista.get(generateRandomInt(lista.size()));
    }

    /**
     * Genera un numero aleatorio entre 0 (incluído) y max (excluído)
     * 
     * @param max El límite superior
     * @return Int aleatorio 0...max-1
     */
    private static int generateRandomInt(int max) {
        return random.nextInt(max);
    }

    /**
     * Generador aleatorio del ENUM Sexo
     * 
     * @return Sexo
     */
    private Sexo getRandomSexo() {
        return Sexo.values()[generateRandomInt(Sexo.values().length)];
    }

    /**
     * Genera un email para la persona cogiendo la primera letra del nombre y los
     * apellidos
     * pasado a minúsculas, sin espacios y sin acentos.
     * 
     * @param La persona a la que se le genera el email
     * @return El email generado
     */
    private String getEmail(Persona persona) {
        String caracteresNoPermitidos = ".*[áéíóúñç].*";
        String email = (persona.getNombre().trim().charAt(0) +
                persona.getApellidos().trim()).replace(" ", "")
                .toLowerCase();

        if (email.matches(caracteresNoPermitidos)) {
            email = email.replaceAll("[áàäâ]", "a")
                    .replaceAll("[éèëê]", "e")
                    .replaceAll("[íìïî]", "i")
                    .replaceAll("[óòöô]", "o")
                    .replaceAll("[úùüû]", "u")
                    .replace("ñ", "n")
                    .replace("ç", "c");
        }

        return email + "@iesvdc.com";
    }

    /**
     * Nos devuelve una persona generada aleatoriamente
     * 
     * @return Persona
     */
    Persona getRandomPersona() {
        Persona persona = new Persona();

        persona.setApellidos(getRandomString(listaApellidos) + " " + getRandomString(listaApellidos));

        persona.setSexo(getRandomSexo());

        switch (persona.getSexo()) {
            case HOMBRE:
                persona.setNombre(getRandomString(listaNombresHombres));
                break;
            case MUJER:
                persona.setNombre(getRandomString(listaNombresMujeres));
                break;
            default:
                persona.setNombre(generateRandomInt(2) == 0 ? getRandomString(listaNombresHombres)
                        : getRandomString(listaNombresMujeres));
                break;
        }

        persona.setNombre(getRandomString(listaNombresHombres));

        persona.setEmail(getEmail(persona));

        persona.setNumeroDNI(getRandomDNINumber());

        try {
            persona.setLetraDNI(calcularLetraDNI(persona.getNumeroDNI()));
        } catch (DniException e) {
            System.out.println(e.getMessage());
        }

        persona.setEmail(getEmail(persona));

        persona.setFechaNacimiento(generarFecha());

        return persona;
    }

    /**
     * Genera un número de DNI aleatorio entre 10.000.000 y 99.999.999
     * 
     * @return Un numero de DNI aleatorio
     */
    private int getRandomDNINumber() {
        return random.nextInt(10000000, 100000000);
    }

    /**
     * Dado un número DNI (número entero entre 1.000.000 y 99.999.999)
     * 
     * @param nDNI
     * @return devuelve la letra del DNI válido
     */
    public char calcularLetraDNI(int nDNI) throws DniException {
        if (nDNI < 1000000 || nDNI > 99999999) {
            throw new DniException("El DNI fuera de rango");
        }
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        return caracteres.charAt(nDNI % 23);
    }

    /**
     * Genera una lista de personas de tantas personas como se le pase por parámetro
     * 
     * @param numPersonas número de personas a generar
     * @return lista de personas aleatorias
     */
    public void generarPersonas(int numPersonas) throws LoadDataException {
        List<Persona> listaPersonas = new ArrayList<>();
        if (this.listaApellidos == null ||
                this.listaNombresHombres == null ||
                this.listaNombresMujeres == null) {
            throw new LoadDataException("Error: no se han cargado los archivos con los datos de personas");
        } else {
            for (int i = 0; i < numPersonas; i++) {
                this.listaPersonas.add(getRandomPersona());
            }
        }
    }

    /**
     * Genera una fecha aleatoria entre 1/1/1920 y la fecha actual
     * 
     * @return Una fecha aleatoria
     */
    private LocalDate generarFecha() {
        // Almacenamos en una variable "startingDate" () pasamos a formato UNIX la fecha
        // 1/1/1920
        LocalDate startingDate = LocalDate.of(1920, 1, 1);
        Long startingDateUnix = startingDate.toEpochDay();
        // Almacenamos en una variable "endingDate" (pasamos a formato UNIX la fecha
        // actual)
        LocalDate endingDate = LocalDate.now();
        Long endingDateUnix = endingDate.toEpochDay();
        // Restamos endingDate - startingDate y generamos un número aleatorio entre 0 y
        // la diferencia de las fechas.
        Long randomDate = random.nextLong(endingDateUnix - startingDateUnix);
        // Pasamos el numero aleatorio a localDate
        return LocalDate.ofEpochDay(randomDate + startingDateUnix);

    }

    public List<Persona> getListaPersonas() {
        return this.listaPersonas;
    }


    @Override
    public String toString() {
        return "{" +
            " listaPersonas='" + getListaPersonas() + "'" + "}";
    }

}