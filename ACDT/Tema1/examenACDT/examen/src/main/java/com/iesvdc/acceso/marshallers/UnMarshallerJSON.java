package com.iesvdc.acceso.marshallers;

import java.io.File;

import javax.xml.bind.Unmarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import com.iesvdc.acceso.model.Proyecto;


public class UnMarshallerJSON {
    public static Proyecto UnMarshallJSON(String archivoJSON) {
        Proyecto proyecto = new Proyecto();
        System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        try {
           

            JAXBContext jaxbContext = JAXBContext.newInstance(proyecto.getClass());

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            proyecto = (Proyecto) unmarshaller.unmarshal(new File("data/" + archivoJSON));

            proyecto = (Proyecto) proyecto;

            System.out.println(proyecto.toString());

        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }

        return proyecto;
    }
}