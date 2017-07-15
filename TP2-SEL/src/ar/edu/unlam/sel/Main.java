package ar.edu.unlam.sel;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		
		String pathIn = "C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\TPS\\TP2\\Prueba\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\in\\";
		//String pathIn = "C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\TPS\\TP2\\Prueba\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\Random\\"; //Utilizado para analisis de rendimiento
		String pathOut = "C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\TPS\\TP2\\Prueba\\Ejecucion de la Prueba\\Salida Obtenida\\";
		
		String arch="";		
		String[] nombreArch;
		
		File path = new File(pathIn);
	    File [] files = path.listFiles();
	    
	    for (int i = 0; i < files.length; i++){
	        if (files[i].isFile()){
	        	
	        	// APERTURA DE ARCHIVO DE ENTRADA
	        	Sel caso = new Sel(files[i].toString());
	        	arch = files[i].getName().toString();
	        	
	        	// 1.SALIDA EN PANTALLA
//	        	System.out.println("--------------\n" + arch + "\n");
//	        	caso.resolver();
//	        	System.out.println(caso);

	        	// 2.CALCULO DE TIEMPOS
//	        	Calendar tIni = new GregorianCalendar();
//	        	caso.resolver();
//	        	Calendar tFin = new GregorianCalendar();
//	        	long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
//	        	System.out.println(arch + "\t" +diff);
	        	

	        	// 3.ESCRITURA DE ARCHIVO, DESCOMENTAR SOLO CUANDO SEA NECESARIO:
//	        	caso.resolver();
//	        	nombreArch = arch.split("\\.");
//	        	System.out.println("Escribiendo Archivo: " + pathOut + nombreArch[0] + ".out\n");
//	        	caso.escribirArchivoSalida(pathOut+nombreArch[0]+".out");
	        	
	        	// 4.PROBADOR
	        	caso.resolver();
	        	nombreArch = arch.split("\\.");
	        	System.out.println("---\nProbando Sel: " + pathOut + nombreArch[0] + ".out\n");
	        	Probador probador = new Probador(files[i].toString(),pathOut + nombreArch[0] + ".out");
	        	if(probador.probarSel())
	        		System.out.println("OK\n");
	        	else
	        		System.out.println("El error no es menor a la cota dada.");
	        	
	        }
	    }
	
	}

}
