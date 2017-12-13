/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author 171204 Grupo Salinas
 */
public class Articulo implements Comparable<Articulo>{
    private int idArticulo;
    private String codigo;
    private String descripcion;
    private double precio;
    private double descuentoUnitario;
    private int descuento;
    private int cantidad;
    
    public Articulo(){}

    public Articulo(String descripcion, double precio, int descuento) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
    }
    
    public Articulo(int idArticulo, String codigo, String descripcion, double precio, int descuento) {
        this.idArticulo = idArticulo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion != null){
            this.descripcion = descripcion;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio >= 0){
            this.precio = precio;
        }
    }

    public double getDescuentoUnitario() {
        return descuentoUnitario;
    }

    public void setDescuentoUnitario(double descuentoUnitario) {
        this.descuentoUnitario = descuentoUnitario;
    }
    
    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        if(descuento >= 0){
            this.descuento = descuento;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }   

    @Override
    public String toString() {
        //return "Articulo{" + "idArticulo=" + idArticulo + ", cantidad=" + cantidad + ", codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + String.format("$%,.2f %n", precio) + ", descuento=" + descuento + ", descuentoUnitario=" + String.format("$%,.2f %n", descuentoUnitario) + '}';
    	return UtilCarrito.completaCadena(descripcion, 12) + String.format("$%,.2f\t", precio) + descuento + "%";
    }

    @Override
    public int compareTo(Articulo t) {
        return this.descripcion.compareTo(t.descripcion);
    }

}
