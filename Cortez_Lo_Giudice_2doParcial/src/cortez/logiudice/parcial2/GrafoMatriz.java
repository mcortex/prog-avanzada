package cortez.logiudice.parcial2;

public class GrafoMatriz {
	
	public static final int INFINITO = 999999;
	
	private int cantNodos;
	private int[][] matAdyacencia;
	
	public GrafoMatriz(){
		
	}
	
	public GrafoMatriz(int cantNodos, int[][] matAdy) {
		this.cantNodos = cantNodos;
		this.matAdyacencia = matAdy;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int[][] getMatAdyacencia() {
		return matAdyacencia;
	}
	

}
