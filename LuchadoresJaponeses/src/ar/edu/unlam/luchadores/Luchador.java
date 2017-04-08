package ar.edu.unlam.luchadores;

public class Luchador {
	private double peso;
	private double altura;
	
	public Luchador(){
		
	}
	
	public Luchador(double peso, double altura){
		this.peso=peso;
		this.altura=altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Luchador [peso=" + peso + ", altura=" + altura + ", toString()=" + super.toString() + "]";
	}
	
	public boolean domina(Luchador contrincante){
		if((this.getPeso() > contrincante.getPeso() && this.getAltura() > contrincante.getAltura()) || (this.getPeso() > contrincante.getPeso() && this.getAltura() == contrincante.getAltura()) || (this.getPeso() == contrincante.getPeso() && this.getAltura() > contrincante.getAltura()))
			return true;
		else
			return false;
	}
	
	
}
