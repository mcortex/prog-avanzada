package probando.colecciones;
import java.util.*;

public class Listas {

	public static void main(String[] args) {
		LinkedList<Integer> lista_enlazada = new LinkedList<Integer>();
		
		lista_enlazada.add(99);
		lista_enlazada.add(5);
		lista_enlazada.add(20);
		lista_enlazada.add(7);
		lista_enlazada.add(70);
		
		ListIterator listIt = lista_enlazada.listIterator();
		
		System.out.println("Derecha");
		while(listIt.hasNext()) { 
		System.out.println(listIt.next());
		}
		
		System.out.println("Inversa");
		while(listIt.hasPrevious()) {
		System.out.println(listIt.previous());
		}
		
		System.out.println("Ordenada");
		Collections.sort(lista_enlazada);
		
		while(listIt.hasNext()) { 
		System.out.println(listIt.next());
		}
		
		LinkedList<String> lista_de_nombres = new LinkedList<String>();
		lista_de_nombres.add("Ana");
		lista_de_nombres.add("Ricardo");
		lista_de_nombres.add("Juan");
		lista_de_nombres.add("Ester");
		lista_de_nombres.add("Juana");
		lista_de_nombres.add("Pedro");
		lista_de_nombres.add("Federico");
		lista_de_nombres.add("Juan");
		lista_de_nombres.add("Ismael");
		lista_de_nombres.add("Juan");
		lista_de_nombres.add("Ana");
		lista_de_nombres.add("Pilar");
		lista_de_nombres.add("Juan");
		lista_de_nombres.add("Ana");
		lista_de_nombres.add("Juana");
		lista_de_nombres.add("Ana");
		lista_de_nombres.add("Ricardo");
		lista_de_nombres.add("Juan");
		lista_de_nombres.add("Manuel");
		lista_de_nombres.add("Juana");
		lista_de_nombres.add("Pilar");
		lista_de_nombres.add("Juana");
		lista_de_nombres.add("Ana");
		lista_de_nombres.add("Juan");
		lista_de_nombres.add("Juan");
		
		Collections.sort(lista_de_nombres);
		ListIterator<String> it_nombres = lista_de_nombres.listIterator();
		while(it_nombres.hasNext()) {
			System.out.println(it_nombres.next());
		}
		
		HashMap<String,Integer> frequencymap = new HashMap<String,Integer>();
		for(String a : lista_de_nombres) {
		  if(frequencymap.containsKey(a)) { 
		    frequencymap.put(a, frequencymap.get(a)+1);// Si ya lo tiene lo incrementa en 1
		  }
		  else{ frequencymap.put(a, 1); } // Sino lo agrega
		}
		
		System.out.println(frequencymap);
		

	}

}
