/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
        
        Scanner leer = new Scanner(System.in);
        System.out.println("BIENVENIDO A \"Germain Shop Online\"");
        /**
         * Las opciones 3 y 4 me faltó tiempo para implementarlas
         * System.out.println("Opciones disponibles: \n1.Lista Articulos Disponibles :: 2.Captura Articulos a Comprar :: 3.Lista Articulos del Carrito :: 4.Comprar");
         */
        System.out.println("Opciones disponibles: \n1.Lista Articulos Disponibles :: 2.Captura Articulos a Comprar");
        
        String opcion = leer.nextLine();

        switch(opcion) {
            case "1":
                UtilCarrito.listarProductos();
            case "2":
                capturaArticulos(leer, carrito);
                break;
            /*    
            case "3":
                if(carrito.getArticulos().size() > 0){
                    carrito.listaArticulos();
                }else {
                    System.err.println("Carrito vacío \nMuchas gracias, esperamos vuelvas pronto");
                }
                
                break;
            case "4":
                if(carrito.getArticulos().size() > 0){
                    Ticket ticket = new Ticket(carrito);
                    System.out.println("\nGenerando Ticket # " + ticket.getIdTicket());
                    ticket.generaTicket();
                }else {
                    System.err.println("Carrito vacío \nMuchas gracias, esperamos vuelvas pronto");
                }
                break;
            */
            default:
                System.out.println("Opción inválida!!!");
                break;
        }
    }
    
    private static void capturaArticulos(Scanner leer, Carrito carrito) {
        System.out.println("Después de capturar cada producto presiona enter");
        System.out.println("Cuando termines de comprar escribe la palabra \"listo\" ");
        System.out.println("Ingresa los productos a comprar...");
        
        String saltar = null;
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
        
        if(carrito.getArticulos().size() > 0){
            Ticket ticket = new Ticket(carrito);
            System.out.println("\nGenerando Ticket # " + ticket.getIdTicket());
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
        
        articulo = new Articulo(idProducto, codigo, descripcion, precio, descuento);
    }
}
