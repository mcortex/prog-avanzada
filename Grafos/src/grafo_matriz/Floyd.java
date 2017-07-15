package grafo_matriz;

public class Floyd {
	private int[][] matPesos;
	private int[][] matTraza; //precedencia
	private int[][] matCostoMin; //D
	private int cantNodos;
	
	public Floyd(GrafoMatriz grafo) {
		cantNodos = grafo.getNumVerts();
		matPesos = grafo.getMatAdy();
		matCostoMin = new int[cantNodos][cantNodos];
		matTraza = new int[cantNodos][cantNodos];
	}
	/**
	 * Aplicamos el algoritmo de Floyd:
	 */
	public void obtenerCaminosMinimos() {
		
		// La Matriz inicial de caminos es la de los pesos (adyacencia):
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = 0; j < this.cantNodos; j++) {
				this.matCostoMin[i][j] = this.matPesos[i][j];
				this.matTraza[i][j] = -1; // Inicializo la matriz de precedencia
			}
			
		}
		
		// Camino minimo de un nodo a si mismo es 0
		
		for (int i = 0; i < this.cantNodos; i++) {
			this.matCostoMin[i][i] = 0;
		}
		
		// Algoritmo de Floyd:
		
		for (int i = 0; i < matCostoMin.length; i++) {
			for (int j = 0; j < matCostoMin.length; j++) {
				for (int k = 0; k < matCostoMin.length; k++) {
					
					if ((this.matCostoMin[i][k] + this.matCostoMin[k][j]) < this.matCostoMin[i][j]) {
						this.matCostoMin[i][j] = this.matCostoMin[i][k] + this.matCostoMin[k][j];
						this.matTraza[i][j] = k;
					}
					
				}
			}
		}
	}
	
	public String toString() {
		String resultado="Matriz de costos minimos:\n";
		for(int i=0;i<this.cantNodos;i++){
			for(int j=0;j<this.cantNodos;j++){
				if (this.matCostoMin[i][j] != GrafoMatriz.INFINITO) {
					resultado+=this.matCostoMin[i][j]+" ";
				}
				else {
					resultado+="oo ";
				}
			}
			resultado += "\n";
		}
		resultado += "\nMatriz de traza (precedencia):\n";
		for(int i=0;i<this.cantNodos;i++){
			for(int j=0;j<this.cantNodos;j++){
				resultado+=this.matTraza[i][j]+" ";
			}
			resultado += "\n";
		}
		return resultado;
	}
	
//	public void recuperarCamino(int nodoOrigen, int nodoDestino) {
//		int anterior = this.matTraza[nodoOrigen][nodoDestino];
//		if(nodoDestino != -1) {
//			recuperarCamino(anterior,nodoDestino); // vuelve al ultimo del ultimo
//			System.out.println(" -> Nodo: " + nodoDestino);
//		}
//		else {
//			System.out.println("Nodo: " + nodoOrigen);
//		}
//		
//	}

}
