package mapa;

public class Mapa {

    private Nodo[][] nodos;
    private Nodo nodoInicio;
    private Nodo nodoFin;
    private int alto;
    private int ancho;

    public Mapa(Nodo[][] nodos, Nodo nodoInicio, Nodo nodoFin) {
        this.nodos = nodos;
        this.nodoInicio = nodoInicio;
        this.nodoFin = nodoFin;
        this.alto = nodos.length;
        this.ancho = nodos[0].length;
    }

    public Nodo[][] getNodos() {
        return nodos;
    }

    public Nodo getNodoInicio() {
        return nodoInicio;
    }

    public Nodo getNodoFin() {
        return nodoFin;
    }

    public boolean esValido(int fila, int columna) {
        // Verificar si las coordenadas están dentro del rango del mapa
        if (fila < 0 || fila>=this.alto || columna < 0 || columna >= this.ancho) {
            return false;
        }
        // Verificar si el nodo existe en el mapa
        if (this.nodos[fila][columna] == null) {
            return false;
        }
        // Verificar si el tipo del nodo es válido, por ahora roca va a ser valido sin evaluar si hay poder o no
        if(this.nodos[fila][columna].getTipoNodo() == TipoNodo.METAL){
            return false;
        }else{
            return true;
        }
       
    }

    Nodo getNodo(int x, int y) {
        return nodos[x][y];
    }
}