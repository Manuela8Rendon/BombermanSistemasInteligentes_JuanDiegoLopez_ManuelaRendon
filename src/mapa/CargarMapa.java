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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargarMapa {

    public static Mapa cargar(String rutaArchivo) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        int alto = 0;
        int ancho = 0;
        Nodo[][] nodos = null;
        Nodo nodoInicio = null;
        Nodo nodoFin = null;

        while ((linea = lector.readLine()) != null) {
            String[] partesLinea = linea.split(",");
            if (nodos == null) {
                alto = 1;
                ancho = partesLinea.length;
                nodos = new Nodo[4][7];
            } else {
                alto++;
                if (partesLinea.length != ancho) {
                    lector.close();
                    throw new IOException("El archivo de mapa tiene filas de diferente longitud");
                }
            }
            for (int i = 0; i < ancho; i++) {
                String tipoNodoStr = partesLinea[i].trim();
                TipoNodo tipoNodo;
                switch (tipoNodoStr) {
                    case "C":
                        tipoNodo = TipoNodo.CAMINO;
                        break;
                    case "M":
                        tipoNodo = TipoNodo.METAL;
                        break;
                    case "R":
                        tipoNodo = TipoNodo.ROCA;
                        break;
                    case "F":
                        tipoNodo = TipoNodo.FIN;
                        nodoFin = new Nodo(alto - 1, i, tipoNodo);
                        break;
                    case "I":
                        tipoNodo = TipoNodo.INICIO;
                        nodoInicio = new Nodo(alto - 1, i, tipoNodo);
                        break;
                    default:
                        lector.close();
                        throw new IOException("El archivo de mapa tiene un tipo de nodo inválido: " + tipoNodoStr);
                }
                nodos[alto - 1][i] = new Nodo(alto - 1, i, tipoNodo);
            }
        }

        lector.close();

        if (nodoInicio == null) {
            throw new IOException("El archivo de mapa no tiene nodo de inicio");
        }

        if (nodoFin == null) {
            throw new IOException("El archivo de mapa no tiene nodo de fin");
        }

        return new Mapa(nodos, nodoInicio, nodoFin);
    }

}
