/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import Heuristicas.Euclidiana;
import Heuristicas.Heuristica;
import Heuristicas.Manhattan;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mapa.Mapa;
import mapa.Nodo;

/**
 *
 * @author manue
 */
public class Problema {

    private Nodo inicio;
    private Nodo fin;
    private Mapa mapa;
    private Algoritmo algoritmo;
    private Heuristica heuristica;
    private List<Nodo> camino = new ArrayList<>();
    private List<Nodo> nodosExpandidos = new ArrayList<>();
    private List<Nodo> nodosArbol = new ArrayList<>();
    private Set<Nodo> nodosVisitados = new HashSet<>();
    private String tipoAlgoritmo;

    public Problema(Nodo inicio, Nodo fin, Mapa mapa, String tipoAlgoritmo, String tipoHeuristica) {
        this.inicio = inicio;
        this.fin = fin;
        this.mapa = mapa;

        switch (tipoHeuristica.toLowerCase()) {
            case "euclidiana":
                this.heuristica = new Euclidiana();
                break;
            case "manhattan":
                this.heuristica = new Manhattan();
                break;
            default:
                throw new IllegalArgumentException("Tipo de heurística inválido");
        }
        this.tipoAlgoritmo= tipoAlgoritmo;
    }
    public void iniciar(){
        switch (tipoAlgoritmo.toLowerCase()) {
            case "anchura":
                // this.algoritmo = new Anchura();
                break;
            case "profundidad":
                //  this.algoritmo = new Profundidad();
                break;
            case "costo uniforme":
                // this.algoritmo = new CostoUniforme();
                break;
            case "beam search":
                // this.algoritmo = new BeamSearch();
                break;
            case "hill climbing":
                // this.algoritmo = new HillClimbing();
                break;
            case "a estrella":
                // Crear una instancia del algoritmo A*
                this.algoritmo = new Aestrella();
                // Ejecutar el algoritmo para encontrar el camino óptimo
                algoritmo.buscar(this);
            
                break;
            default:
                throw new IllegalArgumentException("Tipo de algoritmo inválido");
        }
    }
    /**
     * @return the inicio
     */
    public Nodo getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fin
     */
    public Nodo getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    /**
     * @return the mapa
     */
    public Mapa getMapa() {
        return mapa;
    }

    /**
     * @param mapa the mapa to set
     */
    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    /**
     * @return the algoritmo
     */
    public Algoritmo getAlgoritmo() {
        return algoritmo;
    }

    /**
     * @param algoritmo the algoritmo to set
     */
    public void setAlgoritmo(Algoritmo algoritmo) {
        this.algoritmo = algoritmo;
    }

    /**
     * @return the heuristica
     */
    public Heuristica getHeuristica() {
        return heuristica;
    }

    /**
     * @param heuristica the heuristica to set
     */
    public void setHeuristica(Heuristica heuristica) {
        this.heuristica = heuristica;
    }

    public List<Nodo> getCamino() {
        return camino;
    }

    public List<Nodo> getNodosExpandidos() {
        return nodosExpandidos;
    }

    public List<Nodo> getNodosArbol() {
        return nodosArbol;
    }

    /**
     * @param camino the camino to set
     */
    public void setCamino(List<Nodo> camino) {
        this.camino = camino;
    }

    /**
     * @param nodosExpandidos the nodosExpandidos to set
     */
    public void setNodosExpandidos(List<Nodo> nodosExpandidos) {
        this.nodosExpandidos = nodosExpandidos;
    }

    /**
     * @param nodosArbol the nodosArbol to set
     */
    public void setNodosArbol(List<Nodo> nodosArbol) {
        this.nodosArbol = nodosArbol;
    }

    /**
     * @return the nodosVisitados
     */
    public Set<Nodo> getNodosVisitados() {
        return nodosVisitados;
    }

    /**
     * @param nodosVisitados the nodosVisitados to set
     */
    public void setNodosVisitados(Set<Nodo> nodosVisitados) {
        this.nodosVisitados = nodosVisitados;
    }
    

}
