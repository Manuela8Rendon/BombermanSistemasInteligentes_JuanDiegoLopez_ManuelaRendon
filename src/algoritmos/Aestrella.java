/*
 
 */
package algoritmos;

/**
 *
 * @author Manuela Rendón Rendón
 */
import Heuristicas.Heuristica;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import mapa.Mapa;
import mapa.Nodo;

public class Aestrella implements Algoritmo {

    private Set<Nodo> nodosVisitados = new HashSet<>();
    private PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingDouble(nodo -> nodo.getCostoAcumulado() + nodo.getHeuristica()));
    private List<Nodo> camino = new ArrayList<>();
    private List<Nodo> nodosExpandidos = new ArrayList<>();
    private List<Nodo> nodosArbol = new ArrayList<>();

    public Aestrella() {
    }

    @Override
    public void buscar(Problema problema) {
        Nodo nodoInicial = problema.getInicio();
        Nodo nodoFinal = problema.getFin();
        Mapa mapa = problema.getMapa();
        Heuristica heuristica = problema.getHeuristica();


        
        this.colaPrioridad.add(nodoInicial);
        while (!this.colaPrioridad.isEmpty()) {
            Nodo nodoActual = this.colaPrioridad.poll();
            if (nodoActual.esIgual(nodoFinal)) {
                generarCamino(nodoActual);
                break;
            }
            nodoActual.setVisitado(true);
            this.getNodosVisitados().add(nodoActual);

            for (Nodo vecino : nodoActual.getVecinos(problema.getMapa(), problema.getHeuristica())) {
                // ese 1 se va a reemplazar por el costo de la arista en caso de que el profesor pida arista
                vecino.setHeuristica(heuristica.calcular(vecino, nodoFinal));
                double costoNuevo =  nodoActual.getPesoCaminoAristas()+ 1 +vecino.getHeuristica() ;

                if (!this.estaLista(vecino, this.nodosVisitados) && !this.estaLista2(vecino,this.colaPrioridad)) {
                    vecino.setCostoAcumulado(costoNuevo);
                    vecino.setHeuristica(heuristica.calcular(vecino, nodoFinal));
                    vecino.setPadre(nodoActual);
                    //esto es solo porque aun no hay aristas con pesos entonces las tomo como 1
                    vecino.setPesoCaminoAristas(vecino.getPesoCaminoAristas()+1);
                    this.colaPrioridad.add(vecino);
                    this.nodosArbol.add(vecino);
                } else if (costoNuevo < vecino.getCostoAcumulado()) {
                    this.colaPrioridad.remove(vecino);
                    vecino.setCostoAcumulado(costoNuevo);
                    vecino.setPadre(nodoActual);
                    this.colaPrioridad.add(vecino);
                }
            }
            this.nodosExpandidos.add(nodoActual);
        }

        problema.setCamino(this.camino);
        problema.setNodosArbol(this.nodosArbol);
        problema.setNodosExpandidos(this.nodosExpandidos);
        problema.setNodosVisitados(nodosVisitados);
    }

    private void generarCamino(Nodo nodo) {
        Nodo nodoActual = nodo;
        while (nodoActual != null) {
            camino.add(nodoActual);
            nodoActual = nodoActual.getPadre();
        }
    }
    
    public boolean estaLista(Nodo buscar, Set<Nodo> lista){
        for (Nodo nodo: lista){
            if (buscar.esIgual(nodo)){
              return true;  
            }
        }
        return false;
    }
    
    public boolean estaLista2(Nodo buscar, PriorityQueue<Nodo> lista){
        for (Nodo nodo: lista){
            if (buscar.esIgual(nodo)){
              return true;  
            }
        }
        return false;
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
