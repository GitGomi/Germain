/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import domain.Cliente;

/**
 *
 * @author 171204 Grupo Salinas
 */
public interface ManejaClientes {
    
    public void altaCliente(Cliente cliente);
    
    public void bajaCliente(int idCliente);
    
    public void actualizaCliente(Cliente cliente);
    
    public Cliente buscaCliente(int idCliente);
    
    public void imprimeClientes();
    
}
