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
    private static String codigo = null, descripcion = null, opcion = null;
    private static Carrito carrito = null;
    private static Scanner leer = null;
    
    public static void main(String... args) {
    	carrito = new Carrito();
    	leer = new Scanner(System.in);
        
    	System.out.println("BIENVENIDO A \"Germain Shop Online\"");
        /**
         * Las opciones 3 y 4 me falto tiempo para implementarlas
         * System.out.println("Opciones disponibles: \n1.Lista Articulos Disponibles :: 2.Captura Articulos a Comprar :: 3.Lista Articulos del Carrito :: 4.Comprar");
         */
        //System.out.println("Opciones disponibles: \n1.Lista Articulos Disponibles :: 2.Captura Articulos a Comprar");
        System.out.println("Opciones disponibles: \n1.Lista Articulos Disponibles || 2.Captura Articulos a Comprar || 3.Lista Articulos del Carrito || 4.Comprar || 5.Salir");
        
        opciones();
        
    }
    
    private static void opciones() {
    	System.out.println("¿Qué deseas hacer?");
    	opcion = leer.nextLine();

        switch(opcion) {
            case "1":
                UtilCarrito.listarProductos();
                opciones();
                break;
            case "2":
                capturaArticulos();
                break;
            case "3":
            	listaArticulos();
            	opciones();
            	break;
            case "4":
                comprar();
            	opciones();
                break;
            case "5":
            	System.err.println(UtilCarrito.MSJ_GRACIAS);
                break;
            default:
                System.out.println("Opción inválida!!!");
                opciones();
                break;
        }
    }
    
    private static void capturaArticulos() {
        System.out.println("Después de capturar cada producto presiona enter");
        System.out.println("Cuando termines de comprar escribe la palabra \"finalizar\" ");
        System.out.println("Ingresa los productos a comprar...");
        
        String saltar = null;
        while (true) {
            saltar = leer.nextLine();
            
            if("FINALIZAR".equalsIgnoreCase(saltar)){
            	opciones();
                break;
            }else {
                descripcion = saltar.toUpperCase();
                crearArticulo(descripcion);
                carrito.agregarArticulo(articulo);
            }           
        }
    }
    
    private static void listaArticulos() {
    	if(carrito.getArticulos().size() > 0){
            carrito.listaArticulos();
        }else {
            System.out.println(UtilCarrito.MSJ_CARRITO_VACIO);
        }
    }
    
    private static void comprar() {
    	if(carrito.getArticulos().size() > 0){
            Ticket ticket = new Ticket(carrito);
            System.out.println("\nGenerando Ticket # " + ticket.getIdTicket());
            ticket.generaTicket();
        }else {
            System.out.println(UtilCarrito.MSJ_CARRITO_VACIO);
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
