package com.example.ejemploexamen.serializers;

import java.io.File;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.example.ejemploexamen.model.Usuarios;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


public class MarshallerJson {
    public static void main(String[] args) {
        Usuarios listaUsuarios = new Usuarios();
        JAXBContext jaxbContext;
        System.setProperty("java.xml.bind.JABXContextFActory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

        // Primero se le pasa el tipo de objeto que se va a serializar
        try {
            jaxbContext = JAXBContext.newInstance(Usuarios.class);
            Marshaller jsonMarshmaller = jaxbContext.createMarshaller();

            // Establecemos las propiedades para al marshallerJSON
            jsonMarshmaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jsonMarshmaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            jsonMarshmaller.marshal(listaUsuarios, new File("datos\\usuarios.json"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Creamos el Marshmaller

    }
}
