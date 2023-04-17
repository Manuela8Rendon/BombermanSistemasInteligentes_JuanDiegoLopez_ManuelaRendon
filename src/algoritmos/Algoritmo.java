/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import Heuristicas.Heuristica;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import mapa.Mapa;
import mapa.Nodo;

/**
 *
 * @author Manuela Rendón Rendón
 */

public interface Algoritmo {
    public void buscar(Problema problema);
}
