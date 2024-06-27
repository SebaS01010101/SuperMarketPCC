package supermarketpcc.logica;

public class Congelado extends Alimento {

	private int temperatura;

	public Congelado() {
	}

	public Congelado(int id, String nombre, String codigoBarras, Double volumen, int temperatura) {
		super(id, nombre, codigoBarras, volumen);
		this.temperatura = temperatura;
	}

}