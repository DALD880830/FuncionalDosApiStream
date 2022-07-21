package com.alopez.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduceInt {

    public static void main(String[] args) {

        Stream<Integer> numeros = Stream.of(5, 10, 15, 20); //Cambiamos el Stream a tipo Integer
                int resultado = numeros.reduce(0, (a,b) -> a+b); //Reduce el Stream en un solo resultado
//                int resultado = numeros.reduce(0, Integer::sum); //Simplificando usando la referencia del metodo
                //Empieza en 0, suma 0 con 5, luego el resultado mas 10, el resultado con 15 y el resultado con 20
                System.out.println(resultado);


    }

}