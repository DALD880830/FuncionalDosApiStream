package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFlatMap {

    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez",
                        "Pepe Garcia", "Pepe Perez") //Cambiamos el Stream de tipo String a tipo Usuario
                .map(nombre -> new Usuario(nombre.split(" " )[0], nombre.split(" " )[1])) // El nombre de String, lo convertimos a clase Usuario
                //El metodo split serapra a través de un patrón y retorna un arreglo del tipo String
                .flatMap(usuario -> { //flatMap debe retornar otro flujo, un Stream, pór cada elemento devuelve un Stream separado
                    if(usuario.getNombre().equalsIgnoreCase("Pepe")){
                        return Stream.of(usuario);
                    }
                    return Stream.empty();
                })
        ;

        nombres.forEach(System.out::println);

        System.out.println();

    }

}