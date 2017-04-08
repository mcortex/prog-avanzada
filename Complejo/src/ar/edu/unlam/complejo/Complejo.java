package ar.edu.unlam.complejo;

public class Complejo implements Comparable<Complejo> {
	private double real;
	private double imag;
	
	public Complejo(){
		this(0,0);
	}
	
	public Complejo(double real, double imag){
		this.real=real;
		this.imag=imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public String toString(){
		return "Complejo: ["+real+","+imag+"i]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imag);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Complejo other = (Complejo) obj;
		if (Double.doubleToLongBits(imag) != Double.doubleToLongBits(other.imag))
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
			return false;
		return true;
	}

	public Complejo clone(){
		return (new Complejo(this.real,this.imag));
	}
	
	public Complejo suma(Complejo comp){
		return (new Complejo(this.real+comp.real,this.imag+comp.imag));
	}
	
	public Complejo suma(double numero){
		return (new Complejo(this.real+numero,this.imag));
	}
	
	public Complejo resta(Complejo comp){
		return (new Complejo(this.real-comp.real,this.imag-comp.imag));
	}
	
	public Complejo resta(double numero){
		return (new Complejo(this.real-numero,this.imag));
	}
	
	public Complejo producto(Complejo comp){
		return (new Complejo((this.real*comp.real-this.imag*comp.imag),(this.real*comp.imag+comp.real*this.imag)));
	}
	
	public Complejo producto(double numero){
		return (new Complejo((this.real*numero),(this.imag*numero)));
	}
	
	public double modulo(){
		return (Math.sqrt(this.real*this.real+this.imag*this.imag));
	}
	
	public Complejo conjugado(){
		return (new Complejo(this.real,(this.imag*(-1))));
	}

	@Override
	public int compareTo(Complejo o) {
		return 0;
	}
	
//	public int compareTo(Complejo c){
//		return 0;
//		
//	}
	
}
