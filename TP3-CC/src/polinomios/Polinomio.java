package polinomios;

import java.io.IOException;

/**
 * 	Clase creada para analizar la complejidad compuracional que poseen 
 * 	los métodos para evaluar polinomios de grado N
 * 
 */
public class Polinomio {
	
	
	private final int grado;
	private final double [] coeficientes;
	private  Archivo pruebas;
	
	
	
	public Polinomio(String pathEntrada, String pathSalida) throws IOException{
		pruebas = new Archivo(pathEntrada, pathSalida);
		this.coeficientes = pruebas.cargarVector();
		this.grado = pruebas.getTamaño() - 1;
	}
	
	public Polinomio(int grado, double [] coheficientes){
		this.grado = grado;
		this.coeficientes = coheficientes;
	}
	
	/*
	public double evaluarMSucesivas(double x){
		return evaluarPow(x);
	}
	*/
	
	public double evaluarMSucesivas(double x){
		double resultado = 0;							// O(1)
		int gradoAuxiliar = grado;						// O(1)
		
		for(int i = 0; i < grado + 1; i ++)    		    // O(n)
		{
			double exponente = 1;						// O(1)
			for(int j = 0; j < gradoAuxiliar; j ++)		// O(n)
				exponente *= x;							// O(1)
			resultado += coeficientes[i] * exponente;   // O(1)
			gradoAuxiliar --;							// O(1)
		}
		
		return resultado;								// O(1)
	}
	
	 public double evaluarMejorada(double x) {
		 double xn= 1.0;											// O(1)
		 double resultado = 0;										// O(1)
		 for ( int termino = grado; termino >= 0; termino -- ) {    // O(n)
		      resultado += coeficientes[termino] * xn;				// O(1)
		      xn *= x;												// O(1)
		 }
		 return resultado;											// O(1)
	}
	
	public double evaluarRecursiva(double x){
		double resultado = 0;											// O(1)
		for (int i = 0; i < (grado+1); i++) 							// O(n)
			resultado+= this.coeficientes[i] * potencia(x,(grado-i));	// O(n)
		return resultado;
	}
	
	
	private double potencia(double x, int n){
		return n == 0 ? 1 : x * potencia(x,n-1);						// O(n)
	}
	
	public double evaluarRecursivaPar(final double x){
		double resultado = 0.0;												// O(1)
		for (int i = 0; i < grado + 1 ; i++) 								// O(n)
			resultado += this.coeficientes[i] * potenciaPar(x, grado - i ); // O(1)
		return resultado;
	}
	
	private double potenciaPar(double x, int n){
		if(n==0) return 1;
		return n % 2 != 0 ? x*potencia(x,n-1) : potenciaPar(x, n/2)* potenciaPar(x, n/2);
	}
	
	
	public double evaluarProgDinamica(double x){
		double [] resultadosParciales = new double[grado + 1];		// O(1)
		double resultado = 0;										// O(1)
		for(int i = 0; i <= grado; i ++)							// O(n)
			resultadosParciales[i] = potencia(x, grado - i);		// O(1)
		for(int i = 0; i <= grado; i ++)							// O(n)
			resultado += resultadosParciales[i] * coeficientes[i];	// O(1)
		return resultado;											// O(1)
	}
	
	public double evaluarHorner(double x){     
		double resultado = coeficientes[0]; 				// O(1)
		for(int i = 1; i < coeficientes.length; i ++)		// O(n)
			resultado = (resultado * x ) + coeficientes[i];	// O(1)
		return resultado;
    }
	
	
	public double evaluarPow(double x){									
		double resultado = 0;												// O(1)
		for (int i = 0; i < grado + 1; i++) 								// O(n)
			resultado += this.coeficientes[i] * Math.pow(x, grado - i);		// O(n)
		return resultado;													// O(1)
	}
	
	
	public double normaCoeficientes(){
		double norma = 0;
		for(int i = 0; i <= grado; i ++)
			norma += potencia(coeficientes[i], 2);
		return Math.sqrt(norma);
	}
}
