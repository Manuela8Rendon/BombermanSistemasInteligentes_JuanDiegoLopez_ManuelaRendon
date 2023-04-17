/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heuristicas;

import mapa.Nodo;

/**
 *
 * @author Manuela Rendón Rendón
 */
public class Manhattan implements Heuristica {
    private String nombre = "Manhattan";
    
    @Override
    public double calcular(Nodo actual, Nodo meta) {
        double distanciaX = meta.getCoorX()- actual.getCoorX();
        double distanciaY = meta.getCoorY() - actual.getCoorY();
        return distanciaX + distanciaY;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
