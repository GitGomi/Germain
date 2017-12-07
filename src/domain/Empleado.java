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
public class Empleado extends Persona {
    
    private int idEmpleado;
    private float salario;
    private static int nextID = 0;

    public Empleado(String nombre, String domicilio, int edad, float salario) {
        super(nombre, domicilio, edad);
        this.idEmpleado = nextID++;
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" + super.toString() + "idEmpleado=" + idEmpleado + ", salario=" + salario + '}';
    }
    
    
    
}
