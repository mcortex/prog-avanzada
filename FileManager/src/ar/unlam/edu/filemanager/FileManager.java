package ar.unlam.edu.filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class FileManager {

	public static void main(String[] args) {
		//SCANNER: Lectura de archivos
		String path = "C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\Lotes\\PruebaArchivos\\";
		File archivo = new File(path+"archivo.in");
//		int valor=0;

		
		try {
			Scanner scan = new Scanner(archivo);
			scan.useLocale(Locale.ENGLISH);
			int [] vector = new int[scan.nextInt()];
			
//			while(scan.hasNextInt()){
//				valor=scan.nextInt();
//				System.out.println("Numero: "+valor);
//				cantIn++;
//			}
			
			for (int i=0;i<vector.length;i++){
				vector[i]=scan.nextInt();
				System.out.println("Valor "+i+": "+vector[i]);
			}
			
			scan.close();
			
			//PRINT WRITER: Escritura de archivo
			try {
				FileWriter writer = new FileWriter(path+"archivo.out");
				PrintWriter printer = new PrintWriter(writer);
				
				printer.println("Cantidad de valores en el archivo de entrada: "+vector.length);
				
				for (int i=0;i<vector.length;i++){
				printer.println(vector[i]);	
				}
								
				printer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
