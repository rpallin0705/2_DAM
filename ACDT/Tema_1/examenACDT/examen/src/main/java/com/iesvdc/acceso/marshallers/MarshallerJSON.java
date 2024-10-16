package com.iesvdc.acceso.marshallers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import com.iesvdc.acceso.model.Proyecto;


public class MarshallerJSON {
    public static void marshallAJSON(Proyecto proyecto) {
        System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");


        try {

            JAXBContext jsonContext = JAXBContext.newInstance(Proyecto.class);
        
            Marshaller jsonMarshaller = jsonContext.createMarshaller();

            jsonMarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
            jsonMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

            jsonMarshaller.marshal(proyecto, new File("data/proyectoAJON.json"));

        } catch (JAXBException e) {
            // Añadir excepciones personalizadas
            System.err.println(e.getMessage());
        }
    }
}
