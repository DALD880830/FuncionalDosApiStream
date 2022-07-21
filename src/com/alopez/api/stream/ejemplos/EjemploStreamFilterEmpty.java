package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {

    public static void main(String[] args) {

        long count = Stream.of("Alex Lopez", "", "Paco Gutierrez",
                        "", "Pepe Perez") //Cambiamos el Stream de tipo String a tipo Usuario
//                .filter(n-> n.isEmpty()) //Este es equivalente al de abajo
                .filter(String::isEmpty)//Filter recibe una expresión lambda del tipo Predicate, evalua una expresión booleana y si es true
                //filtra los datos. Convierte el flujo a un nuevo flujo solo con los datos que coincidan con la expresión
                .peek(System.out::println) //Inspecciona (debug) el rastreo de los elementos
                .count(); //count es un operador terminal, cuenta el numero de nombres que se encontraron con filter
                System.out.println("count = " + count);

    }

}