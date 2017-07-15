package vehiculo;

public class Motocicleta extends Vehiculo {
	private Persona acompanante;
	
	public Motocicleta (){
		super();
	}
	
	public void asignarAcompanante(Persona acom)
	{
		this.acompanante=acom;
	}

	public Persona getAcompanante() {
		return acompanante;
	}

	public void setAcompanante(Persona acompanante) {
		this.acompanante = acompanante;
	}
}
