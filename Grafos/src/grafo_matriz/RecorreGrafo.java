package grafo_matriz;

import java.util.LinkedList;

public class RecorreGrafo {
	
	private static final int CLAVE = GrafoMatriz.INFINITO;

	public static int[] recorrerEnAnchura(GrafoMatriz grafo, String nodoOrigen) throws Exception {
		int nodoV, nodoW;
		int[] marcados = new int[grafo.getNumVerts()];;
		
		// Busco el valor del nodo origen.
		nodoV = grafo.obtenerNumVertice(nodoOrigen);
		if (nodoV < 0) {
			throw new Exception("El nodo origen no existe.");
		}
		
		// Inicializo la cola de recorrido:
		LinkedList<Integer> cola = new LinkedList<Integer>();
		
		// Inicializo los vertices como no marcados:
		for (int i=0;i<grafo.getNumVerts();i++) {
			marcados[i] = CLAVE;
		}
		
		// Marco Nodo Origen:
		marcados[nodoV] = 0;
		
		cola.add(nodoV);
		
		while(!cola.isEmpty()) {
			//Integer cw;
			//cw = (Integer) cola.pollFirst();
			//nodoW = cw.intValue();
			
			nodoW = cola.pollFirst();
			System.out.println("Vertice: " + grafo.getVertices()[nodoW] + " visitado.");
			
			// Inserta en la cola los adyacentes de w no marcados:
			for (int nodoU = 0; nodoU<grafo.getNumVerts();nodoU++) {
				if ((grafo.getMatAdy()[nodoW][nodoU] >= 1 && grafo.getMatAdy()[nodoW][nodoU] < GrafoMatriz.INFINITO) && (marcados[nodoU] == CLAVE)) {
					marcados[nodoU] = marcados[nodoW] + 1;
					cola.add(nodoU);
					System.out.println("Peso arco nodo " + grafo.getVertices()[nodoU] +": "+ grafo.getMatAdy()[nodoW][nodoU]);
				}
				
			}
			
		}
		
		return marcados;
	}
	
	/**
	 * Algoritmo de Warshall:
	 * <p>
	 * Calcula la matriz de caminos P, tal que existe una arista directa entre (i,j), 
	 * o existe un camino de aristas intermedias (i,k) y (k,j)
	 * <p>
	 * Pk[i,j] = Pk-1[i,j] || (Pk-1[i,k] && Pk-1[k,j])
	 * <p>
	 * Cada Nodo de la matriz camino se puede validar usando un recorrido por anchura
	 * @see recorrerEnAnchura
	 * @param grafo
	 * @return
	 */
	
	public static int[][] matrizCaminosWarshall(GrafoMatriz grafo) {
		int cantVert = grafo.getNumVerts();
		int [][] matrizCaminos = new int[cantVert][cantVert];
		// Se obtiene la matriz inicial (adyacencia):
		for (int i=0; i < cantVert; i++) {
			for (int j=0; j < cantVert; j++) {
				matrizCaminos[i][j] = grafo.getMatAdy()[i][j] >= 1 && grafo.getMatAdy()[i][j] < GrafoMatriz.INFINITO  ? 1 : 0 ;
			}
		}
		// WARSHALL O(n^3)
		for (int k=0; k < cantVert; k++) {
			for (int i=0; i < cantVert; i++) {
				for (int j=0; j < cantVert; j++) {
					matrizCaminos[i][j] = Math.min(matrizCaminos[i][j] + matrizCaminos[i][k] * matrizCaminos[k][j], 1);
				}
			}
		}
		
		String resultado="";
		for(int i=0;i<cantVert;i++){
			for(int j=0;j<cantVert;j++){
				resultado+=matrizCaminos[i][j]+" ";
			}
			resultado += "\n";
		}
		
		System.out.println("\nWarshall:\n" + resultado);
		
		return matrizCaminos;
	}

}
