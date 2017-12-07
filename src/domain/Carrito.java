/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import servicios.OperaArticulos;

/**
 *
 * @author 171204 Grupo Salinas
 */
public class Carrito implements OperaArticulos{
    private List<Articulo> articulos;
    
    public Carrito() {
        articulos = new ArrayList<>();
    }
    
    @Override
    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }
    
    @Override
    public void listaArticulos() {
        for (Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }
    
    @Override
    public void borraArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }
    
    @Override
    public Articulo buscarArticulo(String codigo){
        Articulo articuloTemp = new Articulo();
        for (Articulo articulo : articulos) {
            if(articulo.getCodigo().equals(codigo)){
                articuloTemp = articulo;
                break;
            }
        }

        return articuloTemp;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        return "Carrito{" + "articulos=" + articulos + '}';
    }

}
