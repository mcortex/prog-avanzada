package minotauro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoMatriz {
	public static final Integer INFINITO = 9999999;
	private int cantNodos;
	private int[] nodos;
	private int[][] matAdyacencia;

	public GrafoMatriz(){
				
	}
	
	public GrafoMatriz(int[][] matriz, int cantNodos) {
		this.cantNodos = cantNodos;
		
		this.matAdyacencia = matriz;
		for (int i = 0; i < cantNodos; i++) {
			this.nodos[i] = i+1;
		}
	}
	
	public GrafoMatriz(String path) {
		File archivo = new File(path);
		try {
			Scanner scan = new Scanner(archivo);
			
			this.cantNodos = scan.nextInt();
			this.matAdyacencia = new int[this.cantNodos][this.cantNodos];
			this.nodos = new int[cantNodos];
			
			for (int i = 0; i < cantNodos; i++) {
				this.nodos[i] = i+1;
				for (int j = 0; j < cantNodos; j++) {
					this.matAdyacencia[i][j] = scan.nextInt();
				}
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int[] getNodos() {
		return nodos;
	}

	public int[][] getMatAdyacencia() {
		return matAdyacencia;
	}
	
	
}
