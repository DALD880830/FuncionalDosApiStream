package com.alopez.api.stream.ejemplos;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStreamInfinitoGenerate {

    public static void main(String[] args) {

        AtomicInteger contador = new AtomicInteger(0);
        Stream.generate(() -> {
                    try { //Usamos try-catch por la inclusión de TimeUnit.SECONDS.sleep()
                        TimeUnit.SECONDS.sleep(2); //Damos un delay de tiempo para que se realice el print con
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return contador.incrementAndGet(); //Incrementamos contador y los obtenemos para despues imprimirlo
                })  //Generate permite crear un flujo infinito
                .limit(7) //Limitamos a 20
                .forEach(System.out::println);  //Por cada elemento, imprimimos el valor

    }

}