/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 171204 Grupo Salinas
 */
public class UtilCarrito {
    private static Map<Integer,String> catalogoProductos = new HashMap<>();
    public static Map<Integer,String> catalogoCodigos = new HashMap<>();
    private static Map<Integer,Double> catalogoPrecios = new HashMap<>();
    public static Map<Integer,Integer> catalogoDescuentos = new HashMap<>();
    
    static {
        crearCatalogoProductos();
        crearCatalogoCodigos();
        crearCatalogoPrecios();
        crearCatalogoDescuentos();
    }
    
    private static void crearCatalogoProductos (){
        catalogoProductos.put(1,"Chamarra");
        catalogoProductos.put(2,"Camisa");
        catalogoProductos.put(3,"Corbata");
        catalogoProductos.put(4,"Zapatos");
        catalogoProductos.put(5,"Anteojos");
        catalogoProductos.put(6,"Cinturon");
        catalogoProductos.put(7,"Pantalon");
        catalogoProductos.put(8,"Reloj");
        catalogoProductos.put(9,"Ropa Interior");
        catalogoProductos.put(10,"Sudadera");
        catalogoProductos.put(11,"Calcetines");
        catalogoProductos.put(12,"Bufanda");
    }
    
    private static void crearCatalogoCodigos (){
        catalogoCodigos.put(1,"P001");
        catalogoCodigos.put(2,"P002");
        catalogoCodigos.put(3,"P003");
        catalogoCodigos.put(4,"P004");
        catalogoCodigos.put(5,"P005");
        catalogoCodigos.put(6,"P006");
        catalogoCodigos.put(7,"P007");
        catalogoCodigos.put(8,"P008");
        catalogoCodigos.put(9,"P009");
        catalogoCodigos.put(10,"P010");
        catalogoCodigos.put(11,"P011");
        catalogoCodigos.put(12,"P012");
    }
    
    private static void crearCatalogoPrecios (){
        catalogoPrecios.put(1, 650.00);
        catalogoPrecios.put(2, 700.00);
        catalogoPrecios.put(3, 240.00);
        catalogoPrecios.put(4, 3200.00);
        catalogoPrecios.put(5, 6500.00);
        catalogoPrecios.put(6, 800.00);
        catalogoPrecios.put(7, 730.00);
        catalogoPrecios.put(8, 3000.00);
        catalogoPrecios.put(9, 220.00);
        catalogoPrecios.put(10, 1200.00);
        catalogoPrecios.put(11, 80.00);
        catalogoPrecios.put(12, 330.00);
    }
    
    private static void crearCatalogoDescuentos (){
        catalogoDescuentos.put(1, 15);
        catalogoDescuentos.put(2, 10);
        catalogoDescuentos.put(3, 5);
        catalogoDescuentos.put(4, 8);
        catalogoDescuentos.put(5, 3);
        catalogoDescuentos.put(6, 6);
        catalogoDescuentos.put(7, 11);
        catalogoDescuentos.put(8, 25);
        catalogoDescuentos.put(9, 16);
        catalogoDescuentos.put(10,75);
        catalogoDescuentos.put(11,35);
        catalogoDescuentos.put(12,18);
    }
    
    public static Integer obtenerIdProducto (String producto) {
        int id = 0;
        for (Map.Entry<Integer, String> entry : catalogoProductos.entrySet()) {
            if(entry.getValue().equalsIgnoreCase(producto)){
                //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                id = entry.getKey();
                break;
            }
        }
        return id;
    }
    
    public static String obtenerCodigo (int idProducto) {
        String codigo = null;
        for (Map.Entry<Integer, String> entry : catalogoCodigos.entrySet()) {
            if(entry.getKey() == idProducto){
                //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                codigo = entry.getValue();
                break;
            }
        }
        return codigo;
    }
    
    public static Double obtenerPrecio (int idProducto) {
        double precio = 0.0;
        for (Map.Entry<Integer, Double> entry : catalogoPrecios.entrySet()) {
            if(entry.getKey() == idProducto){
                //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                precio = entry.getValue();
                break;
            }
        }
        return precio;
    }
    
    public static Integer obtenerDescuento (int idProducto) {
        int descuento = 0;
        for (Map.Entry<Integer, Integer> entry : catalogoDescuentos.entrySet()) {
            if(entry.getKey() == idProducto){
                //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                descuento = entry.getValue();
                break;
            }
        }
        return descuento;
    }
    
    public static void listarProductos () {
        for (Map.Entry<Integer, String> entry : catalogoProductos.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    
    public static String completaCadena(String base, int tam) {
        StringBuilder temp = new StringBuilder(base);
        for (int i = base.length(); i < tam; i++) {
            temp.append(" ");
        }
        return temp.toString();
    }
}
