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
public class Tienda {
    private int numeroTienda;
    private String domicilio;
    private String telefono;
    private String rfc;
    private List<Cliente> clientes;
    private List<Ticket> tickets;
    private List<Factura> facturas;

    public int getNumeroTienda() {
        return numeroTienda;
    }

    public void setNumeroTienda(int numeroTienda) {
        this.numeroTienda = numeroTienda;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "Tienda{" + "numeroTienda=" + numeroTienda + ", domicilio=" + domicilio + ", telefono=" + telefono + ", rfc=" + rfc + ", clientes=" + clientes + ", tickets=" + tickets + ", facturas=" + facturas + '}';
    }
    
}
