package polinomios;

import java.io.IOException;

public class Principal {
	public static void main(String [] args) throws IOException{
		
		Polinomio polinomio1 = new Polinomio("Entradas/prueba-grado29.txt", "Salidas/prueba-grado29.txt");
		long nanoSegIni = System.nanoTime();
		System.out.println(polinomio1.evaluarMejorada(5));
		long nanoSegFin = System.nanoTime();
		System.out.println("Tiempo en nanoSeg = " + (nanoSegFin - nanoSegIni));
	}
}
