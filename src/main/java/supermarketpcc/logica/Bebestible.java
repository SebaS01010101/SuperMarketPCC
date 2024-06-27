package supermarketpcc.logica;

public class Bebestible extends Alimento {

	private String tipo;

	public Bebestible() {
	}

	public Bebestible(int id, String nombre, String codigoBarras, Double volumen, String tipo) {
		super(id, nombre, codigoBarras, volumen);
		this.tipo = tipo;
	}
}