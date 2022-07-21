package com.alopez.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {

    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez", "Pepe Garcia", "Pepe Perez",
                        "Daniel Delgado", "Daniel Delgado", "Daniel Delgado") //Cambiamos el Stream de tipo String a tipo Usuario
                .distinct(); //Lo que esta repetido lo agrupa en uno solo, entonces los elementos repetidos no se imprimen
                String resultado = nombres.reduce("resultado concatenacion", (a,b) -> a+ ", " +b); //Reduce el Stream en un solo resultado
                System.out.println(resultado);


    }

}