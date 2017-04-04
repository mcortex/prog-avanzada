package ar.unlam.edu.ar.filemanager;

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
		int cantIn=0;
		
		try {
			Scanner scan = new Scanner(archivo);
			scan.useLocale(Locale.ENGLISH);
			while(scan.hasNextInt()){
				int numero=scan.nextInt();
				cantIn++;
				System.out.println("Numero: "+numero);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//PRINT WRITER
		try {
			FileWriter writer = new FileWriter(path+"archivo.out");
			PrintWriter printer = new PrintWriter(writer);
			//for (int i=0;i<cantIn;i++){
				
			//}
			printer.println("Cantidad de valores en el archivo de entrada: "+cantIn);
			
			printer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
