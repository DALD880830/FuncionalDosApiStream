package com.alopez.api.stream.ejemplos;

import com.alopez.api.stream.ejemplos.models.Factura;
import com.alopez.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {

    public static void main(String[] args) {

        Usuario usuarioUno = new Usuario("Alejandro", "Lopez"); //Creamos nuevos usuarios
        Usuario usuarioDos = new Usuario("Daniel", "Delgado");

        usuarioUno.addFactura(new Factura("Compras tecnologia")); //A usuario 1 le adherimos 2 facturas
        usuarioUno.addFactura(new Factura("Muebles")); //Creamos una nueva factura con new Factura

        usuarioDos.addFactura(new Factura("Bicicleta")); //A usuario 2 le adherimos dos facturas
        usuarioDos.addFactura(new Factura("Notebook gamer"));

        List<Usuario> usuarios = Arrays.asList(usuarioUno, usuarioDos); //Creamos una lista de usuarios
        usuarios.stream() //Usuarios lo convertimos a Stream
                .flatMap(usuario -> usuario.getFacturas() //con flatMap obtenemos las facturas de usuario en tipo de lista
                        .stream())  //flatMap retorna otro flujo Stream
                .forEach(factura -> System.out.println(factura.getDescripcion().concat(" : cliente ") //por cada elemento imprimimos la descripcion
                        .concat(factura.getUsuario().toString()))); //concatenamos con obtener usuario y obtener su nombre


/*        for (Usuario u: usuarios){
            for (Factura f: u.getFacturas()){
                System.out.println(f.getDescripcion());
            }
        }
*/


    }

}