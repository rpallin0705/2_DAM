package com.example.ejemploexamen.serializers;

import java.io.File;


import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import com.example.ejemploexamen.model.Usuarios;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


/**
 * Ejemplo de generador de personas.
 *
 */
public class UnMarshallerJSON {
    public static void main(String[] args) {
        Usuarios lista = new Usuarios();
        /*
         * PersonasGenerator pg = new PersonasGenerator();
         * pg.generate(10);
         * 
         * lista = new Personas(pg.getPersonas());
         */
        JAXBContext jaxbContext;

        try {
            System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
            /*
             * jaxbContext = JAXBContext.newInstance(lista.getClass());
             * Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
             * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
             * jaxbMarshaller.marshal(lista, new File("personas.xml"));
             */

            jaxbContext = JAXBContext.newInstance(lista.getClass());

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            // Para JSON
            jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);

            Object objeto = jaxbUnmarshaller.unmarshal(new File("personas.json"));
            lista = (Usuarios) objeto;
            System.out.println(lista.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}