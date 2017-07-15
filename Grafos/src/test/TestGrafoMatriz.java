package test;

import org.junit.Test;

import grafo_matriz.GrafoMatriz;

import org.junit.Assert;

public class TestGrafoMatriz {
	@Test
	public void queGeneraUnGrafoDirigido() {
		GrafoMatriz grafoCincoNodos = new GrafoMatriz(5);
		grafoCincoNodos.nuevoVertice("A");
		grafoCincoNodos.nuevoVertice("B");
		grafoCincoNodos.nuevoVertice("C");
		grafoCincoNodos.nuevoVertice("D");
		grafoCincoNodos.nuevoVertice("E");
		
		try {
			grafoCincoNodos.nuevoArco("A", "B", 100);
			grafoCincoNodos.nuevoArco("A", "C", 30);
			grafoCincoNodos.nuevoArco("A", "D", 20);
			grafoCincoNodos.nuevoArco("C", "B", 40);
			grafoCincoNodos.nuevoArco("C", "E", 5);
			grafoCincoNodos.nuevoArco("E", "B", 30);
			grafoCincoNodos.nuevoArco("E", "D", 40);
			
			Assert.assertTrue(grafoCincoNodos.adyacente("A", "B"));
			Assert.assertFalse(grafoCincoNodos.adyacente("A", "E"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
