package vehiculo;

public abstract class Vehiculo {
	protected Persona chofer;
	protected double kilometraje;
	
	public Vehiculo(){
		super();
	}

	public Persona getChofer() {
		return chofer;
	}

	public void setChofer(Persona chofer) {
		this.chofer = chofer;
	}

	public double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}
	
	public void cambiarChofer(Persona chofer){
		this.chofer=chofer;
	}
	
	public void asignarChofer(Persona chofer){
		this.chofer=chofer;
	}

}
