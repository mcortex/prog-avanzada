package generador;

import java.util.Random;

import grafo.Arista;
import grafo.Ordenadora;

public class GeneradorAleatoriosPorcentaje extends Generador {
	private Arista[] aristas;

	public GeneradorAleatoriosPorcentaje(int n, double porcentaje) {
		super(n);
		
		this.aristas = new Arista[(n) * (n + 1) / 2];//Formula Amiga (c) Leonardo
		int cantidadAristas = 0;
		Random  rnd = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				Arista arista = new Arista(i + 1, j + 1,rnd.nextDouble());
				this.aristas[cantidadAristas++]=arista;
			}
		}
		
		new Ordenadora(this.aristas).quickSort(0, cantidadAristas-1);;
		
		this.setCantAristas((int)(cantidadAristas*porcentaje/100));
		this.setCantNodos(n);
		porcAdyacencia=porcentaje;
		
		for (int i = 0; i < cantAristas; i++) {
			this.matrizAdyacencia[aristas[i].getOrigen()-1][aristas[i].getDestino()-1]=true;
			this.matrizAdyacencia[aristas[i].getDestino()-1][aristas[i].getOrigen()-1]=true;
		}
		this.calcularGrado();
				
		this.porcAdyacencia=(double)cantAristas/(cantNodos*(cantNodos-1)/2)*100;
		porcAdyacencia= (double) Math.round(porcAdyacencia*100)/100;
		
	}

	public Arista[] getAristas() {
		return aristas;
	}

	public void setAristas(Arista[] aristas) {
		this.aristas = aristas;
	}

}
