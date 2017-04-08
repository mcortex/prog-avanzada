package ar.edu.unlam.luchadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Torneo {
	private Luchador [] participantes;
	private int [] resultados;
	
	public Torneo(){
		
		String path = "C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\Lotes\\LuchadoresJaponeses\\in\\";
		File archivo = new File(path+"sumo.in");

		try {
			Scanner scan = new Scanner(archivo);
			scan.useLocale(Locale.ENGLISH);
			
			// Inicializo el torneo
			int cant_participantes=scan.nextInt();
			participantes = new Luchador[cant_participantes];
			resultados = new int[cant_participantes];
			for (int i=0;i<participantes.length;i++){
				participantes[i] = new Luchador(scan.nextDouble(),scan.nextDouble());
				resultados[i]=0;
			} 
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Luchador[] getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Luchador[] participantes) {
		this.participantes = participantes;
	}
	
	public int[] getResultados() {
		return resultados;
	}

	public void setResultados(int[] resultados) {
		this.resultados = resultados;
	}
	
	public void resolver(){
		
		String path = "C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\Lotes\\LuchadoresJaponeses\\out\\";
				
		for(int i=0;i<this.getParticipantes().length;i++){
			for(int j=i+1;j<this.getParticipantes().length && i!=j;j++)
				if(this.getParticipantes()[i].domina(this.getParticipantes()[j]))
					this.resultados[i]++;		
				else
					if(this.getParticipantes()[j].domina(this.getParticipantes()[i]))
						this.resultados[j]++;
		}
		
		for(int r=0;r<this.getResultados().length;r++)
			System.out.println("Luchador "+(r+1)+" domina "+this.getResultados()[r]+" luchadores");
		
		//PRINT WRITER: Escritura de archivo
		try {
			FileWriter writer = new FileWriter(path+"sumo.out");
			PrintWriter printer = new PrintWriter(writer);
			

			for (int r=0;r<this.getResultados().length;r++){
			printer.println(this.getResultados()[r]);	
			}
							
			printer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	
}
