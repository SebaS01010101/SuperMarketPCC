package supermarketpcc.logica;

public class Alimento extends Producto {


    public Alimento() {
    }

    public Alimento(int id, String nombre, String codigoBarras, Double volumen) {
        super(id, nombre, codigoBarras, volumen);
    }

    @Override
    public void mostrar() {
        
    }

    @Override
    public String toString() {
        return super.toString();
    }
}