package figura;

public class Punto2D
{
	protected float x;
	protected float y;
	
	public Punto2D(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Punto2D()
	{
		this(0, 0);
	}

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto2D other = (Punto2D) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}
	
	public Punto2D clone()
	{
		return new Punto2D(x, y);
	}
	
	public String toString()
	{
		return "x: " + x + ", y: " + y;
	}
	
	
	
}
