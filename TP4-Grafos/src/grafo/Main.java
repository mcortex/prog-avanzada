package grafo;

import java.io.File;

import generador.GeneradorAleatoriosPorcentaje;
import generador.GeneradorRegularesPorcentaje;

public class Main {

	public static void main(String[] args) {
		// int n=10;
		// double porcentaje=50;
		// GeneradorAleatoriosPorcentaje generadorAleatoriosPorcentaje = new
		// GeneradorAleatoriosPorcentaje(n, porcentaje);
		// GeneradorRegularesPorcentaje generadorRegularesPorcentaje= new
		// GeneradorRegularesPorcentaje(n, porcentaje);
		// double aristasMax=(n*(n-1)/2);
		// double
		// porcentajeUnGradoMenos=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima()-1)/2)/aristasMax);
		// double
		// porcentajeCalculado=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima())/2)/aristasMax);
		// double
		// porcentajeUnGradoMas=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima()+1)/2)/aristasMax);
		// //generadorRegularesPorcentaje.mostrarAdyacencia();//Usado en Debug
		// System.out.println();
		// generadorRegularesPorcentaje.escribirArchivo("Lote de
		// Prueba\\RegularAl50Porciento.in");
		// generadorAleatoriosPorcentaje.escribirArchivo("Lote de
		// Prueba\\AleatorioAl50Porciento.in");
		// GrafoNDNP prueba=new GrafoNDNP("Lote de
		// Prueba\\AleatorioAl50Porciento.in");
		// try {
		//
		// prueba.welsh_Powel();
		// prueba.calcularCantidadColores();
		//
		//
		// prueba.escribirArchivo("Lote de Prueba\\AleatorioAl50Porciento.out");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		//

		int minimoColoresResultantes = 9999999;
	//	int cantidadColoresResultantes;
		int coloresResultantes;
		int[] vectorcolores = new int[10];
		int n = 1000;
		double porcentaje = 40;
		GeneradorAleatoriosPorcentaje generadorAleatoriosPorcentaje = new GeneradorAleatoriosPorcentaje(n, porcentaje);
		generadorAleatoriosPorcentaje.escribirArchivo("Lote de Prueba\\AleatorioAl50Porciento.in");
	//	GrafoNDNP prueba = new GrafoNDNP("Lote de Prueba\\AleatorioAl50Porciento.in");
		
		
		//ACA DEBERIA PINTAR 10000 VECES EL MISMO GRAFO.
		for (int i = 0; i < 10; i++) {
			try {
				GrafoNDNP prueba = new GrafoNDNP("Lote de Prueba\\AleatorioAl50Porciento.in");
				//prueba = new GrafoNDNP(prueba);
				prueba.welsh_Powel();
				
				coloresResultantes = prueba.calcularCantidadColores();
				System.out.println("vuelta: " + i);
				
				//Guardo la cantidad de colores que uso en cada corrida.
				vectorcolores[i] = coloresResultantes;
				System.out.println("Cant color:" + coloresResultantes);
				
				//Si es la menor cantidad de colores guardo como pinto cada nodo (el color)
				if (coloresResultantes < minimoColoresResultantes) {
					minimoColoresResultantes = coloresResultantes;
					prueba.escribirArchivo("Lote de Prueba\\AleatorioAl50Porciento.out");
				}
System.out.println("asd");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < vectorcolores.length; j++) {
			System.out.println("pasada " + j + " cant colores " + vectorcolores[j]);
		}

	}
}
