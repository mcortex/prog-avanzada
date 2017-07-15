package figura;

import static java.lang.Math.*;
import static java.lang.System.*;

public class Rectangulo extends Figura implements Rotable, Dibujable
{
	private Punto2D p2;
	
	public Rectangulo(Punto2D p1, Punto2D p2)
	{
		super(p1);
		this.p2 = p2.clone();
	}
	
	public Rectangulo()
	{
		this(new Punto2D(0, 0), new Punto2D(1, 1));
	}

	public void dibujar()
	{
		//En cuanto se vea la biblioteca Graphics podremos terminar la implementación
	}

	public void rotar()
	{
		//Se dejo a los alumnos la libre implementación
	}

	public float area()
	{
		return abs(p1.x - p2.x) * abs(p1.y - p2.y);
	}

	public float perimetro()
	{
		
		return (2 * abs(p1.x - p2.x)) + (2 * abs(p1.y - p2.y));
	}

	protected Object clone()
	{
		return new Rectangulo(p1, p2);
	}

	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Rectangulo aux = (Rectangulo) obj;
		if(!p1.equals(aux.p1) && !p2.equals(aux.p2)) 
			return false;
		return true;
	}

	public String toString()
	{
		return "p1 = (" + p1 + ") p2 = (" + p2 + ")";
	}
	
	public static void main(String arg[])
	{
		Rectangulo r = new Rectangulo(new Punto2D(1, 2), new Punto2D(4, 5));
		out.println(r);
	}

}
