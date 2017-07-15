package juego;

import java.util.Random;

public class GeneradorTableroRandom {
	private String[] tablero;
	
	
	public GeneradorTableroRandom(int tam){
		Random randomInt = new Random();
		char[] randomArray = new char[tam];
		this.tablero = new String[tam];
		for (int k=0; k < tam; k++) {
		
			for (int i = 0; i < randomArray.length; i++) {
			     randomArray[i] = (char)(randomInt.nextInt(26) + 97);
			     
			}
			this.tablero[k] = String.copyValueOf(randomArray);
			
		}
//		for (int j=0; j < tam; j++)
//		System.out.println(tablero[j]);
	}

}
