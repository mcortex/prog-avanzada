package polinomios;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Archivo {
	
	
	private Scanner entrada;
	private PrintWriter salida;
	private File archivoEntrada;
	private File archivoSalida;
	private int tama�o;
	
	public Archivo(String pathEntrada, String pathSalida) throws IOException{
		
		archivoEntrada = new File(pathEntrada);
		archivoSalida = new File(pathSalida);
		entrada = new Scanner(archivoEntrada);
		salida = new PrintWriter(archivoSalida);
	}
	
	public double [] cargarVector(){
		
		tama�o = entrada.nextInt();
		double [] arreglo = new double[tama�o];
		
		for(int i = 0; i < tama�o; i ++){
			arreglo[i] = entrada.nextDouble();
		}
		entrada.close();
		return arreglo;
	}
	
	public void escribirSalida(double resultado){
		salida.println("El resultado del polinomio es: " + resultado);
		salida.close();
		
	}
	
	public int getTama�o(){
		return tama�o;
	}
	
	
}
