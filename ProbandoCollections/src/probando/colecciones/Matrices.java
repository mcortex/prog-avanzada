package probando.colecciones;
import ar.edu.unlam.sel.MatrizMath;

public class Matrices {
	
	public static void main(String[] args) {
		
		MatrizMath matriz = new MatrizMath(4,4);
		double[][] comp = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		double[][] aux = new double[matriz.getDimensionFil()][matriz.getDimensionCol()];
		
		System.out.println("Oeste");
		matriz.setComponentes(comp);
		System.out.println(matriz.toString());
		
		System.out.println("Sur");
		for (int i=0; i < matriz.getDimensionFil(); i++) {
			for (int j=0; j < matriz.getDimensionCol(); j++) {
				aux[i][j] = matriz.getComponentes()[j][i];
			}
		}
		
		MatrizMath sur = new MatrizMath(4,4);
		sur.setComponentes(aux);
		
		System.out.println(sur.toString());
		
		
		System.out.println("Norte");
		double[][] aux2 = new double[matriz.getDimensionFil()][matriz.getDimensionCol()];
		
		for (int i=0; i<matriz.getDimensionFil(); i++) {
			int k=0;
			for (int j = matriz.getDimensionCol()-1; j >=0 ; j=j-1) {
				aux2[i][k] = matriz.getComponentes()[j][i];
				k++;
			}
		}
		
		MatrizMath nor  = new MatrizMath(4,4);
		nor.setComponentes(aux2);
		
		System.out.println(nor.toString());
		

		System.out.println("Este");
		double[][] aux3 = new double[matriz.getDimensionFil()][matriz.getDimensionCol()];
		
		for (int i=0; i < matriz.getDimensionFil(); i++) {
			int k=0;
			for (int j = matriz.getDimensionFil()-1; j >=0 ; j--) {
				aux3[i][k] = matriz.getComponentes()[i][j];
				k++;
			}
		}
		
		MatrizMath est  = new MatrizMath(4,4);
		est.setComponentes(aux3);
		
		System.out.println(est.toString());
		
	}
	
	

}
