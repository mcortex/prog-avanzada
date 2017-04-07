package ar.edu.unlam.complejo;

public class Test {

	public static void main(String[] args) {
		Complejo z1 = new Complejo(1,2);
		Complejo z2 = new Complejo(2,3);
		Complejo z3 = z1.suma(z2);
		System.out.println(z3); // Llama a toString()
		
		Complejo z4 = z3.resta(z2);
		if(z4.equals(z1))
			System.out.println("z4 es igual a z1!");
		else
			System.out.println("no son iguales");
		Complejo z5 = z4.producto(z3);
		System.out.println(z5);
		
		Complejo z6 = z5.clone();
		System.out.println("z6: "+z6+"\nModulo de z6: "+z6.modulo());
		
		Complejo z7 = z1.producto(z1.conjugado()); //z*conj(z)
		System.out.println(z7);
		if ((z1.modulo() == Math.sqrt(z7.getReal())) && z7.getImag() == 0 ){
			System.out.println("Son modulo");
		}
		
	}
}
