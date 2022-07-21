package com.alopez.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {

    public static void main(String[] args) {

        IntStream numeros = IntStream.range(5, 20) //Utilizamos IntStream para usar el metodo range, pasamos el rango de 5 a 20
                //es desde el 5 al 19 ya que el 20 no se incluye //Para incluir el ultimo numero podrmos usar IntStream.rangeClosed()
                //Para trabajar con numeros mas grandes o decimales esta el LongStream o el DoubleStream
                .peek(System.out::println);
        System.out.println();
//        int resultado = numeros.sum(); //el metodo sum solo esta disponible en IntStream
        IntSummaryStatistics stats = numeros.summaryStatistics();
//                int resultado = numeros.reduce(0, (a,b) -> a+b); //Reduce el Stream en un solo resultado
//                int resultado = numeros.reduce(0, Integer::sum); //Simplificando usando la referencia del metodo
                //Suma total del rango
                System.out.println(stats); //Al imprimir IntSummaryStatistics podemos obtener juntos los datos o separados, así son juntos
        System.out.println(stats.getCount()); //Así son separados, podemos obtener el numero de registros, el maximo numero, el minimo numero
        System.out.println(stats.getMax()); //Podemos obtener el promedio, y la suma
        System.out.println(stats.getMin());
        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());

        IntStream numerosDos = IntStream.of(3,19,18,68,79,5,6,14,2);
        IntSummaryStatistics estadisticos = numerosDos.summaryStatistics();
        System.out.println("Minimo del arreglo: " + estadisticos.getMin());

    }

}