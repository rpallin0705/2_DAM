package com.example.ejemploexamen.model;

import java.util.List;


public class Usuarios {
    private List<Usuario> listaUsuarios;
    

    public Usuarios() {
    }

    public Usuarios(List<Usuario> usuarios) {
        this.listaUsuarios = usuarios;
    }

    public List<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> usuarios) {
        this.listaUsuarios = usuarios;
    }

    public Usuarios usuarios(List<Usuario> usuarios) {
        setListaUsuarios(usuarios);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " usuarios='" + getListaUsuarios() + "'" +
            "}";
    }
    

}
