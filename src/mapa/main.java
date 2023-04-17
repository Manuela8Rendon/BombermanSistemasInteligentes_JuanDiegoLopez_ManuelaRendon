/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import Heuristicas.Euclidiana;
import Heuristicas.Heuristica;
import algoritmos.Problema;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author manue
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // Ruta del archivo que contiene el mapa
        String rutaArchivo = "C:\\Users\\manue\\Desktop\\mapa.txt";

        // Cargar el mapa
        Mapa mapa = CargarMapa.cargar(rutaArchivo);
        Nodo[][] matrizMapa = mapa.getNodos();

        // Imprimir información del mapa
        for (int i = 0; i < matrizMapa.length; i++) {
            for (int j = 0; j < matrizMapa[i].length; j++) {
                if (matrizMapa[i][j] == null) {
                    // Si el valor es cero, pinta el espacio como vacío
                    System.out.print(" ");
                } else if (matrizMapa[i][j].getTipoNodo() == TipoNodo.METAL) {
                    // Si el valor es uno, pinta el espacio como pared
                    System.out.print("M");
                } else if (matrizMapa[i][j].getTipoNodo() == TipoNodo.INICIO) {
                    // Si el valor es uno, pinta el espacio como pared
                    System.out.print("I");
                } else if (matrizMapa[i][j].getTipoNodo() == TipoNodo.FIN) {
                    // Si el valor es uno, pinta el espacio como pared
                    System.out.print("F");
                } else {
                    // Si el valor es distinto de cero o uno, pinta el espacio como otro tipo de obstáculo
                    System.out.print("C");
                }
            }
            // Salto de línea al final de cada fila
            System.out.println();
        }

        System.out.println("Posición de inicio: " + mapa.getNodoInicio().getTipoNodo().getSimbolo());
        System.out.println("Posición de fin: " + mapa.getNodoFin().getTipoNodo().getSimbolo());

        // Crear el problema
        Problema problema = new Problema(mapa.getNodoInicio(), mapa.getNodoFin(),mapa,"a estrella", "Euclidiana");
        problema.iniciar();

       

        // Obtener el camino óptimo
        List<Nodo> camino = problema.getCamino();

        // Imprimir el camino
        System.out.println("Camino óptimo: "+camino.size());
        for (Nodo nodo : camino) {
            System.out.println(nodo.getCoorX()+" "+nodo.getCoorY());
        }
        // Obtener el camino óptimo
        List<Nodo> camino1 = problema.getNodosExpandidos();

        // Imprimir el camino
        System.out.println("Nodos expandidos: "+camino1.size());
        for (Nodo nodo : camino1) {
            System.out.println(nodo.getCoorX()+" "+nodo.getCoorY());
        }
        
        // Obtener el camino óptimo
        Set<Nodo> camino2 = problema.getNodosVisitados();

        // Imprimir el camino
        System.out.println("Nodos Visitados: "+camino2.size());
        for (Nodo nodo : camino2) {
            System.out.println(nodo.getCoorX()+" "+nodo.getCoorY());
        }

    }

}
