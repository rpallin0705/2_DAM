package com.example.ejemploexamen.serializers;

import java.io.File;

import com.example.ejemploexamen.model.Usuarios;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MarshallerXML {
    public static void main(String[] args) {

        Usuarios listaUsuarios = new Usuarios();

        try{
        JAXBContext xmlContest = JAXBContext.newInstance(Usuarios.class);

        Marshaller xmlMarshaller = xmlContest.createMarshaller();

        xmlMarshaller.marshal(listaUsuarios, new File("datos\\personas.xml"));
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }

    }
}
