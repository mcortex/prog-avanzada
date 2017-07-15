package grafo_matriz;

public class Main {

	public static void main(String[] args) {
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
			
			if (grafoCincoNodos.adyacente("A", "B")) {
				System.out.println("Son Adyacentes");
				
			RecorreGrafo.recorrerEnAnchura(grafoCincoNodos, "C");
			
			RecorreGrafo.matrizCaminosWarshall(grafoCincoNodos);
			
			Dijkstra dijkstra = new Dijkstra(grafoCincoNodos,"A");
			
			dijkstra.caminoMinimo();
			System.out.println("\nDijkstra:");
			for (int i = 0; i < grafoCincoNodos.getNumVerts(); i++) {
				System.out.println("Distancia desde nodo A hacia nodo: "+ i + " " + dijkstra.getVecCostoMin()[i]);
			}
			
			dijkstra.recuperarCamino(1);
			
			}
			
			Floyd floyd = new Floyd(grafoCincoNodos);
			
			floyd.obtenerCaminosMinimos();
			
			System.out.println(floyd);
			
			Prim prim = new Prim(grafoCincoNodos);
			
			prim.arbolExpansionCosteMinimo();

			Kruskal kruskal = new Kruskal(grafoCincoNodos);
			
			kruskal.resolverKruskal();
			
			System.out.println(kruskal);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
