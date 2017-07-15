package grafo_matriz;

public class GrafoMatriz {
	
	public static final int INFINITO = 999999;
	private int numVerts;
	private static int maxVertices = 20;
	private Vertice [] vertices;
	private int [][] matAdy;
	
	public GrafoMatriz() {
		this(maxVertices);
	}

	public GrafoMatriz(int maxVerts) {
		
		this.vertices = new Vertice[maxVerts];
		this.matAdy = new int[maxVerts][maxVerts];
		for (int i=0;i<maxVerts;i++) {
			for (int j=0;j<maxVerts;j++) {
				this.matAdy[i][j] = INFINITO;
			}
		}
		
		this.numVerts = 0;
	}
	
	/**
	 * Añadir un vertice:
	 * Recibe la etiqueta String del vertice, comprueba si ya está en la lista,
	 * sino lo asigna a la lista de vertices e incrementa la lista.
	 * @param nombreVertice
	 */
	public void nuevoVertice(String nombreVertice) { 
		boolean esta = obtenerNumVertice(nombreVertice) >= 0; 
		if (!esta) {
			Vertice v = new Vertice(nombreVertice);
			v.asignaVertice(this.numVerts);
			this.vertices[this.numVerts++] = v;
		}
	}

	/**
	 * Busca el vertice en el array, devuelve -1 si no lo encuentra
	 * @param nombreVertice
	 * @return
	 */
	public int obtenerNumVertice(String nombreVertice) {
		Vertice v = new Vertice(nombreVertice);
		boolean encontrado = false;
		int i = 0;
		for(;(i<this.numVerts) && !encontrado;){
			encontrado = this.vertices[i].equals(v);
			if (!encontrado) {
				i++;
			}
		}
		return (i < this.numVerts) ? i : -1;
	}
	
	/**
	 * Añadir Arco:
	 * Recibe el nombre de cada vertice del arco, busca su correspondiente numero de vertice
	 * y lo marca en la matriz de adyacencia.
	 * <p>
	 * En grafos no ponderados pesoArco = 1
	 * @param nodoInicio
	 * @param nodoFin
	 * @throws Exception
	 */
	public void nuevoArco(String nodoInicio, String nodoFin, int pesoArco) throws Exception {
		int va, vb;
		va = this.obtenerNumVertice(nodoInicio);
		vb = this.obtenerNumVertice(nodoFin);
		if( va < 0 || vb < 0 ) {
			throw new Exception("Uno de los vertices no existe.");
		}
		this.matAdy[va][vb] = pesoArco;
	}
	
	/**
	 * Determina si dos vertices forman un arco. Es decir, si el elemento de la matriz de adyacencia
	 * es mayor o igual a 1.
	 * @param nodoInicio
	 * @param nodoFin
	 * @return 
	 * @throws Exception
	 */
	public boolean adyacente(String nodoInicio, String nodoFin) throws Exception {
		int va, vb;
		va = this.obtenerNumVertice(nodoInicio);
		vb = this.obtenerNumVertice(nodoFin);
		if( va < 0 || vb < 0 ) {
			throw new Exception("Uno de los vertices no existe.");
		}
		return this.matAdy[va][vb] >= 1;
	}
	
	public int getNumVerts(){
		return this.numVerts;
	}

	public static int getMaxVertices() {
		return maxVertices;
	}

	public Vertice[] getVertices() {
		return vertices;
	}

	public int[][] getMatAdy() {
		return matAdy;
	}
	
	

}
