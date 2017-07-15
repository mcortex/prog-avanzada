package duelo;

public class Personaje {
	protected int salud;
	protected String nombre;
	protected String tipoPersonaje;
	protected Arma arma;
	protected int posX;
	protected int posY;

	public Personaje(){}
	
	public Personaje(String nombre,Arma arma,int posX,int posY){
		this.nombre=nombre;
		this.arma=arma;
		this.posX=posX;
		this.posX=posY;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoPersonaje() {
		return tipoPersonaje;
	}

	public void setTipoPersonaje(String tipoPersonaje) {
		this.tipoPersonaje = tipoPersonaje;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	public boolean estaVivo(){
		return this.getSalud() > 0;
	}

	public boolean dispara(Personaje atacado){
				
		//el disparo salio?
		if(!this.getArma().tiro())
			return false;
		
		double distancia = Math.sqrt(Math.pow((this.getPosX() - atacado.getPosX()),2)+Math.pow((this.getPosY() - atacado.getPosY()),2));
		
		// disparo al tipo 
		if (this.getArma().getAlcance() > distancia)
			atacado.setSalud(atacado.getSalud()-this.getArma().danio);
		
		//decremento bala
		return true;
	}
	
	public void recarga(){
		if (this.tengoArma())
			this.getArma().setCantTiros(this.getArma().getCargador());
	}

	public boolean tengoArma(){
		return (!this.getArma().armaRota());		
	}
	
	public void duelo(Personaje atacado){
		int cantidadRecargas=0;
		
		if (!this.dispara(atacado)){
			this.recarga();
			cantidadRecargas++;
			if (!(this.getArma() instanceof Winchester))
				this.dispara(atacado);
		}
		
		if (cantidadRecargas>=1)
			this.getArma().setDurabilidad(this.getArma().getDurabilidad()-1);
		
	}

}
