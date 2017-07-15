package grafo_matriz;

public class Vertice {
	private String nombre;
	private int numVertice;
	
	public Vertice(String nombre) {
		this.nombre = nombre;
		this.numVertice = -1;
	}
	
	public String getNombre() {
		return nombre;
	}

	public boolean equals(Vertice v) {
		return nombre.equals(v.nombre);
	}
	
	public void asignaVertice(int n) {
		this.numVertice = n;
	}
	
	public String toString () {
		return this.nombre +" ("+ this.numVertice +")"; 
	}
}
