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
public class Cliente extends Persona{
    private int idCliente;
    private String rfc;
    private String email;
    private static int nextID = 0;

    public Cliente(String nombre, String domicilio, int edad, String rfc, String email) {
        super(nombre, domicilio, edad);
        this.idCliente = nextID++;
        this.rfc = rfc;
        this.email = email;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() + "idCliente=" + idCliente + ", rfc=" + rfc + ", email=" + email + '}';
    }

}
