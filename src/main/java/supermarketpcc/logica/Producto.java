package supermarketpcc.logica;

public abstract class Producto implements Mostrar {

	private int id;
	private String nombre;
	private String codigoBarras;
	private Double volumen;

	public Producto() {
	}

	public Producto(int id, String nombre, String codigoBarras, Double volumen) {
		this.id = id;
		this.nombre = nombre;
		this.codigoBarras = codigoBarras;
		this.volumen = volumen;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public Double getVolumen() {
		return volumen;
	}
}