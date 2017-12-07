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
public abstract class Persona {
    private String nombre;
    private String domicilio;
    private int edad;

    protected Persona(String nombre, String domicilio, int edad) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", domicilio=" + domicilio + ", edad=" + edad;
    }

}
