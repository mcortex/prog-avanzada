package probando.colecciones;

import java.util.Random;

public class Strings {
	public static void main(String[] args) {
		String palabra = new String("hola");
		System.out.println(palabra.toCharArray().length);
		
		String palabrota = new String("aholae");
		if (palabrota.contains(palabra))
			System.out.println("Si");
		else
			System.out.println("No");
		
		String palabrita = new String("aloha");
		if (palabrita.contains(palabra))
			System.out.println("Si");
		else
			System.out.println("No");
		
		char[] aux = palabrota.toCharArray();
		String aux2 = String.copyValueOf(aux);
		
		if (aux2.contains(palabra))
			System.out.println("Si");
		else
			System.out.println("No");
		
		
		char[] array = new char[26];
		//ABECEDARIO
		for(int i = 0; i < array.length; i++){
		     array[i] = (char)(i + 97);
		     System.out.print(array[i]);
		}
		System.out.println("");
		Random randomInt = new Random();
		
		char[] randomArray = new char[100];
		String[] arrayS = new String[100];
		for (int k=0; k < 100; k++) {
		
			for (int i = 0; i < randomArray.length; i++) {
			     randomArray[i] = (char)(randomInt.nextInt(26) + 97);
			     
			}
			arrayS[k] = String.copyValueOf(randomArray);
			//System.out.print(arrayS[k]);
		}
		for (int j=0; j < 100; j++)
		System.out.println(arrayS[j]);
	}

}
