package corredores;

public class Corredor {
	private int edad;
	private char sexo;
	private int categoria;
	private int posInicial;
	private int puesto;
	
	public Corredor(){
		
	}
	
	public Corredor(int edad, char sexo, int posInicial) {
		super();
		this.edad = edad;
		this.sexo = sexo;
		this.posInicial = posInicial;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getPosInicial() {
		return posInicial;
	}

	public void setPosInicial(int posInicial) {
		this.posInicial = posInicial;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}
	
	public Corredor obtenerCorredor(int posInicial) {
		return this;
	}
	
}
