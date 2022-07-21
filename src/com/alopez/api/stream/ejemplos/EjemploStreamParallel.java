package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {

    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Alejandro", "Lopez"));
        lista.add(new Usuario("Daniel", "Delgado"));
        lista.add(new Usuario("Paco", "Gutierrez"));
        lista.add(new Usuario("Pepe", "Garcia"));
        lista.add(new Usuario("Pepe", "Gonzalez"));
        lista.add(new Usuario("Eduardo", "Martinez"));
        lista.add(new Usuario("Frank", "Black"));
        lista.add(new Usuario("Eduardo", "Sanchez"));

        long tiempoUno = System.currentTimeMillis(); //Obtenemos el tiempo inicial en milisegundos
        String nombres = lista.stream() //Convertimos los usuarios de la lista a un Stream
                .parallel() //Convierte el flujo a un flujo que soporta un pool de Thread
                .map(usuario -> usuario //Usamos map para modificar
                        .toString() //toString concatena nombre y apellido
                        .toUpperCase()) //Convertimos el resultado de toString a puras mayusculas
                .peek(n -> {
                    System.out.println("Nombre Thread: " + Thread.currentThread().getName()
                    + " - " + n); //Concatenamos con el nombre
                })
                .flatMap(nombre -> { //Filtramos con flatMap
                    try { //Sleep pide un try-catch
                        TimeUnit.SECONDS.sleep(1); //Damos un delay de 2 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (nombre.contains("eduardo".toUpperCase())){ //Si el nobre contiene PEPE
                        return Stream.of(nombre); //Retorna nombre
                    }
                    return Stream.empty(); //Si no lo contiene retorna un Stream vacio
                })
                .findAny().orElse("");
        long tiempoDos = System.currentTimeMillis(); //Obtenemos el tiempo final en milisegundos
        System.out.println("Tiempo total: " + (tiempoDos-tiempoUno)); //Resta del tiempo final con el tiempo inicial
        System.out.println(nombres);

    }

}