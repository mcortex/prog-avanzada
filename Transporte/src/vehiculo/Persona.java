package vehiculo;

public class Persona {
	public String nombre;
	public String apellido;

	public Persona(String nom, String ape){
		this.nombre=nom;
		this.apellido=ape;		
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}