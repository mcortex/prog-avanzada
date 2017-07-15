package vehiculo;

import java.util.ArrayList;

public class Autobus extends Vehiculo {
	private ArrayList<Persona> pasajeros;
	
	public Autobus(){
		super();
		pasajeros = new ArrayList <Persona>(); 
	}
	
	

	public ArrayList<Persona> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Persona pasajero) {
		this.pasajeros.add(pasajero);
	}



	public void cambiarChofer(Persona chofer){
		if (pasajeros.isEmpty())
			System.out.println("Imposible cambiar");
		else
			this.setChofer(chofer);
	}
}
