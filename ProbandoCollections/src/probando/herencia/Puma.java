package probando.herencia;

public class Puma extends Felino {
	public Puma() {
		// la llamada a super() siempre esta implicita
		System.out.println("Puma");
	}
	
//	public static void main(String[] args) {
//		new Puma().go();
//	}

	private void go() {
		System.out.println(this.tipo+" "+super.tipo);
		this.tipo="P";
		System.out.println(this.tipo+" "+super.tipo);
		
	}

}
