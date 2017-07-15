package probando.colecciones;

public class TiposPrimitivos {
	public static void main(String[] args) {
		Integer a=1; //a-> mem acceso rapido : -128...0...127
		Integer b=1; //b-> mem acceso rapido
		System.out.println(a==b); // true: misma posicion de memoria
		System.out.println(a.equals(b));
		
		Integer c=1000; //posicion de memoria de c
		Integer d=1000; //posicion de memoria de d
		System.out.println(c==d); //false: diferentes pos de mem
		System.out.println(c.equals(d)); // true valores iguales
	}

}
