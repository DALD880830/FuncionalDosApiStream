package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {

    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez", "Pepe Perez") //Cambiamos el Stream de tipo String a tipo Usuario
                .map(String::toUpperCase) //map es un function, se emite cada elemento, pero lo retorna modificado
                .map(nombre -> new Usuario(nombre.split(" " )[0], nombre.split(" " )[1])) // El nombre de String, lo convertimos a clase Usuario
                //El metodo split serapra a través de un patrón y retorna un arreglo del tipo String
                .peek(e -> System.out.println(e)) //Inspecciona (debug) el rastreo de los elementos
                //Al imprimir nos muestra un hexadecimal que corresponde a la ubicacion en la memoria del objeto
                .map(usuario -> { //Objeto usuario
                    String nombre = usuario.getNombre().toLowerCase(); //Obtenemos el nombre con getNombre y lo convertimos a minusculas
                    usuario.setNombre(nombre); //Del objeto usuario, pasamos el nombre
                    return usuario; //Retornamos el objeto usuario
                })
//                .peek(e -> System.out.println(e))
        ;

        List<Usuario> lista = nombres.collect(Collectors.toList()); //Convertimos el flujo tipo String a tipo List
        //Usamos operador collect() el cual es final, convertimos la colleccion a una lista //Imprime si se está usando
        //el peek, sin embargo, podemos imprimirlo con un forEach
        //Cambiamos el List de tipo String a tipo Usuario
//        lista.forEach(System.out::println);
        lista.forEach(usuario -> System.out.println(usuario.getNombre()));
        System.out.println();
        lista.forEach(usuario -> System.out.println(usuario.getApellido()));
//        nombres.forEach(System.out::println); //Recorremos los elementos con el forEach y los imprimimos
        //El forEach es un operador terminal, si no estuviera, el programa simplemente no hace nada
        System.out.println();
        lista.forEach(usuario -> System.out.println(usuario)); //Imprimimos con el uso del toString creado en la clase usuario
        Usuario usuario = new Usuario("Alejandro", "López");



        System.out.println();

    }

}