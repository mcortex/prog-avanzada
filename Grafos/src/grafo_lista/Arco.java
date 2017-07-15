package grafo_lista;

/**
 * Dado un Vertice u, la class Arco guarda el vertice destino v  y el peso asociado al arco.
 */

public class Arco {
	private int destino;
	private double pesoArco;
	
	public Arco(int destino) {
		this.destino = destino;
	}

	public Arco(int destino, double peso) {
		this(destino);
		this.pesoArco = peso;
	}
	
	public int getDestino() {
		return this.destino;
	}
	
	public double getPesoArco() {
		return this.pesoArco;
	}
	
	public boolean equals(Object n) {
		Arco a = (Arco) n;
		return this.destino == a.destino;
	}
}
