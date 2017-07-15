package grafo_matriz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Kruskal {
	
	private int matrizAdyacencia[][];
	private Integer cantNodos;
//	private Integer cantidadAristas;
//	private Integer porcentajeAdyacencia;
	private Integer centinela[];
	private ArrayList<String> arbolRecubridorMinimo = new ArrayList<String>();	
	private Integer costo;
	private ArrayList<Integer> cantidadAdyacentes = new ArrayList<Integer>();
	
	public Kruskal() {
	}
	
	public Kruskal(GrafoMatriz grafo) {
		super();
		this.matrizAdyacencia = grafo.getMatAdy();
		this.cantNodos = grafo.getNumVerts();
		
		for(int x = 0; x < this.cantNodos; x++) {
			this.centinela[x] = x;
			this.cantidadAdyacentes.add(0);
		}
	}
	
	public void resolverKruskal() {
		int nodoA = 0;
		int nodoB = 0;
		int aristasRecorridas = 1;
		costo = 0;
		
		while(aristasRecorridas < cantNodos) {
			int minimo = GrafoMatriz.INFINITO;
			
			for(int x = 0; x < cantNodos; x++)
				for(int y = 0; y < cantNodos; y++) 
					if(matrizAdyacencia[x][y] < minimo && !centinela[x].equals(centinela[y])) {
						minimo = matrizAdyacencia[x][y];
						nodoA = x;
						nodoB = y;
					}
						
			if(!centinela[nodoA].equals(centinela[nodoB])) {
				int centinelaB = centinela[nodoB];
				arbolRecubridorMinimo.add(nodoA + " " + nodoB);// + " " + minimo);
				costo += minimo;
				cantidadAdyacentes.set(nodoA, cantidadAdyacentes.get(nodoA) + 1);
				cantidadAdyacentes.set(nodoB, cantidadAdyacentes.get(nodoB) + 1);
				for(int x = 0; x < cantNodos; x++)
					if(centinela[x].equals(centinelaB))
						centinela[x] = centinela[nodoA];
				
				aristasRecorridas++;
			}
		}
	}
	
	public String toString() {
		String resultado="Arbol recubridor de costos minimos:\n";
		
		Iterator<String> it = this.arbolRecubridorMinimo.iterator();
		
		while(it.hasNext()){
			
				resultado+=it.next()+" ";
			
			
		}
		resultado += "\n";
		return resultado;
	}

}
