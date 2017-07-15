package minotauro;

import java.util.ArrayList;

public class Minotauro {
	private int cantNodos;
	private int[][] matrizAdy;
	private int[] cantAdy;
//	int[] arbolCostoMinimo;
	private ArrayList<String> arbol;
	
	public Minotauro(String path) {
		GrafoMatriz grafo = new GrafoMatriz(path);
		this.matrizAdy = grafo.getMatAdyacencia();
		this.cantNodos = grafo.getCantNodos();
		this.cantAdy = new int[this.cantNodos];
		this.arbol = new ArrayList<String>();
	}
	
	
	public int resolver(){
		
		boolean[] conjSolucion = new boolean[cantNodos];
		boolean bandera = false;
		int costoMin, fila, columna;
		int costoTotal = 0;
		
		// Pongo el primer nodo en el conjunto solucion
		conjSolucion[0] = true;
		
		while(!bandera) {
			
			bandera = true;
			costoMin = GrafoMatriz.INFINITO;
			fila = 0;
			columna = 0;
			
			for (int i = 0; i < cantNodos; i++)
				for (int j = i+1; j < cantNodos; j++)
					if ((conjSolucion[i] && !conjSolucion[j]) || (conjSolucion[j] && !conjSolucion[i]))
						if(matrizAdy[i][j] != GrafoMatriz.INFINITO)
							if(matrizAdy[i][j] < costoMin) {							
								costoMin = matrizAdy[i][j];
								bandera = false;
								fila = i;
								columna = j;
							}
			
			
			if (!bandera){
				System.out.println((fila+1) + " " + (columna+1) + " " + costoMin);
				arbol.add(fila + " " + columna + " " + costoMin);
				cantAdy[fila]++;
				cantAdy[columna]++;
				costoTotal += costoMin;
				if (!conjSolucion[columna])
					conjSolucion[columna] = true;
				else{
					conjSolucion[fila] = true;
				}
			}
		}
		
		for (int i = 0; i < cantNodos; i++)
			if (!conjSolucion[i])
				return 0;

		return costoTotal;	
		
	}
	
	public static void main(String[] args) {
		Minotauro minotauro = new Minotauro("LotePrueba/in/00_enunciado.in");
		minotauro.resolver();
	}

}
