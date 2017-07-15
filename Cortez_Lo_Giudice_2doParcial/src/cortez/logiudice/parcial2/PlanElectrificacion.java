package cortez.logiudice.parcial2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class PlanElectrificacion extends EjercicioOIA {
	
	private GrafoMatriz grafo;
	private int[][] matCostosMinimos;
	private int cantNodos, cantCentrales;
	private int[] vecCentrales;
	
	private ArrayList<String> ciudades;
	private int costoTotal;
	
	public PlanElectrificacion(File entrada, File salida) {
		super(entrada, salida);
		try {
			Scanner scan = new Scanner(this.entrada);
			
			this.cantNodos = scan.nextInt();
//			this.nodos = new int[this.cantNodos];
			this.cantCentrales = scan.nextInt();
			this.vecCentrales = new int[this.cantCentrales];
			
			for (int i = 0; i < this.cantCentrales; i++) {
				this.vecCentrales[i] = scan.nextInt();
			}
			
			int[][] matAdy = new int[this.cantNodos][this.cantNodos];
			
			for (int i = 0; i < this.cantNodos; i++) {
				for (int j = 0; j < this.cantNodos; j++) {
					matAdy[i][j] = scan.nextInt();
//					if(i==j) {
//						matAdy[i][j] = GrafoMatriz.INFINITO;
//					}
						
 				}
			}
			

			
			this.grafo = new GrafoMatriz(this.cantNodos, matAdy);
			
			this.ciudades = new ArrayList<String>();
			this.costoTotal = 0;
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void Floyd() {
		this.matCostosMinimos = grafo.getMatAdyacencia();
		
		for (int k = 0; k < this.cantNodos; k++) {
			for (int i = 0; i < this.cantNodos; i++) {
				for (int j = 0; j < this.cantNodos; j++) {
				
					if(( this.matCostosMinimos[i][k] + this.matCostosMinimos[k][j] ) < this.matCostosMinimos[i][j]) {
						this.matCostosMinimos[i][j] = this.matCostosMinimos[i][k] + this.matCostosMinimos[k][j];
					}
					
				}
			}
		}
		
		String resultado="FLOYD:\n";
		for (int i = 0; i < matCostosMinimos.length; i++) {
			for (int j = 0; j < matCostosMinimos.length; j++) {
				resultado+=this.matCostosMinimos[i][j] + " ";
			}
			resultado+="\n";
		}
		System.out.println(resultado);
		
	}
	
	public int minimo(int ciudad) {
		int costoMin = GrafoMatriz.INFINITO;
		int posMin = 0;
		
		for (int i = 0; i < this.cantNodos; i++) {
			if (this.esCentral(i)) {
				if (this.matCostosMinimos[ciudad][i] > 0 && this.matCostosMinimos[ciudad][i] <= costoMin){
					costoMin = this.matCostosMinimos[ciudad][i];
					posMin = i;
					
				}
			}
		}
		this.ciudades.add((ciudad+1)+" "+(posMin+1));
		
		
		return costoMin;
	}
	
	public boolean esCentral(int ciudad) {
		boolean es = false;
		for (int i = 0; i < this.cantCentrales && !es; i++) {
			if ((ciudad) == (this.vecCentrales[i]-1))
				es = true;
		}
		
		return es;
	}
	
	public void resolver(){
		this.Floyd();
			
		for (int i = 0; i < this.cantNodos ; i++) {
			if (!this.esCentral(i))
				this.costoTotal += this.minimo(i);
		}
		
		this.escribirSalidaArchivo();
	}

	private void escribirSalidaArchivo() {
		FileWriter fw;
		
		try {
			fw = new FileWriter (this.salida);
			PrintWriter printer = new PrintWriter(fw);
			
			printer.println(this.costoTotal);
			if (this.costoTotal>0) {
				Iterator<String> it = this.ciudades.iterator();
				while(it.hasNext()) {
					printer.println(it.next());
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		PlanElectrificacion pe = new PlanElectrificacion(new File("LotePrueba/in/01_enunciado.in"), new File("LotePrueba/out/01_enunciado.out"));
//		PlanElectrificacion pe = new PlanElectrificacion(new File("LotePrueba/in/02_solo_una_central.in"), new File("LotePrueba/out/02_solo_una_central.out"));
//		PlanElectrificacion pe = new PlanElectrificacion(new File("LotePrueba/in/03_todas_con_central.in"), new File("LotePrueba/out/03_todas_con_central.out"));
		PlanElectrificacion pe = new PlanElectrificacion(new File("LotePrueba/in/04_unica_central.in"), new File("LotePrueba/out/04_unica_central.out"));
		pe.resolver();
	}

}
