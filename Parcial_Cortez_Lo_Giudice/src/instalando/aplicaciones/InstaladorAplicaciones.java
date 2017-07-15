package instalando.aplicaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class InstaladorAplicaciones extends EjercicioOIA {

	private int cantAplicaciones;
	private int pesoAplicacion;
	private int[] aplicacionesInstaladas;
	private int appAdyacentesDesinstaladas;
	private int posicionPrimerApp;
	
	public InstaladorAplicaciones(String entrada, String salida) {
		super(new File(entrada), new File(salida));
		
		try {
			Scanner scan = new Scanner(this.entrada);
			this.cantAplicaciones = scan.nextInt();
			this.pesoAplicacion = scan.nextInt();
			this.aplicacionesInstaladas = new int[this.cantAplicaciones];
			for (int i=0; i < this.cantAplicaciones;i++) {
				this.aplicacionesInstaladas[i]=scan.nextInt();
			}
			this.appAdyacentesDesinstaladas=0;
			this.posicionPrimerApp=0;
		scan.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

	@Override
	public String toString() {
		return "InstaladorAplicaciones [aplicacionesInstaladas=" + Arrays.toString(aplicacionesInstaladas) + "]";
	}



	public int getCantAplicaciones() {
		return cantAplicaciones;
	}



	public int getPesoAplicacion() {
		return pesoAplicacion;
	}



	public int[] getAplicacionesInstaladas() {
		return aplicacionesInstaladas;
	}
	
	
	
	public int getAppAdyacentesDesinstaladas() {
		return appAdyacentesDesinstaladas;
	}



	public void setAppAdyacentesDesinstaladas(int appAdyacentesDesinstaladas) {
		this.appAdyacentesDesinstaladas = appAdyacentesDesinstaladas;
	}



	public int getPosicionPrimerApp() {
		return posicionPrimerApp;
	}



	public void setPosicionPrimerApp(int posicionPrimerApp) {
		this.posicionPrimerApp = posicionPrimerApp;
	}



//	public int sumaPosicionesAdyacentes(int posInicial, int cantPosiciones) {
//		int sumador=0;
//		
//		for (int i=posInicial; i < (posInicial+cantPosiciones); i++) {
//			
//			sumador+=this.aplicacionesInstaladas[i];
//			
//		}
//		
//		if(sumador==0)
//			return this.aplicacionesInstaladas[posInicial];
//		
//		return sumador;
//	}
//	
//	
//	public boolean obtieneAplicaciones() {
//		int posApp=0;
//		int posMin=0;
//		int cantAppAdy=1;
//		int espacioABorrar=this.getPesoAplicacion();
//		int espacioAnterior=espacioABorrar;
//		boolean encontroEspacio=false;
//
//		while(!encontroEspacio && cantAppAdy <= this.getCantAplicaciones()) { // O(n)
//			for (int i=0; i<this.getCantAplicaciones(); i++) { //O(n)
//				
//				int topeSumador = i+cantAppAdy;
//				
//				if (topeSumador <= this.getCantAplicaciones()) {
//				
//					int grupoApp = this.sumaPosicionesAdyacentes(i, cantAppAdy);
//					
//					// agarro un grupo y lo comparo
//					if (grupoApp >= espacioABorrar) {
//						espacioAnterior = espacioABorrar;
//						espacioABorrar = grupoApp;
//						posApp = i+1;
//						encontroEspacio = true;
//					}
//
//					// Si es igual al nuevo mantengo la posicion del anterior
//					if (encontroEspacio && posMin == 0) {
//						posMin = posApp;
//					}
//					
//					// Si es mayor tomo la posicion del mayor
//					if (espacioABorrar > espacioAnterior) {
//						posMin = posApp;	
//					}
//				}
//			}
//			cantAppAdy++;
//		}
//		
//		if (encontroEspacio) {
//			System.out.println((cantAppAdy-1)+"\n"+posMin+"\nEspacio a liberar: "+espacioABorrar);
//			this.setAppAdyacentesDesinstaladas(cantAppAdy-1);
//			this.setPosicionPrimerApp(posMin);
//			return true;
//		}
//		else
//			System.out.println("MEMORIA INSUFICIENTE");
//
//		return false;
//	}
	
	public boolean obtieneAplicaciones() {
		int posMin=0;
		int cantAppAdy=0;
		int espacioABorrar=0;
		int grupoApp=0;
		int incApp=0, j=0, k=0;
		boolean encontroEspacio=false;
		
		while ((j < this.getCantAplicaciones() && j <= incApp) && k < this.getCantAplicaciones()) { //O(n)

			if (grupoApp < this.getPesoAplicacion() && incApp < this.getCantAplicaciones()) {
				grupoApp += this.getAplicacionesInstaladas()[incApp];
				incApp++;
			}
			
			if (grupoApp >= this.getPesoAplicacion()) {
				encontroEspacio = true;
				
				if (grupoApp != espacioABorrar) {
					posMin = j;
				
					cantAppAdy = incApp-posMin;
				
					espacioABorrar = grupoApp;
				}
			}
			
			if (encontroEspacio) {
				grupoApp -= this.getAplicacionesInstaladas()[j];
				j++;
			} else {
				k++;
			}
		}
		
		if (encontroEspacio) {
			System.out.println((cantAppAdy)+"\n"+(posMin+1)+"\nEspacio a liberar: "+espacioABorrar);
			this.setAppAdyacentesDesinstaladas(cantAppAdy);
			this.setPosicionPrimerApp(posMin+1);
			return true;
		}
		else
			System.out.println("MEMORIA INSUFICIENTE");

		return false;
	}



	@Override
	public void resolver() {
		FileWriter salida;
		try {
			salida = new FileWriter(this.salida);
			PrintWriter printer = new PrintWriter(salida);
			
			if (this.obtieneAplicaciones()) {
				printer.println(this.getAppAdyacentesDesinstaladas());
				printer.println(this.getPosicionPrimerApp());
			}
			else {
				printer.println("MEMORIA INSUFICIENTE");
			}
			printer.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
