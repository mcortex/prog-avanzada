package juego;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Juego extends EjercicioOIA {
	private char[][] tablero;
	private String[] palabras;
	private int dimensionTablero;
	private int cantidadPalabras;
	
	public Juego(String entrada,String salida){
		
		super(new File(entrada),new File(salida));
		
		try {
			Scanner scan = new Scanner(this.entrada);
			scan.useLocale(Locale.ENGLISH);
			
			this.dimensionTablero = scan.nextInt();
			this.cantidadPalabras = scan.nextInt();
			
			this.tablero = new char[this.dimensionTablero][this.dimensionTablero];

			for (int i=0; i<this.dimensionTablero; i++) {
				this.tablero[i] = scan.next().toCharArray();
			}
			
			palabras = new String[this.cantidadPalabras];
			for (int i=0; i<this.cantidadPalabras; i++) {
				palabras[i] = scan.next();
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public String[] getPalabras() {
		return palabras;
	}



	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}



	public char[][] getTablero() {
		return tablero;
	}



	public int getDimensionTablero() {
		return dimensionTablero;
	}



	public int getCantidadPalabras() {
		return cantidadPalabras;
	}


	public char[][] sentidoNorte() {
		char[][] aux = new char[this.getDimensionTablero()][this.getDimensionTablero()];
		for (int i=0; i<this.getDimensionTablero(); i++) { // col
			int k=0;
			for (int j=this.getDimensionTablero()-1; j>=0; j=j-1) { // fil
				aux[i][k] = this.tablero[j][i];
				k++;
			}
		}
		return aux;
	}
	
	public char[][] sentidoOeste() {
		return this.getTablero();
	}
	
	public char[][] sentidoSur() {
		char[][] aux = new char[this.getDimensionTablero()][this.getDimensionTablero()];
		for (int i=0; i < this.getDimensionTablero(); i++) {
			for (int j=0; j < this.getDimensionTablero(); j++) {
				aux[i][j] = this.getTablero()[j][i];
			}
		}
		return aux;
	}
	
	public char[][] sentidoEste() {
		char[][] aux = new char[this.getDimensionTablero()][this.getDimensionTablero()];
		for (int i=0; i < this.getDimensionTablero(); i++) {
			int k=0;
			for (int j=this.getDimensionTablero()-1; j>=0; j--) {
				aux[i][k] = this.getTablero()[i][j];
				k++;
			}
		}
		return aux;
	}
	
	
	public boolean buscarPalabra(String palabra,char[][] tableroOrientado) {
		boolean encontro = false;
		for (int i=0; i<this.getDimensionTablero() && !encontro; i++) {  //O(n)
			String fila = String.copyValueOf(tableroOrientado[i]);
				if (fila.contains(palabra)) {
					encontro = true;
				}
		}
		
	return encontro;
	}
	
	public void resolver(){
		
		try {
			FileWriter writer = new FileWriter(this.salida);
			PrintWriter printer = new PrintWriter(writer);
			int numPalabra;
			for (int i=0; i<this.getPalabras().length; i++){
				numPalabra=i+1;
				if(this.buscarPalabra(this.getPalabras()[i], this.sentidoNorte())) {
					printer.println(numPalabra+" N");
					//System.out.println(numPalabra+" N");
				}
				else if(this.buscarPalabra(this.getPalabras()[i], this.sentidoOeste())) {
					printer.println(numPalabra+" O");
					//System.out.println(numPalabra+" O");
				}
				else if(this.buscarPalabra(this.getPalabras()[i], this.sentidoSur())) {
					printer.println(numPalabra+" S");
					//System.out.println(numPalabra+" S");
				}
				else if(this.buscarPalabra(this.getPalabras()[i], this.sentidoEste())) {
					printer.println(numPalabra+" E");
					//System.out.println(numPalabra+" E");
				}
				else {
					//System.out.println("No Hay");
				}
			}
			printer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}