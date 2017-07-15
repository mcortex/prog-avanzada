package ar.edu.unlam.sel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Probador {
	
	private MatrizMath matrizCoeficientes; //INPUT
	private VectorMath vectorTerminosIndependientes;//INPUT
	private VectorMath vectorIncognita; //OUTPUT
	private double errorSel; //OUTPUT
	
	public Probador(String archIn,String archOut){
		//ARCHIVO IN
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
		
	
		//ARCHIVO OUT
		File archivoOut=null;
		FileReader frOut=null;
		BufferedReader brOut = null;
		String lineaOut="";
		Integer dimension=0;
		double[] vectorT = null;
		//ABRO ARCHIVO:
		try {
			archivoOut= new File(archOut);
			frOut=new FileReader(archivoOut);
			brOut=new BufferedReader(frOut);
			//CARGO VECTOR INCOGNITAS:
			lineaOut = brOut.readLine();
			dimension = Integer.parseInt(lineaOut);
			this.vectorIncognita = new VectorMath(dimension);
			vectorT=new double[dimension];
			for(int i=0;i<dimension;i++){
				lineaOut=brOut.readLine();
				vectorT[i]=Double.parseDouble(lineaOut);
			}
			this.vectorIncognita.setComponentes(vectorT);
			lineaOut = brOut.readLine();
			lineaOut = brOut.readLine();
			//CARGO ERROR:
			this.errorSel = Double.parseDouble(lineaOut);
	
		} catch (Exception e) {
		}
		finally{
			if(frOut !=null){
				try {
					frOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// VERIFICA EL ERROR
	public boolean probarSel(){
		boolean respuesta=false;

		if ( this.errorSel < 10E-6)
			respuesta=true;
		else
			respuesta=false;
				
		return respuesta;
	}
	
	// VERIFICA EL ERROR EN LAS IDENTIDADES
	public boolean probarIdentidad(){
		MatrizMath identidadPrima = this.matrizCoeficientes.producto(this.matrizCoeficientes.invertir());
		MatrizMath identidad = new MatrizMath(this.matrizCoeficientes.getDimensionFil(),this.matrizCoeficientes.getDimensionCol());
		identidad.setIdentidad();

		if((identidadPrima.restar(identidad)).normaDos()<=10E-6)
			return true;
		return false;
	}
	
}
