package com.iesvdc.acceso;

import com.iesvdc.acceso.marshallers.MarshallerJSON;
import com.iesvdc.acceso.marshallers.MarshallerXML;
import com.iesvdc.acceso.marshallers.UnMarshallerJSON;
import com.iesvdc.acceso.marshallers.UnMarshallerXML;
import com.iesvdc.acceso.model.Proyecto;

public class App {
    public static void main(String[] args) {
        if(args.length > 1 || args.length < 1)
            usage();

            // if (args[0].endsWith(".json")) {
            //     jsonAXML(args[0]);   
            // } else if (args[0].endsWith(".xml")) {
            //     xmlAJSON(args[0]);
            // }

        jsonAXML("proyecto.json");
        xmlAJSON("proyecto.xml");
    }

    private static void jsonAXML(String archivoJSON) {
        Proyecto proyecto = UnMarshallerJSON.UnMarshallJSON(archivoJSON);
        MarshallerXML.marshallXML(proyecto);
    }

    private static void xmlAJSON(String archivoXML) {
        Proyecto proyecto = UnMarshallerXML.UnMarshallXML(archivoXML);
        MarshallerJSON.marshallAJSON(proyecto);
    }

    private static void usage() {
        System.err.println("Solo se le puede pasar un argumento al programa");
    }
}
