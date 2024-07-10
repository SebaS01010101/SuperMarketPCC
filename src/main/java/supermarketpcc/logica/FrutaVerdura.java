package supermarketpcc.logica;

import java.util.Date;

public class FrutaVerdura extends Alimento {

    private Date fechaIngreso;
    private Date fechaCaducidad;

    public FrutaVerdura(int id, String nombre, String codigoBarras, Double volumen, Date fechaIngreso, Date fechaCaducidad) {
        super(id, nombre, codigoBarras, volumen);
        this.fechaIngreso = fechaIngreso;
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    @Override
    public String toString() {
        return "FrutaVerdura{" + (super.toString()) +
                "fechaIngreso=" + fechaIngreso +
                ", fechaCaducidad=" + fechaCaducidad +
                '}';
    }
}