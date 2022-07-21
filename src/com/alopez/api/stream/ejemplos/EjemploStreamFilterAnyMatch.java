package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilterAnyMatch {

    public static void main(String[] args) {

        boolean existe = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez",
                        "Pepe Garcia", "Pepe Perez") //Cambiamos el Stream de tipo String a tipo Usuario
                .map(nombre -> new Usuario(nombre.split(" " )[0], nombre.split(" " )[1])) // El nombre de String, lo convertimos a clase Usuario
                //El metodo split serapra a través de un patrón y retorna un arreglo del tipo String
                //.filter(usuario -> usuario.getNombre().equals("Pepe")) //Filter recibe una expresión lambda del tipo Predicate, evalua una expresión booleana y si es true
                //filtra los datos. Convierte el flujo a un nuevo flujo solo con los datos que coincidan con la expresión
                //usuario, obtenemos el nombre y lo comparamos a los que se llaman Pepe
                .peek(System.out::println)
                .anyMatch(usuario -> usuario.getId().equals(0)) //AnyMatch retorna un boolean, recibe una expresion lambda del tipo Predicate
                //Buscamos por id, que sea igual a 3 u otro que pongamos
                //Con el peek, va a recorrer la lista y cuando encuentre la posicion, se sale //Se borra el findFirst porque solo puede tener un operador final
        ;


        System.out.println(existe); //Con get() obtenemos el objeto encontrado para imprimirlo

/*
        List<Usuario> lista = Arrays.asList(new Usuario("Alex", "Lopez"),
                new Usuario("Daniel", " Delgado"),
                new Usuario("Paco", " Gutierrez"),
                new Usuario("Pepe", " Garcia"),
                new Usuario("Pepe", " Perez"));

        boolean resultado = false; //Este boolean y el for es equivalente al AnyMatch de Java8
        for(Usuario u: lista){
            if (u.getId().equals(3)){
                resultado = true;
                break;
            }
        }
        System.out.println(resultado);
*/

        System.out.println();

    }

}