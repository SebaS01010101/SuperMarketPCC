package supermarketpcc.logica;

public class NoAlimento extends Producto {

    private String descripcion;

    public NoAlimento(int id, String nombre, String codigoBarras, Double volumen, String descripcion) {
        super(id, nombre, codigoBarras, volumen);
        this.descripcion = descripcion;
    }



    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "NoAlimento{" + (super.toString()) +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}