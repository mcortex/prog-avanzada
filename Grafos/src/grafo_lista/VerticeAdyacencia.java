package grafo_lista;

import java.util.LinkedList;

import grafo_matriz.Vertice;

/**
 * Cada elemento de la tabla directorio es un vertice del grafo que guarda en el vertice su numero
 * y su lista de adyacencia con los arcos de nodos adyacentes
 * 
 */

public class VerticeAdyacencia {
	private String nombre;
	private int numVertice;
	private LinkedList<Arco> listaAdy;
	
	public VerticeAdyacencia(String nombreNodo) {
		this.nombre = nombreNodo;
		this.numVertice = -1;
		this.listaAdy = new LinkedList<Arco>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumVertice() {
		return numVertice;
	}
	
	public void setNumVertice(int num) {
		this.numVertice = num;
	}

	public LinkedList<Arco> getListaAdy() {
		return listaAdy;
	}
	
	public String toString () {
		return this.nombre +" ("+ this.numVertice +")"; 
	}
	
	public boolean equals(VerticeAdyacencia v) {
		return nombre.equals(v.nombre);
	}
	
}
