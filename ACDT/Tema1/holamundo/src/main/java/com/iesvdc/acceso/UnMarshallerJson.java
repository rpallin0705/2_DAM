package com.iesvdc.acceso;

import java.io.File;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import com.iesvdc.acceso.model.Personas;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class UnMarshallerJson {
    public static void main(String[] args) {
        Personas lPersonas = new Personas();

        try {
            System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

            JAXBContext jaxbContext = JAXBContext.newInstance(lPersonas.getClass());

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            lPersonas = (Personas) unmarshaller.unmarshal(new File("datos\\personas.json"));

            lPersonas = (Personas) lPersonas;

            System.out.println(lPersonas.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
