package supermarketpcc.logica;

public class NoAlimento extends Producto {
	private String descripcion;

	public NoAlimento(String descripcion) {
		this.descripcion = descripcion;
	}

	public NoAlimento() {
	}


	public NoAlimento(int id, String nombre, String codigoBarras, Double volumen, String descripcion) {
		super(id, nombre, codigoBarras, volumen);
		this.descripcion = descripcion;
	}

	@Override
	public void mostrar() {

	}

	@Override
	public String toString() {
		return "NoAlimento{" + (super.toString()) +
				"descripcion='" + descripcion + '\'' +
				'}';
	}
}