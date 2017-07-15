package corredores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Corredores extends EjercicioOIA{
	
	// IN
	private int cantAnotados;
	private int cantCatFem;
	private int cantCatMasc;
	private Categoria[] catFem;
	private Categoria[] catMasc;
	private Corredor[] corredores;
	private int[] corredoresEnMeta;
	private int enMeta;
	
	// OUT
	private int[][] ganadoresCatFem;
	private int[][] ganadoresCatMasc;
	
	public Corredores(File entrada, File salida) {
		super(entrada, salida);
		Scanner scan;
		try {
			scan = new Scanner(this.entrada);
			
			this.cantAnotados = scan.nextInt();
			this.cantCatFem = scan.nextInt();
			this.cantCatMasc = scan.nextInt();
			this.enMeta = scan.nextInt();
			
			this.catFem = new Categoria[this.cantCatFem];
			for (int i = 0; i < this.cantCatFem; i++) {
				this.catFem[i] = new Categoria((i+1),scan.nextInt(),scan.nextInt());
			}
			
			this.catMasc = new Categoria[this.cantCatMasc];
			for (int i = 0; i < this.cantCatMasc; i++) {
				this.catMasc[i] = new Categoria((i+1),scan.nextInt(),scan.nextInt());
			}
			
			int corredorEdad = 0;
			String corredorSexo = "";
			this.corredores = new Corredor[this.cantAnotados];
			for (int i = 0; i < this.cantAnotados; i++) {
				
				corredorEdad = scan.nextInt();
				corredorSexo = scan.next();
				
//				System.out.println(corredorSexo.charAt(0));
				
				this.corredores[i] = new Corredor(corredorEdad, corredorSexo.charAt(0) , (i));
			}
			

			this.corredoresEnMeta = new int[this.enMeta];
			for (int i = 0; i < this.enMeta; i++) {
				this.corredoresEnMeta[i] = scan.nextInt();
//				System.out.println(this.corredoresEnMeta[i]);
			} 
				
			
			
			// Armo matriz de salida vacia:
			this.ganadoresCatFem = new int[this.cantCatFem][4];
			for (int i = 0; i < this.cantCatFem; i++) {
				
				this.ganadoresCatFem[i][0] = i+1;
				
				for (int j = 1; j < 4; j++) {
					this.ganadoresCatFem[i][j] = 0;
				}
			}
			
			this.ganadoresCatMasc = new int[this.cantCatMasc][4];
			for (int i = 0; i < this.cantCatMasc; i++) {
				
				this.ganadoresCatMasc[i][0] = i+1;
				
				for (int j = 1; j < 4; j++) {
					this.ganadoresCatMasc[i][j] = 0;
				}
			}
			
		scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}
	
	public int defineCategoriaCorredor(int edad, char sexo) {
		int categoria=0;			
		if (sexo == 'M'){ // O(n) maximo 50
			for (int i = 0; i < this.cantCatMasc; i++) {
				if (edad >= this.catMasc[i].getTopeMin() && edad <= this.catMasc[i].getTopeMax()) {
					categoria = this.catMasc[i].getIdCategoria();
				}
			}
		}
		if (sexo == 'F'){ // O(n) maximo 50
			for (int i = 0; i < this.cantCatFem; i++) {
				if (edad >= this.catFem[i].getTopeMin() && edad <= this.catFem[i].getTopeMax()) {
					categoria = this.catFem[i].getIdCategoria();
				}
			}
		}	
		
		return categoria;
	}

	@Override
	public void resolver() {
		
		int[] premioMasc = new int[this.cantCatMasc];
		int[] premioFem = new int[this.cantCatFem];
		int catCorredor = 0;
		char sexoCorredor;
		
		for (int i = 0; i < this.cantCatMasc; i++) {
			premioMasc[i] = 0;
		}
		for (int i = 0; i < this.cantCatFem; i++) {
			premioFem[i] = 0;
		}
		
		/*
		 * La complejidad vendria dada por n ganadores: 1<=n<=A<=1000000
		 * Pero, colocados en una matriz de (Fx+My)*3 con 10<=Fx,Ny<=60 -> 50*2 = 100 categorias
		 * Por lo tanto por mas que se tengan 1000000 en la meta y 50 categorias para cada genero tendran un corte en 300 corredores
		 * O(300) con corte de control.
		 * O(n) * O(100) sin corte de control
		 */
		
		// En este caso es O(n) * O(100)  = 100*n => O(n)
		for (int i = 0; i < this.enMeta; i++) { // O(n) corredores en meta
						 
//			this.corredores[this.corredoresEnMeta[i]].setCategoria(this.defineCategoriaCorredor(
//																		this.corredores[this.corredoresEnMeta[i]].getEdad(), 
//																		this.corredores[this.corredoresEnMeta[i]].getSexo())
//																	);
//			
//			catCorredor = this.corredores[this.corredoresEnMeta[i]].getCategoria();
//			sexoCorredor = this.corredores[this.corredoresEnMeta[i]].getSexo();
			
			catCorredor = this.defineCategoriaCorredor(
								this.corredores[this.corredoresEnMeta[i]-1].getEdad(),
								this.corredores[this.corredoresEnMeta[i]-1].getSexo()); // O(n) maximo 50
			sexoCorredor =this.corredores[this.corredoresEnMeta[i]-1].getSexo();
			
			System.out.println("Categoria: " +catCorredor+ " sexo: " +sexoCorredor );
			
			if ( catCorredor > 0) {
				if (sexoCorredor == 'F' && premioFem[catCorredor-1] < 3) {
					this.ganadoresCatFem[catCorredor-1][premioFem[catCorredor-1]+1] = this.corredoresEnMeta[i];
					premioFem[catCorredor-1]++;
					System.out.println("Ganador: " + this.corredoresEnMeta[i]);
				}
				if (sexoCorredor == 'M' && premioMasc[catCorredor-1] < 3) {
					this.ganadoresCatMasc[catCorredor-1][premioMasc[catCorredor-1]+1] = this.corredoresEnMeta[i];
					premioMasc[catCorredor-1]++;
					System.out.println("Ganador: " + this.corredoresEnMeta[i]);
				}
			}
			else
				System.out.println("Corredor no corresponde a ninguna categoria");
			
		}
		
		String resultado ="";
		
		for (int i = 0; i < this.cantCatFem; i++) {
			for (int j = 0; j < 4; j++) {
				resultado += this.ganadoresCatFem[i][j];
				resultado += " ";
			}
			resultado+="\n";
		}
		
		for (int i = 0; i < this.cantCatMasc; i++) {
			for (int j = 0; j < 4; j++) {
				resultado += this.ganadoresCatMasc[i][j];
				resultado += " ";
			}
			resultado+="\n";
		}
		
		System.out.println(resultado);
		
	}
	
	public void escribirArchivoSalida() {
		FileWriter writer;
		try {
			writer = new FileWriter(this.salida);
			PrintWriter printer = new PrintWriter(writer);
			
			String resultado ="";
			
			for (int i = 0; i < this.cantCatFem; i++) {
				for (int j = 0; j < 4; j++) {
					resultado += this.ganadoresCatFem[i][j];
					resultado += " ";
				}
				printer.println(resultado);
				resultado="";
			}
			
			for (int i = 0; i < this.cantCatMasc; i++) {
				for (int j = 0; j < 4; j++) {
					resultado += this.ganadoresCatMasc[i][j];
					resultado += " ";
				}
				printer.println(resultado);
				resultado="";
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
//		Corredores carrera = new Corredores(new File("LotePrueba/in/00_carrera.in"),new File("LotePrueba/out/00_carrera.out"));
//		Corredores carrera = new Corredores(new File("LotePrueba/in/01_fatiga.in"),new File("LotePrueba/out/01_fatiga.out"));
		
//		Corredores carrera = new Corredores(new File("LotePrueba/in/02_ganadores_al_final.in"),new File("LotePrueba/out/02_ganadores_al_final.out"));
//		Corredores carrera = new Corredores(new File("LotePrueba/in/03_solo_ganan_mujeres.in"),new File("LotePrueba/out/03_solo_ganan_mujeres.out"));
		Corredores carrera = new Corredores(new File("LotePrueba/in/04_solo_ganan_hombres.in"),new File("LotePrueba/out/04_solo_ganan_hombres.out"));
		
		carrera.resolver();
		carrera.escribirArchivoSalida();
	}
	
}
