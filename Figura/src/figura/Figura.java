package figura;

public abstract class Figura
{
	protected Punto2D p1;
	
	public Figura(Punto2D p)
	{
		p1 = p.clone();
	}
	
	public Figura()
	{
		this(new Punto2D());
	}
	
	public abstract float area();
	public abstract float perimetro();
}
