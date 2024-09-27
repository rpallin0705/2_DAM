package com.iesvdc.acceso;

import com.iesvdc.acceso.model.Persona;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String caracteresNoPermitidos = "[á-ü]";
        Persona persona = new Persona();
        persona.setNombre(" ÁLVARO");
        persona.setApellidos("Palomares López");
        String email = (persona.getNombre().trim().charAt(0) + persona.getApellidos().trim()).replace(" ", "").toLowerCase();
        System.out.println(email);
        System.out.println(email.matches(caracteresNoPermitidos));
    }
}
