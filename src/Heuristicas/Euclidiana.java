/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heuristicas;

import mapa.Nodo;

/**
 *
 * @author manue
 */
public class Euclidiana implements Heuristica {
    private String nombre = "Euclidiana";
    /**
     * Calcula la distancia euclidiana entre dos nodos.
     *
     * @param actual Nodo actual.
     * @param meta Nodo destino.
     * @return La distancia euclidiana entre los dos nodos.
     */
    
    @Override
    public double calcular(Nodo actual, Nodo meta) {
        double distanciaX = meta.getCoorX()- actual.getCoorX();
        double distanciaY = meta.getCoorY() - actual.getCoorY();
        double distancia = Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
        return distancia;
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

