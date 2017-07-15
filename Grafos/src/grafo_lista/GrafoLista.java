package grafo_lista;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * GrafoLista define la tabla de vertices con sus respestivas listas de adyacencia
 *
 */
public class GrafoLista {
	private int numVerts;
	private static int maxVerts = 20;
	private ArrayList<VerticeAdyacencia> tablaDirectorio;
	
	public GrafoLista(int maxVerts) {
		this.tablaDirectorio = new ArrayList<VerticeAdyacencia>();
		this.numVerts = 0;
		GrafoLista.maxVerts = maxVerts;
	}
	
	
	
	public int getNumVerts() {
		return numVerts;
	}



	public ArrayList<VerticeAdyacencia> getTablaDirectorio() {
		return tablaDirectorio;
	}



	public void nuevoVertice(String nombreVertice) {
		boolean esta = obtenerNumVertice(nombreVertice) >= 0;
		if(!esta) {
			System.out.println("Agrego: "+nombreVertice);
			VerticeAdyacencia v = new VerticeAdyacencia(nombreVertice);
			v.setNumVertice(this.numVerts);
			this.numVerts++;
			this.tablaDirectorio.add(v);
		}
		else
			System.out.println("Ya esta "+nombreVertice+" no se puede repetir nombre");
	}

	public int obtenerNumVertice(String nombreVertice) {
		
		VerticeAdyacencia v = new VerticeAdyacencia(nombreVertice);
		
		// Iterador para recorrer la tabla de directorios en busca del vertice:
		ListIterator<VerticeAdyacencia> it = this.tablaDirectorio.listIterator(); 
		boolean encontrado = false;
		int numNodo = 0;
		
		while (it.hasNext() && !encontrado) {
			encontrado = it.next().equals(v);
			if (!encontrado) {
				numNodo++;
			}
//			else 
//				System.out.println("Encontrado! " +nombreVertice);
		}

		return (numNodo < this.numVerts) ? numNodo : -1;
	}
	
	public void agregarArcoAdyacente(final String nodoInicio, final String nodoFin, final double pesoArco) throws Exception{
		if (!this.adyacente(nodoInicio, nodoFin)) {
			int nI = this.obtenerNumVertice(nodoInicio);
			int nF = this.obtenerNumVertice(nodoFin);
			if(nI<0 || nF<0) {
				throw new Exception("Uno de los vertices no existe");
			}
			Arco arcoAdy = new Arco(nF, pesoArco);
			this.tablaDirectorio.get(nI).getListaAdy().add(arcoAdy);
		}
	}
	
	public boolean adyacente(String nodoInicio, String nodoFin) throws Exception {
		int nI = this.obtenerNumVertice(nodoInicio);
		int nF = this.obtenerNumVertice(nodoFin);
		if(nI<0 || nF<0) {
			throw new Exception("Uno de los vertices no existe");
		}
		System.out.println(this.tablaDirectorio.get(nI)+ " "+ this.tablaDirectorio.get(nF));
		return this.tablaDirectorio.get(nI).getListaAdy().contains(this.tablaDirectorio.get(nF));
	}

}
