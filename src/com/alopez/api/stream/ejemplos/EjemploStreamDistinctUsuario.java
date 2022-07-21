package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {

    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez",
                        "Pepe Garcia", "Pepe Perez", "Daniel Delgado", "Daniel Delgado") //Cambiamos el Stream de tipo String a tipo Usuario
//                .distinct() //Con el distinct aqui, evita qe se repitan los nombres del arreglo del Stream.of()
                .map(nombre -> new Usuario(nombre.split(" " )[0], nombre.split(" " )[1])) // El nombre de String, lo convertimos a clase Usuario
                //El metodo split serapra a través de un patrón y retorna un arreglo del tipo String
                .distinct() //Aqui permite que se repitan por la cuestion del new Usuario, ya que cada instancia es distinta
                //si queremos que no se repita se debe crear el metodo equals

        ;

        nombres.forEach(System.out::println);
    }

}