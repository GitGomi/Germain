/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import servicios.InterfaceFuncional;

/**
 *
 * @author 171204 Grupo Salinas
 */
public class ImplementaInterfaceFuncional implements InterfaceFuncional{

    @Override
    public int m(int a, int b) {
        return a + b;
    }
    
}
