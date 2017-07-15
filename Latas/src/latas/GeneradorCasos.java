package latas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneradorCasos {

	public static void main(String[] args) {
		FileWriter arch;
		try {
			arch = new FileWriter("LotePrueba/out/salidastress.out");
			
			PrintWriter printer = new PrintWriter(arch);
			//int cant= 4949;

			String salida = new String("T");
			for(int i=0;i<98;i++)
			{
				for(int j=0; j<i+1;j++)
				{salida = salida.concat("G ");

				}
				salida = salida.concat("T ");
			}
		salida = salida.concat("F");
		
		
		printer.println(salida);
		printer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}

