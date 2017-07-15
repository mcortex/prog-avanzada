package ar.edu.unlam.sel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class VectorMath {
	private double[] componentes;
	private int dimension;
	
	public VectorMath(){
	}
	
	public VectorMath(int dimension){
		this.dimension = dimension;
		this.componentes = new double[dimension];
	}
	
	public VectorMath(String path){
		
		File archivo = new File(path);
		
		try {
			Scanner scan = new Scanner(archivo);
			scan.useLocale(Locale.ENGLISH);
			
			// Inicializo el vector
			this.dimension=scan.nextInt();
			this.componentes = new double[this.dimension];
			
			for (int i=0;i<this.componentes.length;i++)
				this.componentes[i] = scan.nextDouble();
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public double[] getComponentes() {
		return componentes;
	}

	
	public void setComponentes(double[] componentes) {
		this.dimension=componentes.length;
		this.componentes = new double[this.dimension];
		for(int i=0;i<componentes.length;i++){
			this.componentes[i]=componentes[i];
		}
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	

	
	
	public VectorMath sumar(VectorMath vec) throws DistDimException{
		if (this.getDimension()!=vec.getDimension())
			throw new DistDimException("Los vectores tienen distinta dimension.");
		
		VectorMath aux = new VectorMath(this.getDimension());
		
		for (int i=0;i<this.dimension;i++)
			aux.componentes[i] = this.componentes[i]+vec.componentes[i];
		
		return aux;
	}
	
	public VectorMath restar(VectorMath vec) throws DistDimException{
		if (this.getDimension()!=vec.getDimension())
			throw new DistDimException("Los vectores tienen distinta dimension.");
		
		VectorMath aux = new VectorMath(this.getDimension());
		
		for (int i=0;i<this.dimension;i++)
			aux.componentes[i] = this.componentes[i]-vec.componentes[i];
		
		return aux;
	}

	public VectorMath producto(double numero) {
		
		VectorMath aux = new VectorMath(this.getDimension());
		
		for (int i=0;i<this.dimension;i++)
			aux.componentes[i] = this.componentes[i]*numero;
		
		return aux;
	}
	
	public double producto(VectorMath vec) {
		
		if (this.getDimension()!=vec.getDimension())
			throw new DistDimException("Los vectores tienen distinta dimension.");
		
		double aux = 0;
		
		for (int i=0;i<this.dimension;i++)
			aux += this.componentes[i]*vec.componentes[i];
		
		return aux;
	}
	
	public VectorMath producto(MatrizMath matriz){
		
		VectorMath resultado=new VectorMath(this.dimension);
		try {
			
			if (this.dimension != matriz.getDimensionFil())
				throw new DistDimException(" Distinta Dimension ");
			
			for(int i=0; i<dimension; i++)
				for (int j = 0; j < matriz.getDimensionCol(); j++) {
					resultado.componentes[i] += this.componentes[j]*matriz.getComponentes()[j][i];
				}
			
		    } catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	
	public double normaUno(){
		
		double aux = 0;
		
		for (double valor: this.getComponentes())
			aux += Math.abs(valor);

		return aux;
	}
	
	public double normaDos(){
		
		double aux = 0;
		
		for (double valor: this.getComponentes())
			aux += Math.pow(valor, 2);

		return Math.sqrt(aux);
	}
	
	public double normaInfinito(){
		
		double max = Math.abs(this.getComponentes()[0]);
		
		for (double valor: this.getComponentes())
			if (max<Math.abs(valor))
				max=Math.abs(valor);

		return max;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(componentes);
		result = prime * result + dimension;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VectorMath other = (VectorMath) obj;
		if (!Arrays.equals(componentes, other.componentes))
			return false;
		if (dimension != other.dimension)
			return false;
		return true;
	}

	
	@Override
	public String toString(){
		String resultado="";
		
		resultado+="Dimension:"+this.getDimension()+"\n";
		resultado+="( ";
		for (int i = 0; i < this.getComponentes().length; i++) {
			resultado += this.getComponentes()[i]+" ";
			
		}
		resultado+=")";
		return resultado;
	}
	
	public VectorMath clone(){
		VectorMath clon = new VectorMath(this.getDimension());
		clon.setComponentes(this.getComponentes());
		
		return clon;
	}


}
