package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {

    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez",
                        "Pepe Garcia", "Pepe Perez") //Cambiamos el Stream de tipo String a tipo Usuario
                .map(nombre -> new Usuario(nombre.split(" " )[0], nombre.split(" " )[1])) // El nombre de String, lo convertimos a clase Usuario
                //El metodo split serapra a través de un patrón y retorna un arreglo del tipo String
                .filter(usuario -> usuario.getNombre().equals("Pepe")) //Filter recibe una expresión lambda del tipo Predicate, evalua una expresión booleana y si es true
                //filtra los datos. Convierte el flujo a un nuevo flujo solo con los datos que coincidan con la expresión
                //usuario, obtenemos el nombre y lo comparamos a los que se llaman Pepe
                .peek(System.out::println) //Inspecciona (debug) el rastreo de los elementos
        ;

        List<Usuario> lista = nombres.collect(Collectors.toList()); //Convertimos el flujo tipo String a tipo List
        //Usamos operador collect() el cual es final, convertimos la colleccion a una lista //Imprime si se está usando
        //el peek, sin embargo, podemos imprimirlo con un forEach
        //Cambiamos el List de tipo String a tipo Usuario
//        lista.forEach(System.out::println);
        lista.forEach(System.out::println);

        System.out.println();

    }

}