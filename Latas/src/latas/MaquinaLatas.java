package latas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MaquinaLatas extends EjercicioOIA {
	
	
	private String cintaLatas;
	private int cantLatas;
	private int seqMax1;
	private int seqMax2;
	private int distanciaSeq;
	
	public MaquinaLatas(String entrada, String salida) {
		super(new File(entrada), new File(salida));
		
		try {
			Scanner scan = new Scanner(this.entrada);
			
			this.cintaLatas = scan.nextLine();
			this.cintaLatas = this.cintaLatas.replaceAll(" ", "");
			this.cantLatas = this.cintaLatas.length()-1;
			this.seqMax1 = 0;
			this.seqMax2 = 0;
			this.distanciaSeq = 0;
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public int getSeqMax1() {
		return seqMax1;
	}




	public void setSeqMax1(int seqMax1) {
		this.seqMax1 = seqMax1;
	}




	public int getSeqMax2() {
		return seqMax2;
	}




	public void setSeqMax2(int seqMax2) {
		this.seqMax2 = seqMax2;
	}




	public int getDistanciaSeq() {
		return distanciaSeq;
	}




	public void setDistanciaSeq(int distanciaSeq) {
		this.distanciaSeq = distanciaSeq;
	}




	public String getCintaLatas() {
		return cintaLatas;
	}




	public int getCantLatas() {
		return cantLatas;
	}

	public void cuentaLatas(){
		int cuenta=0;
		char[] latas = this.getCintaLatas().toCharArray();
		char sensor = 'G';
		int pos1=0;
		int pos2=0;
		int i=0;
		
		while ( i<=this.getCantLatas() ) {
			while (sensor == latas[i]) {
				cuenta++;
				i++;
			}
			if (cuenta > this.getSeqMax1()) {
				this.setSeqMax2(this.getSeqMax1());
				this.setSeqMax1(cuenta);
				pos2=pos1;
				pos1=i-cuenta;
			} else if (cuenta > this.getSeqMax2()) {
				this.setSeqMax2(cuenta);
				pos2=i-cuenta;
			}
			int distancia = Math.abs((pos1+this.getSeqMax1())-pos2);
			this.setDistanciaSeq(distancia);
			
			cuenta=0;
			i++;
		}
	}


	public void resolver(){
		FileWriter archivo;
		try {
			archivo = new FileWriter(this.salida);
			PrintWriter printer = new PrintWriter(archivo);
			this.cuentaLatas();			
			printer.println(this.getCantLatas());
			printer.println(this.getSeqMax1());
			printer.println(this.getSeqMax2());
			printer.println(this.getDistanciaSeq());
		
			printer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
