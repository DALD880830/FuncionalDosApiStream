package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterCount {

    public static void main(String[] args) {

        long count = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez",
                        "Pepe Garcia", "Pepe Perez") //Cambiamos el Stream de tipo String a tipo Usuario
                .map(nombre -> new Usuario(nombre.split(" " )[0], nombre.split(" " )[1])) // El nombre de String, lo convertimos a clase Usuario
                //El metodo split serapra a través de un patrón y retorna un arreglo del tipo String
                //.filter(usuario -> usuario.getNombre().equals("Pepe")) //Filter recibe una expresión lambda del tipo Predicate, evalua una expresión booleana y si es true
                //filtra los datos. Convierte el flujo a un nuevo flujo solo con los datos que coincidan con la expresión
                //usuario, obtenemos el nombre y lo comparamos a los que se llaman Pepe
                .peek(System.out::println)
                .count() //Count no recibe nada, y solo hace un conteo
                //Buscamos por id, que sea igual a 3 u otro que pongamos
                //Con el peek, va a recorrer la lista y cuando encuentre la posicion, se sale //Se borra el findFirst porque solo puede tener un operador final
        ;


        System.out.println(count); //Con get() obtenemos el objeto encontrado para imprimirlo


        System.out.println();

    }

}