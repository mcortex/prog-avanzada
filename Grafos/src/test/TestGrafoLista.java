package test;

import org.junit.Assert;
import org.junit.Test;

import grafo_lista.GrafoLista;

public class TestGrafoLista {
	@Test
	public void queGeneraUnGrafoDirigido() {
		GrafoLista grafoCincoNodos = new GrafoLista(5);
		grafoCincoNodos.nuevoVertice("A");
		grafoCincoNodos.nuevoVertice("B");
		grafoCincoNodos.nuevoVertice("C");
		grafoCincoNodos.nuevoVertice("D");
		grafoCincoNodos.nuevoVertice("E");
		grafoCincoNodos.nuevoVertice("A");
		Assert.assertEquals(5, grafoCincoNodos.getNumVerts());
		grafoCincoNodos.obtenerNumVertice("A");
		Assert.assertEquals(0, grafoCincoNodos.obtenerNumVertice("A"));
		
		
		
		try {
			Assert.assertFalse(grafoCincoNodos.adyacente("A","B"));
//			grafoCincoNodos.agregarArcoAdyacente("A", "B", 100);
//			grafoCincoNodos.agregarArcoAdyacente("A", "C", 30);
//			grafoCincoNodos.agregarArcoAdyacente("A", "D", 20);
//			grafoCincoNodos.agregarArcoAdyacente("C", "B", 40);
//			grafoCincoNodos.agregarArcoAdyacente("C", "E", 5);
//			grafoCincoNodos.agregarArcoAdyacente("E", "B", 30);
//			grafoCincoNodos.agregarArcoAdyacente("E", "D", 40);
//			
//			Assert.assertTrue(grafoCincoNodos.adyacente("A", "B"));
//			Assert.assertFalse(grafoCincoNodos.adyacente("A", "E"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
