/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 171204 Grupo Salinas
 */
public class test {
    private static Articulo articulo = null;
    private static int idProducto = 0, descuento = 0;
    private static String codigo = null, descripcion = null;
    
    public static void main(String... args) {
        Carrito carrito = new Carrito();
        /*
        String descripcion = "cinturon";
        crearArticulo(descripcion);
        carrito.agregarArticulo(articulo);
        
        descripcion = "chamarra";
        crearArticulo(descripcion);
        carrito.agregarArticulo(articulo);
        
        descripcion = "anteojos";
        crearArticulo(descripcion);
        carrito.agregarArticulo(articulo);
        
        descripcion = "zapatos";
        crearArticulo(descripcion);
        carrito.agregarArticulo(articulo);
        
        descripcion = "chamarra";
        crearArticulo(descripcion);
        carrito.agregarArticulo(articulo);
        
        carrito.listaArticulos();
        
        Ticket ticket = new Ticket(carrito);
        ticket.generaTicket();
        */
        Scanner leer = new Scanner(System.in);
        System.err.println("Bienvenido a \"Germain Shop Online\"");
        
        System.out.println("----------------------------------");
        System.out.println("Cuando termines de comprar escribe la palabra \"listo\" ");
        System.out.println("Ingresa los productos a comprar...");
        
        String saltar = "";
        while (true) {
            saltar = leer.nextLine();
            
            if("LISTO".equalsIgnoreCase(saltar)){
                break;
            }else {
                descripcion = saltar.toUpperCase();
                crearArticulo(descripcion);
                carrito.agregarArticulo(articulo);
            }           
        }
        //carrito.listaArticulos();
        if(carrito.getArticulos().size() > 0){
            System.out.println("\nGenerando Ticket....");
            Ticket ticket = new Ticket(carrito);
            ticket.generaTicket();
        }else {
            System.err.println("Muchas gracias, esperamos vuelvas pronto");
        }
    }
    
    private static void crearArticulo(String descripcion){
        idProducto = UtilCarrito.obtenerIdProducto(descripcion);
        //System.out.println("Id producto -> " + idProducto);
        codigo = UtilCarrito.obtenerCodigo(idProducto);
        //System.out.println("Codigo -> " + codigo);
        double precio = UtilCarrito.obtenerPrecio(idProducto);
        //System.out.println("Precio -> " + precio);
        descuento = UtilCarrito.obtenerDescuento(idProducto);
        //System.out.println("Descuento -> " + descuento);
        
        articulo = new Articulo(codigo, descripcion, precio, descuento);
    }
}
