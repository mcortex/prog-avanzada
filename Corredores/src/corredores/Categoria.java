package corredores;

public class Categoria {
	private int idCategoria;
	private int topeMin;
	private int topeMax;

	public Categoria() {
		
	}
	
	public Categoria(int id, int tMin, int tMax) {
		this.idCategoria = id;
		this.topeMin = tMin;
		this.topeMax = tMax;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getTopeMin() {
		return topeMin;
	}

	public void setTopeMin(int topeMin) {
		this.topeMin = topeMin;
	}

	public int getTopeMax() {
		return topeMax;
	}

	public void setTopeMax(int topeMax) {
		this.topeMax = topeMax;
	}
	
	
}
