package com.example.ejemploexamen.serializers;

import java.io.File;

import com.example.ejemploexamen.model.Usuarios;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


/**
 * Ejemplo de unmarshaller de personas. 
 * Versión XML.
 */
public class UnMarshallerXML 
{
    public static void main( String[] args )
    {
        Usuarios lista = new Usuarios();
        JAXBContext jaxbContext;

        try {
            
            jaxbContext = JAXBContext.newInstance(lista.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Object objeto = jaxbUnmarshaller.unmarshal(new File("personas.xml"));
            lista = (Usuarios) objeto;
            System.out.println(lista.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
    }
}
