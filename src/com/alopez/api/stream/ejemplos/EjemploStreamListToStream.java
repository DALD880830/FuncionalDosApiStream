package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {

    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Alejandro", "Lopez"));
        lista.add(new Usuario("Daniel", "Delgado"));
        lista.add(new Usuario("Paco", "Gutierrez"));
        lista.add(new Usuario("Pepe", "Garcia"));
        lista.add(new Usuario("Pepe", "Gonzalez"));
        lista.add(new Usuario("Eduardo", "Martinez"));
        lista.add(new Usuario("Frank", "Black"));
        lista.add(new Usuario("Eduardo", "Sanchez"));

        lista.stream() //Convertimos los usuarios de la lista a un Stream
                .map(usuario -> usuario //Usamos map para modificar
                        .getNombre() //Obtenemos el nombre
                        .toUpperCase() //Convertimos el nombre a mayusculas
                        .concat(" ") //Concatenamos con un espacio
                        .concat(usuario.getApellido()) //Concatenamos con el Apellido, el cual lo obtenemos con getApellido()
                        .toUpperCase()) //Convertimos el apellido a puras mayusculas
                .flatMap(nombre -> { //Filtramos con flatMap
                    if (nombre.contains("eduardo".toUpperCase())){ //Si el nobre contiene PEPE
                        return Stream.of(nombre); //Retorna nombre
                    }
                    return Stream.empty(); //Si no lo contiene retorna un Stream vacio
                })
                .map(nombre -> nombre.toLowerCase())
                .forEach(System.out::println); //Por cada elemento imprimimos el resultado

    }

}