package grafo_matriz;

/**
 * Clase que aplica el algoritmo de Dijkstra para obtener el vector de costos minimos desde un determinado nodo
 * a todos los demas en un grafo dirigido.
 *
 */
public class Dijkstra {
	private int[][] matPesos;
	private int[] vecPrecedencia; //vector de precedencia (ultimo nodo visitado)
	private int[] vecCostoMin; // vector de costo minimo D
	private boolean[] vecProcesados; // vector de procesados F
	private int nodoOrigen, cantNodos; // s,n
	
	public Dijkstra(GrafoMatriz grafo, String origen) {
		nodoOrigen = grafo.obtenerNumVertice(origen);
		cantNodos = grafo.getNumVerts();
		matPesos = grafo.getMatAdy();
		vecPrecedencia = new int[cantNodos];
		vecCostoMin = new int[cantNodos];
		vecProcesados = new boolean[cantNodos];
		
//		System.out.println("Nodo Origen: " + nodoOrigen);
//		System.out.println("Cant Nodos: " + cantNodos);
	}
	/**
	 * Aplico la formula de Dikjstra: min(D[w], D[v]+C[v,w])
	 */
	public void caminoMinimo() {
		
		// VALORES INICIALES
		for (int i = 0; i < this.cantNodos; i++) {
			this.vecProcesados[i] = false;
			this.vecCostoMin[i] = this.matPesos[nodoOrigen][i];
			this.vecPrecedencia[i] = nodoOrigen; // para ir del origen se pasa por el origen
		}
		
		// Agrego al nodo origen al conjunto F
		this.vecProcesados[nodoOrigen] = true;
		this.vecCostoMin[nodoOrigen] = 0;
		
		for (int i = 0; i < this.cantNodos; i++) {
			// Selecciono vertice no marcado de menor distancia:
			int nodoV = minimo();
			this.vecProcesados[nodoV] = true;
//			System.out.println("proceso nodoV: " + nodoV);
			
			/*
			 *  Actualizo distancia entre vertices no marcados:
			 *  
			 *  - El nodo destino no debe estar procesado.
			 *  - Aplico la formula de Dikjstra: min (D[w], D[v]+C[v,w])
			 */
			for (int nodoW = 0; nodoW < this.cantNodos; nodoW++) {
				if(!this.vecProcesados[nodoW]) {
					if((this.vecCostoMin[nodoV] + this.matPesos[nodoV][nodoW]) < this.vecCostoMin[nodoW]) {
						this.vecCostoMin[nodoW] = this.vecCostoMin[nodoV] + this.matPesos[nodoV][nodoW];
						this.vecPrecedencia[nodoW] = nodoV;
					}
				}
			}
			
		}
	}

	private int minimo() {
		int pesoMin = GrafoMatriz.INFINITO;
		int nodoMin = 1;
		for (int j=1; j<this.cantNodos;j++) {
			// Selecciono el que no fue procesado cuya distancia es la minima
			if (!this.vecProcesados[j] && (this.vecCostoMin[j] <= pesoMin)) {
				pesoMin = this.vecCostoMin[j];
				nodoMin = j;
			}
		}
		
		return nodoMin;
	}
	
	public int[] getVecCostoMin() {
		return this.vecCostoMin;
	}
	
	public int[] getVecPrecedencia() {
		return this.vecPrecedencia;
	}
	
	public void recuperarCamino(int nodoDestino) {
		int anterior = this.getVecPrecedencia()[nodoDestino];
		if(nodoDestino != this.nodoOrigen) {
			recuperarCamino(anterior); // vuelve al ultimo del ultimo
			System.out.println(" -> Nodo: " + nodoDestino);
		}
		else {
			System.out.println("Nodo: " + this.nodoOrigen);
		}
	}
}
