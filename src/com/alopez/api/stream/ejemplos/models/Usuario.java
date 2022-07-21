package com.alopez.api.stream.ejemplos.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private String nombre;
    private String apellido;
    private Integer id;
    private static int ultimoId;

    private List<Factura> facturas; //Creamos el atributo facturas

    public Usuario(String nombre, String apellido) { //Constructor de la clase que recibe nombre y apellido
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = ++ultimoId; //Preincremento de ultimoId
        this.facturas = new ArrayList<>(); //Inicializamos la lista de facturas
    }

    //Getter and Setter de los atributos
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
    public void addFactura(Factura factura) { //en vez de setFacturas, lo cambiamos por addFacttura,
        // en vez de List<Factura> lo cambiamos por Factura
        this.facturas.add(factura);
        factura.setUsuario(this); //Creamos la relacion de factura con usuario
    }

    @Override //Metodo toString
    public String toString() {
        return nombre + " " + apellido;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    @Override //Generamos el equals para poder comparar las instancias por nombre y apellido
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
