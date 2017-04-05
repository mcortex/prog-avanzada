package ar.edu.unlam.punto2d;

public class Test {

	public static void main(String[] args) {
		Punto2D p = new Punto2D();
		Punto2D p1 = new Punto2D(3,4);
		Punto2D p2 = new Punto2D(4,3);
		Punto2D sumapuntos = p1.suma(p2);
		System.out.println(p);
		System.out.println(sumapuntos);
		
		Punto2D p3 = new Punto2D(7,7);
		if (p3.equals(sumapuntos))
		{System.out.println("Son iguales");
		}
		else
			System.out.println("No son iguales");

	}

}
