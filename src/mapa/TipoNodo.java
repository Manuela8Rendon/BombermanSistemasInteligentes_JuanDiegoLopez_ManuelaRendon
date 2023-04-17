/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

/**
 *
 * @author Manuela Rendón Rendón
 */
public enum TipoNodo {
    INICIO("I"), 
    CAMINO("C"), 
    METAL("M"), 
    ROCA("R"),
    FIN("F");
    
    private String simbolo;

    TipoNodo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
