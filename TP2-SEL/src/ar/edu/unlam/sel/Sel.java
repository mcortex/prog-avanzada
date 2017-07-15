package ar.edu.unlam.sel;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Sel {

	private MatrizMath matrizCoeficientes;
	private VectorMath vectorIncognita;
	private VectorMath vectorTerminosIndependientes;
	private double errorSel;
	
	public Sel(){
		
	}
	
	public Sel(MatrizMath matrizCoef, VectorMath vectorTermIndep){
		this.matrizCoeficientes = matrizCoef.clone();
		this.vectorTerminosIndependientes = vectorTermIndep.clone();
		this.vectorIncognita = new VectorMath(this.vectorIncognita.getDimension());
	}
	
	public Sel(String archIn) {
		
		File archivo = new File(archIn);
		
		try {
			Scanner scan = new Scanner(archivo);
			scan.useLocale(Locale.ENGLISH);
			
			int orden = scan.nextInt();
			this.matrizCoeficientes=new MatrizMath(orden,orden);
			this.vectorTerminosIndependientes = new VectorMath(orden);
			this.vectorIncognita = new VectorMath(orden);
			this.errorSel=0;
			
			int n = orden * orden;
			
			for (int i = 0; i < n; i++)
				this.matrizCoeficientes.getComponentes()[scan.nextInt()][scan.nextInt()]=scan.nextDouble();
			
			for (int i = 0; i < orden; i++)
				this.vectorTerminosIndependientes.getComponentes()[i] = scan.nextDouble();
			
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public MatrizMath getMatrizCoeficientes() {
		return matrizCoeficientes;
	}

	public void setMatrizCoeficientes(MatrizMath matrizCoeficientes) {
		this.matrizCoeficientes = matrizCoeficientes;
	}

	public VectorMath getVectorIncognita() {
		return vectorIncognita;
	}

	public void setVectorIncognita(VectorMath vectorIncognita) {
		this.vectorIncognita = vectorIncognita;
	}

	public VectorMath getVectorTerminosIndependientes() {
		return vectorTerminosIndependientes;
	}

	public void setVectorTerminosIndependientes(VectorMath vectorTerminosIndependientes) {
		this.vectorTerminosIndependientes = vectorTerminosIndependientes;
	}

	public double getErrorSel() {
		return errorSel;
	}

	public void setErrorSel(double errorSel) {
		this.errorSel = errorSel;
	}

	public String toString() {
		String resultado = "";
		resultado += "Matriz de Coeficientes: \n"
				+ this.matrizCoeficientes.toString() + "\n";
		resultado += "Vector de Incognitas: \n"
				+ this.vectorIncognita.toString() + "\n";
		resultado += "Vector De Terminos Independientes: \n"
				+ this.vectorTerminosIndependientes.toString() + "\n";
		resultado += "Calculo de error: \n"
				+ this.errorSel + "\n";
		return resultado;
	}


	public Sel clone(){
		Sel clon = new Sel(this.getMatrizCoeficientes(),this.getVectorIncognita());
		clon.vectorTerminosIndependientes = this.vectorTerminosIndependientes.clone();
		return clon;
	}
	
	public void resolver() {
		
		try {
			MatrizMath matrizInvertida = this.getMatrizCoeficientes().invertir(); // A^-1
			this.vectorIncognita = matrizInvertida.producto(this.getVectorTerminosIndependientes()); //X
						
//			for (int j = 0; j < this.matrizCoeficientes.getDimensionCol(); j++)
//				this.getVectorIncognita().getComponentes()[j]=vectorsolucion.getComponentes()[j];
			
			this.errorSel=calcularError();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private double calcularError(){
		
		double errorTermIndep;
		VectorMath vecTermIndepPrima = null;
		
		vecTermIndepPrima = this.getMatrizCoeficientes().producto(this.getVectorIncognita()); // B'
		errorTermIndep = (vecTermIndepPrima.restar(this.getVectorTerminosIndependientes())).normaDos(); // ||B'-B||2
		
		return errorTermIndep;
	}
	
	public boolean tieneAtributosIncompletos(){
		if(this.matrizCoeficientes == null || this.vectorIncognita == null || this.vectorTerminosIndependientes == null)
			return true;
		return false;
	}
	
	public void escribirArchivoSalida(String archOut){
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter(archOut);
			pw = new PrintWriter(fichero);
			pw.println(this.vectorIncognita.getDimension());
			for (int i = 0; i < this.vectorIncognita.getDimension(); i++) {
				pw.println(this.vectorIncognita.getComponentes()[i]);
			}
			pw.println();
			this.errorSel=calcularError();
			pw.print(this.errorSel);
		} catch (Exception e) {
			System.out.println("Error de Escritura Archivo de Salida - "+e.getMessage());
		} finally {
			if (null != fichero) {
				try {
					fichero.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
