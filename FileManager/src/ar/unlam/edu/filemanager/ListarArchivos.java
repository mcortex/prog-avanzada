package ar.unlam.edu.filemanager;

import java.io.File;

public class ListarArchivos {
	public static void main(String[] args) {
		File path = new File("C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\TPS\\TP2\\Prueba\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\in\\");

	    File [] files = path.listFiles();
	    for (int i = 0; i < files.length; i++){
	        if (files[i].isFile()){ //this line weeds out other directories/folders
	            System.out.println(files[i].getName().toString());	            
	        }
	    }
	}

}
