package duelo;

public class Colt extends Arma{
	
	public Colt(){
		this.cargador=6;
		this.cantTiros=this.cargador;
		this.danio=2;
		this.alcance=10;
		this.durabilidad=10;
		this.tipoArma="Colt";
	}
	
	public boolean tiro(){
		if(this.armaRota() || this.getCantTiros()==0)
			return false;
		this.setCantTiros(this.getCantTiros()-1);
		return true;
		
	}

}
