/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import util.CarritoException;

/**
 *
 * @author 171204 Grupo Salinas
 */
public class Ticket {
    private int idTicket;
    private Carrito carrito;
    private double subTotal;
    private double descuento;
    private double iva;
    private double total;
    private static int IVA = 16;
    private static int nextID = 0;

    public Ticket() {}
    
    public Ticket(Carrito carrito) {
        this.idTicket = nextID++;
        this.descuento = 0.0;
        this.total = 0.0;
        this.iva = 0.0;
        this.carrito = carrito;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public void generaTicket() {
        List<Articulo> articulos = this.carrito.getArticulos();
        Collections.sort(articulos);
        double sumaPrecio = 0.0;
        double sumaDescuento = 0.0;
        
        try {
        calculaCantidades(articulos);
        
        //carrito.listaArticulos();
        
        String articulosVendidos = "# ARTS. VENDIDOS " + articulos.size();
        System.err.println("Articulo" + "\t" + "Codigo" + "\t\t" + "P/Unitario" + "\t" + "D/Unitario");
        for (Articulo articulo : articulos) {
            if(articulo != null){
                System.out.println(UtilCarrito.completaCadena(articulo.getDescripcion(), 11) + "\t" + articulo.getCodigo() + "\t\t" + String.format("$%,.2f ", articulo.getPrecio()) + "\t" + String.format("$%,.2f ", articulo.getDescuentoUnitario()) + "\t(" + articulo.getDescuento() + "%)");
                sumaPrecio += articulo.getPrecio();
                sumaDescuento += articulo.getDescuentoUnitario();
            }
        }
        this.subTotal = sumaDescuento;
        
        System.out.println("\n\t\t\t\t" + "SubTotal " + "\t" + String.format("$%,.2f %n", this.subTotal));
        System.out.println("\n\t\t\t\t" + "Ahorro " + "\t\t" + String.format("$%,.2f %n", (sumaPrecio-sumaDescuento)));
        calculaTotal();
        System.out.println("\t\t\t\t" + UtilCarrito.completaCadena("IVA(16%) ", 5) + "\t" + String.format("$%,.2f %n", this.iva));
        System.out.println("\t\t\t\t" + UtilCarrito.completaCadena("Total ", 5) + "\t\t" + String.format("$%,.2f %n", this.total));
        System.out.println("");
        
        System.out.println(UtilCarrito.completaCadena("", 22) + articulosVendidos);
        System.out.println("");
        System.out.println(UtilCarrito.completaCadena("", 20) + "\"***COPIA DE CLIENTE***\"");
        }catch(CarritoException ce) {
            System.err.println(ce.getMessage());
        }
    }
    
    private double obtenerIva() {
        this.iva = this.subTotal * IVA / 100;
        return this.iva;
    }

    private void calculaTotal(){
        this.total = this.subTotal + obtenerIva();
    }
    
    private void calculaCantidades(List<Articulo> articulos)throws CarritoException{
        int cantidad = 0;
        try {
        for (Map.Entry<Integer, String> entry : UtilCarrito.catalogoCodigos.entrySet()) {
            for (Articulo articulo : articulos) {
                if(entry.getValue().equals(articulo.getCodigo())){
                    cantidad++;
                }
            }
            actualizaCantidad(entry.getValue(), cantidad, articulos);
            cantidad = 0;
        }
        }catch(CarritoException ce) {
            throw new CarritoException(ce.getMessage());
        }

    }
    
    private void actualizaCantidad(String codigo, int cantidad, List<Articulo> articulos)throws CarritoException {
        try{
        for (Articulo articulo : articulos) {
            if(articulo.getCodigo().equals(codigo)){
                articulo.setCantidad(cantidad);
                calculaPrecioUnitarioConDescuento(articulo);
            }
        }
        }catch(NullPointerException e){
           throw new CarritoException("Alguno de los articulos no está disponible!!!");
        }
    }
    
    private void calculaPrecioUnitarioConDescuento(Articulo articulo) {
        for (Map.Entry<Integer, Integer> entry : UtilCarrito.catalogoDescuentos.entrySet()) {
            if(entry.getKey().equals(articulo.getIdArticulo())){
                double descuento = articulo.getPrecio() - (((double)entry.getValue() / 100) * articulo.getPrecio());
                articulo.setDescuentoUnitario(descuento);
            }
        }
    }
}
