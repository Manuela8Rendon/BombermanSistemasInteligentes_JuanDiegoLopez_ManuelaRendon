/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import Heuristicas.Euclidiana;
import Heuristicas.Heuristica;
import Heuristicas.Manhattan;
import java.util.ArrayList;
import java.util.List;
import mapa.Nodo;

/**
 * @author Manuela Rendón
 */
public class Nodo {

    private String name;
    private int coorX;
    private int coorY;
    private double costoAcumulado;
    private double heuristica;
    private List<Nodo> vecinos;
    private Nodo padre;
    private boolean visitado;
    private TipoNodo tipoNodo;
    private int pesoCaminoAristas;

    public Nodo(int coorX, int coorY, TipoNodo tipoNodo) {

        this.coorX = coorX;
        this.coorY = coorY;
        this.tipoNodo = tipoNodo;
        this.costoAcumulado = 0;
        this.heuristica = 0;
        this.vecinos = new ArrayList<>();
        this.padre = null;
        this.visitado = false;
        this.pesoCaminoAristas=0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the coorX
     */
    public int getCoorX() {
        return coorX;
    }

    /**
     * @param coorX the coorX to set
     */
    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    /**
     * @return the coorY
     */
    public int getCoorY() {
        return coorY;
    }

    /**
     * @param coorY the coorY to set
     */
    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }

    /**
     * @return the costoAcumulado
     */
    public double getCostoAcumulado() {
        return costoAcumulado;
    }

    /**
     * @param costoAcumulado the costoAcumulado to set
     */
    public void setCostoAcumulado(double costoAcumulado) {
        this.costoAcumulado = costoAcumulado;
    }

    /**
     * @return the heuristica
     */
    public double getHeuristica() {
        return heuristica;
    }

    /**
     * @param heuristica the heuristica to set
     */
    public void setHeuristica(double heuristica) {
        this.heuristica = heuristica;
    }

    /**
     * @return the vecinos
     */
    public List<Nodo> getVecinos(Mapa mapa, Heuristica heuristica) {
        int x = this.getCoorX();
        int y = this.getCoorY();

        if (heuristica instanceof Manhattan) {
            // Agregar vecinos arriba, abajo, y a los lados
            if (mapa.esValido(x, y - 1)) {
                this.vecinos.add(mapa.getNodo(x, y - 1));
            }
            if (mapa.esValido(x - 1, y)) {
                this.vecinos.add(mapa.getNodo(x - 1, y));
            }
            if (mapa.esValido(x, y + 1)) {
                this.vecinos.add(mapa.getNodo(x, y + 1));
            }
            if (mapa.esValido(x + 1, y)) {
                this.vecinos.add(mapa.getNodo(x + 1, y));
            }
        } else if (heuristica instanceof Euclidiana) {
            // Agregar vecinos arriba, abajo, a los lados, y en diagonal
            if (mapa.esValido(x - 1, y - 1)) {
                this.vecinos.add(mapa.getNodo(x - 1, y - 1));
            }
            if (mapa.esValido(x - 1, y)) {
                this.vecinos.add(mapa.getNodo(x - 1, y));
            }
            if (mapa.esValido(x - 1, y + 1)) {
                this.vecinos.add(mapa.getNodo(x - 1, y + 1));
            }
            if (mapa.esValido(x, y - 1)) {
                this.vecinos.add(mapa.getNodo(x, y - 1));
            }
            if (mapa.esValido(x, y + 1)) {
                this.vecinos.add(mapa.getNodo(x, y + 1));
            }
            if (mapa.esValido(x + 1, y - 1)) {
                this.vecinos.add(mapa.getNodo(x + 1, y - 1));
            }
            if (mapa.esValido(x + 1, y)) {
                this.vecinos.add(mapa.getNodo(x + 1, y));
            }
            if (mapa.esValido(x + 1, y + 1)) {
                this.vecinos.add(mapa.getNodo(x + 1, y + 1));
            }
        }

        return this.vecinos;
    }

    public boolean esIgual(Nodo n) {
        if (this.coorX == n.getCoorX() && this.getCoorY() == n.coorY) {
            return true;
        }
        return false;
    }

    /**
     * @param vecinos the vecinos to set
     */
    public void setVecinos(List<Nodo> vecinos) {
        this.vecinos = vecinos;
    }

    /**
     * @return the padre
     */
    public Nodo getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    /**
     * @return the visitado
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     * @param visitado the visitado to set
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public TipoNodo getTipoNodo() {
        return tipoNodo;
    }

    public void setTipoNodo(TipoNodo tipoNodo) {
        this.tipoNodo = tipoNodo;
    }

    /**
     * @return the pesoCaminoAristas
     */
    public int getPesoCaminoAristas() {
        return pesoCaminoAristas;
    }

    /**
     * @param pesoCaminoAristas the pesoCaminoAristas to set
     */
    public void setPesoCaminoAristas(int pesoCaminoAristas) {
        this.pesoCaminoAristas = pesoCaminoAristas;
    }

}
