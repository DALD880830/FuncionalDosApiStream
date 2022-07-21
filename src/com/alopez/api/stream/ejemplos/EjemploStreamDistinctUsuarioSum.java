package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {

    public static void main(String[] args) {

        IntStream largoNombres = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez",
                        "Pepe Garcia", "Pepe Perez", "Daniel Delgado", "Daniel Delgado") //Cambiamos el Stream de tipo String a tipo Usuario
//                .distinct() //Con el distinct aqui, evita qe se repitan los nombres del arreglo del Stream.of()
                .map(nombre -> new Usuario(nombre.split(" " )[0], nombre.split(" " )[1])) // El nombre de String, lo convertimos a clase Usuario
                //El metodo split serapra a través de un patrón y retorna un arreglo del tipo String
                .distinct() //Aqui permite que se repitan por la cuestion del new Usuario, ya que cada instancia es distinta
                //si queremos que no se repita se debe crear el metodo equals
                .mapToInt(u -> u.toString().length()) //usuario lo convertimos a int e imprime la cantidad de caracteres
                .peek(System.out::println); //Al no poder usar 2 operadores finales, en vez de usar el forEach usamos este peek

        ;

//        largoNombres.forEach(System.out::println);
//        System.out.println("Sumatoria: " + largoNombres.sum()); //Imprime la suma, solo se puede usar un operador final, es este o el forEach
//        System.out.println("Sumatoria: " + largoNombres.average());

        IntSummaryStatistics stats = largoNombres.summaryStatistics(); //Para obtener todo, sum, min, max, avg y count mejor usamos IntSummaryStatistics
        System.out.println(stats);


    }

}