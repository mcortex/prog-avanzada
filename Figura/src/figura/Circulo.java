package figura;

import static java.lang.Math.*;
import static java.lang.System.*;

public class Circulo extends Figura implements Dibujable
{
	private float radio;
	
	public Circulo(Punto2D p, float radio)
	{
		super(p);
		this.radio = radio;
	}
	
	public Circulo()
	{
		this(new Punto2D(), (float) 1.0);
	}
	
	public void dibujar()
	{
		//En cuanto se vea la biblioteca Graphics podremos terminar la implementación
	}

	public float area()
	{

		return (float) (PI * pow(radio, 2));
	}

	
	public float perimetro()
	{
		return (float) (2 * PI * radio);
	}
	
	public String toString()
	{
		return p1 + " radio: " + radio;
	}
	
	public static void main(String arg[])
	{
		Circulo c = new Circulo(new Punto2D(1, 3), (float) 4.5);
		out.println(c);
	}

}
