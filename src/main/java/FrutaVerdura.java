import java.util.Date;

public class FrutaVerdura extends Alimento {

	private Date fechaIngreso;
	private Date fechaCaducidad;

	public FrutaVerdura() {
	}

	public FrutaVerdura(int id, String nombre, String codigoBarras, Double volumen, Date fechaIngreso, Date fechaCaducidad) {
		super(id, nombre, codigoBarras, volumen);
		this.fechaIngreso = fechaIngreso;
		this.fechaCaducidad = fechaCaducidad;
	}

	public Date calcularCaducidad(Date fechaIngreso) {
		// TODO - implement FrutaVerdura.calcularCaducidad
		throw new UnsupportedOperationException();
	}

}