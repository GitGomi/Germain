/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import domain.Articulo;

/**
 *
 * @author 171204 Grupo Salinas
 */
public interface OperaArticulos {
    
    public void agregarArticulo(Articulo articulo);
    
    public void listaArticulos();
    
    public void borraArticulo(Articulo articulo);
    
    public Articulo buscarArticulo(String codigo);
}
