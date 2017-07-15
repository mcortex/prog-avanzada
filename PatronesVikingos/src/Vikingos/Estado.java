package Vikingos;

public interface Estado {
	public Estado calmarse();
	
	public Estado serAtacado(int salud);
	
	public String getEstado();

	public int atacar(int fuerza);

	public int getDefensa(int defenza);
	

}
