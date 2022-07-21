package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {

    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Alex Lopez", "Daniel Delgado", "Paco Gutierrez",
                        "Pepe Garcia", "Pepe Perez") //Cambiamos el Stream de tipo String a tipo Usuario
                .map(nombre -> new Usuario(nombre.split(" " )[0], nombre.split(" " )[1])) // El nombre de String, lo convertimos a clase Usuario
                //El metodo split serapra a través de un patrón y retorna un arreglo del tipo String
                .filter(usuario -> usuario.getNombre().equals("Pepex")) //Filter recibe una expresión lambda del tipo Predicate, evalua una expresión booleana y si es true
                //filtra los datos. Convierte el flujo a un nuevo flujo solo con los datos que coincidan con la expresión
                //usuario, obtenemos el nombre y lo comparamos a los que se llaman Pepe
                .peek(System.out::println) //Inspecciona (debug) el rastreo de los elementos
        ;

        Optional<Usuario> usuarioOptional = nombres.findFirst(); //findFirst() encuentra la primera coincidencia, tambien es un operador final
        //Convierte el flujo a un solo objeto
//        System.out.println("Impreso por el get(): " + usuarioOptional.get()); //Con get() obtenemos el objeto encontrado para imprimirlo
//        System.out.println("Impreso por el get(): " + usuarioOptional.orElse(new Usuario("Yaz","Rodriguez")));
        //Con la funcion orElse(), si no encuentra el objeto retorna uno por default, que puede ser un usuario nuevo o un objeto null
        //Aunque colocar null no es muy recomendable porque podemos caer nuevamente en el NullPointerException

        System.out.println("Impreso por el orElseGet(): " + usuarioOptional.orElseGet(()->new Usuario("Yaz","Rodriguez")));
        //orElseGet() recibe un supplier, el tipo supplier no recibe argumento pero si devuelve un valor

//         System.out.println("Impreso por el orElseGet(): " + usuarioOptional.orElseThrow());
        //orElseThrow() Si encuentra el valor, lo devuelve, si no, manda una excepcion
//        if (usuarioOptional.isPresent()) {  //isPresent() isEmpty() es como lo mismo, porque uno es la negación del otro
          if (!usuarioOptional.isEmpty()) {
            System.out.println(usuarioOptional.get().getNombre()); //Si existe el objeto, obtenemos el nombre y lo imprimimos
        }else{
            System.out.println("No existe el objeto");
        }

//        System.out.println(usuarioOptional.hashCode()); //hashCode() nos muestra del objeto colocado en el filter
//        System.out.println(usuarioOptional.isPresent()); //isPresent() retorna un valor booleano, del objeto que busca con el filter


        System.out.println();

    }

}