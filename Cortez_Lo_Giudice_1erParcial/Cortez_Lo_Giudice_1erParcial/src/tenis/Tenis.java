package tenis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.xml.crypto.dsig.CanonicalizationMethod;

public class Tenis extends EjercicioOIA {
	private int cantTotalJuegos; // N
	private int cantSets; // S
	private int topeJuegos; // J
	private int diferenciaJuegos; // D solo valida cuando uno de los dos
									// jugadores llega a J
	private char[] juego; // contiene N juegos
	private int puntajeA;
	private int puntajeB;

	public Tenis(File entrada, File salida) {
		super(entrada, salida);

		Scanner scan;

		try {
			scan = new Scanner(entrada);

			this.cantTotalJuegos = scan.nextInt();
			this.cantSets = scan.nextInt();
			this.topeJuegos = scan.nextInt();
			this.diferenciaJuegos = scan.nextInt();

			this.juego = new char[this.cantTotalJuegos];

			// System.out.println("cant juegos: " + this.topeJuegos);

			String partidoAux = scan.next();

			this.juego = partidoAux.toCharArray();

			// for (int i = 0; i < partido.length; i++) {
			// System.out.println(partido[i]);
			// }

			this.puntajeA = 0;
			this.puntajeB = 0;

			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void resolver() {

		int contJuegosA = 0;
		int contJuegosB = 0;

		int diferenciaA = 0;
		int diferenciaB = 0;

		int cantidadSetA = 0;
		int cantidadSetB = 0;

		// Complejidad computacional O(n) 
		for (int i = 0; i < this.cantTotalJuegos; i++) {

			if (this.juego[i] == 'A') {
				// System.out.println("juego para A");
				contJuegosA++;
			}
			if (this.juego[i] == 'B') {
				// System.out.println("juego para B");
				contJuegosB++;
			}

			if (contJuegosA >= this.topeJuegos) { // topeJuegos es J, cantidad
													// de juegas a ganar para
													// ganar un set (S)
				diferenciaA = contJuegosA - contJuegosB;
				// System.out.println("difA: " +diferenciaA);
				if (diferenciaA >= this.diferenciaJuegos) {
					cantidadSetA++;
					contJuegosA = 0;
					contJuegosB = 0;
					diferenciaA = 0;
					diferenciaB = 0;
					System.out.println("A: " + cantidadSetA);
				}
			}

			if (contJuegosB >= this.topeJuegos) { // topeJuegos es J, cantidad
													// de juegas a ganar para
													// ganar un set (S)
				diferenciaB = contJuegosB - contJuegosA;
				// System.out.println("difB: " +diferenciaB);
				if (diferenciaB >= this.diferenciaJuegos) // D
				{
					cantidadSetB++;
					contJuegosA = 0;
					contJuegosB = 0;
					diferenciaA = 0;
					diferenciaB = 0;
					System.out.println("B: " + cantidadSetB);
				}
			}
		}

		System.out.println("total A: " + cantidadSetA);
		System.out.println("total B: " + cantidadSetB);

		this.puntajeA = cantidadSetA;
		this.puntajeB = cantidadSetB;
	}

	public void escribirArchivo() {
		FileWriter writer;
		try {
			writer = new FileWriter(salida);
			PrintWriter printer = new PrintWriter(writer);
			String resultado = this.puntajeA + " " + this.puntajeB;
			printer.println(resultado);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		 Tenis tenis = new Tenis(new File("LotePrueba/in/01_ejemplo_parcial_1.in"),new File("LotePrueba/out/01_ejemplo_parcial_1.out"));
		Tenis tenis = new Tenis(new File("LotePrueba/in/02_ejemplo_parcial_2.in"),new File("LotePrueba/out/02_ejemplo_parcial_2.out"));
//		Tenis tenis = new Tenis(new File("LotePrueba/in/03_unico_set.in"),new File("LotePrueba/out/03_unico_set.out"));
//		Tenis tenis = new Tenis(new File("LotePrueba/in/04_desempate_al_final.in"),new File("LotePrueba/out/04_desempate_al_final.out"));
//		Tenis tenis = new Tenis(new File("LotePrueba/in/05_empate.in"),new File("LotePrueba/out/05_empate.out"));
//		Tenis tenis = new Tenis(new File("LotePrueba/in/06_todos_los_games_se_ganan_de_a_bloque.in"),new File("LotePrueba/out/06_todos_los_games_se_ganan_de_a_bloque.out"));
//		Tenis tenis = new Tenis(new File("LotePrueba/in/07_gana_A.in"),new File("LotePrueba/out/07_gana_A.out"));
//		Tenis tenis = new Tenis(new File("LotePrueba/in/08_ganaB.in"),new File("LotePrueba/out/08_ganaB.out"));
//		Tenis tenis = new Tenis(new File("LotePrueba/in/09_empate_a_cero.in"),new File("LotePrueba/out/09_empate_a_cero.out"));
//		Tenis tenis = new Tenis(new File("LotePrueba/in/10_fatiga.in"),new File("LotePrueba/out/10_fatiga.out"));
		
		tenis.resolver();
		tenis.escribirArchivo();
	}

}
