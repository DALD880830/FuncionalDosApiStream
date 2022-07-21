package com.alopez.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {

    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Alex", "Daniel", "Paco", "Pepe");
        //Stream es el tipo de la interfaz, con el generic indicamos el tipo de dato que va a incluir el flujo
        //Metodo estatico of, recibe un arreglo de valores

        nombres.forEach(System.out::println); //.forEach es un operador final o terminal, que retorna un void
        //Siempre se debe llamar a un metodo terminal, ya que el flujo sin este metodo terminal no hace nada

        System.out.println();

        String[] arreglo = {"Alex", "Daniel", "Paco", "Pepe"}; //Creamos un arreglo de Strings
        Stream<String> nombresDos = Arrays.stream(arreglo); //Clase Helper Arrays y a stream le pasamos el arreglo
        nombresDos.forEach(System.out::println);

        System.out.println();

        Stream<String> nombresTres = Stream.<String>builder() //Con el constructor builder agregamos elementos
                .add("Alex")
                .add("Daniel")
                .add("Paco")
                .add("Pepe")
                .build(); //Cuando ya estén agregados todos los elementos, con build, para construir el String
        nombresTres.forEach(System.out::println);

        System.out.println();

        List<String> lista = new ArrayList<>();
        lista.add("Alex");
        lista.add("Daniel");
        lista.add("Paco");
        lista.add("Pepe");

        Stream<String> nombresCuatro = lista.stream();
        nombresCuatro.forEach(System.out::println);

        System.out.println();

        //No es siempre necesario crear la variable Stream, ya que simplemente se puede utilizar
        lista.stream().forEach(System.out::println);



    }

}