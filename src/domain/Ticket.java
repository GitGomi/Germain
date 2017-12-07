/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author 171204 Grupo Salinas
 */
public class Ticket {
    
    private Tienda tienda;
    private Carrito carrito;
    private double subTotal;
    private double descuento;
    private double iva;
    private double total;
    private static int IVA = 16;

    public Ticket() {}
    
    public Ticket(Carrito carrito) {
        this.descuento = 0.0;
        this.total = 0.0;
        this.iva = 0.0;
        this.carrito = carrito;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
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
        calculaCantidades();
        List<Articulo> articulos = this.carrito.getArticulos();
        String articulosVendidos = "# ARTS. VENDIDOS " + articulos.size();
        System.err.println("Articulo" + "\t" + "Código" + "\t\t" + "P/Unitario" + "\t" + "D/Unitario");
        for (Articulo articulo : articulos) {
            if(articulo != null){
                System.out.println(UtilCarrito.completaCadena(articulo.getDescripcion(), 11) + "\t" + articulo.getCodigo() + "\t\t" + String.format("$%,.2f %n", articulo.getPrecio()));
                this.subTotal += articulo.getPrecio();
            }
        }
        System.out.println("" + "\t\t" + "SubTotal " + "\t" + String.format("$%,.2f %n", this.subTotal));
        calculaTotal();
        System.out.println("" + "\t\t" + UtilCarrito.completaCadena("IVA(16%) ", 5) + "\t" + String.format("$%,.2f %n", this.iva));
        System.out.println("" + "\t\t" + UtilCarrito.completaCadena("Total ", 5) + "\t\t" + String.format("$%,.2f %n", this.total));
        System.out.println("");
        
        System.out.println(UtilCarrito.completaCadena("", 10) + articulosVendidos);
        System.out.println("");
        System.out.println("\t"+ UtilCarrito.completaCadena("***COPIA DE CLIENTE***", 10));
    }
    
    private double obtenerIva() {
        this.iva = this.subTotal * IVA / 100;
        return this.iva;
    }

    private void calculaTotal(){
        this.total = this.subTotal + obtenerIva();
    }
    
    private void calculaCantidades(){
        List<Articulo> articulos = this.carrito.getArticulos();
        carrito.listaArticulos();
    }
}
