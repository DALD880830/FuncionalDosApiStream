package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinct {

    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez", "Pepe Garcia", "Pepe Perez",
                        "Daniel Delgado", "Daniel Delgado", "Daniel Delgado") //Cambiamos el Stream de tipo String a tipo Usuario
                .distinct(); //Lo que esta repetido lo agrupa en uno solo, entonces los elementos repetidos no se imprimen
                nombres.forEach(System.out::println); //Por cada uno de los elementos, realiza un System.out.println



    }

}