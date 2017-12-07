/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import servicios.ManejaClientes;

/**
 *
 * @author 171204 Grupo Salinas
 */
public class Tienda implements ManejaClientes {
    private int numeroTienda;
    private String domicilio;
    private String telefono;
    private String rfc;
    private List<Cliente> clientes;
    private List<Ticket> tickets;
    private List<Factura> facturas;

    public Tienda() {
        clientes = new ArrayList<>();
    }
    
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

    @Override
    public void altaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void bajaCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if(cliente.getIdCliente() == idCliente) {
                clientes.remove(cliente);
                break;
            }
        }
    }

    @Override
    public void actualizaCliente(Cliente cliente) {
        for (Cliente clienteTemp : clientes) {
            if(clienteTemp.getIdCliente() == cliente.getIdCliente()) {
                clienteTemp.setNombre(cliente.getNombre());
                clienteTemp.setEdad(cliente.getEdad());
                clienteTemp.setEmail(cliente.getEmail());
                clienteTemp.setDomicilio(cliente.getDomicilio());
                clienteTemp.setRfc(cliente.getRfc());
                break;
            }
        }
    }

    @Override
    public Cliente buscaCliente(int idCliente) {
        Cliente clienteTemp = null;
        for (Cliente cliente : clientes) {
            if(cliente.getIdCliente() == idCliente){
                clienteTemp = cliente;
            }
        }
        return clienteTemp;
    }

    @Override
    public void imprimeClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
    
}
