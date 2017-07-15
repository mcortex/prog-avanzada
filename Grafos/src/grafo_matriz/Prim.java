package grafo_matriz;

public class Prim {
	private int[][] matPesos;
	private int cantNodos;
	
	public Prim(GrafoMatriz grafo) {
		this.matPesos = grafo.getMatAdy();
		this.cantNodos = grafo.getNumVerts();
	}
	
	public int arbolExpansionCosteMinimo() {
		int longitudMin, menor;
		int nodoZ;
		int[] coste = new int[this.cantNodos];
		int[] masCerca = new int[this.cantNodos];
		boolean[] W = new boolean[this.cantNodos]; // vector de procesados
		
		for (int i = 0; i < this.cantNodos; i++) {
			W[i] = false; // conjunto de procesados = vacio
		}
		
		longitudMin = 0;
		
		W[0] = true; //Partimos del vertice 0
		
		//Inicialmente coste[i] es la arista (0,i)
		for (int i = 0; i < this.cantNodos; i++) {
			coste[i] = this.matPesos[0][i];
			masCerca[i] = 0;
		}
		
		for (int i = 0; i < this.cantNodos; i++) {
			// Busca el vertice z de V-W mas cercano, de menor long de arista, a algun vertice de W
			menor = coste[1];
			nodoZ = 1;
			
			for (int j = 0; j < this.cantNodos; j++ ) {
				if (coste[j] < menor) {
					menor = coste[j];
					nodoZ = j;
				}	
			}
			longitudMin += menor;
			
			// se escribe el arco incorporado al arbol de expansion:
			System.out.println("V" + masCerca[nodoZ] + " -> " + "V" + nodoZ);
			
			// Añado z al conjunto W:
			W[nodoZ] = true;
			coste[nodoZ] = GrafoMatriz.INFINITO;
			
			// debido a la incorporacion de < se ajusta coste[] para el resto de los vertices
			for (int j = 0; j < this.cantNodos; j++ ) {
				if ((this.matPesos[nodoZ][j] < coste[j]) && !W[j]) {
					coste[j] = this.matPesos[nodoZ][j];
					masCerca[j] = nodoZ;
				}
			}
			
			
		}
		
		return longitudMin;
	}

}
