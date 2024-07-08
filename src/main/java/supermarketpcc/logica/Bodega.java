package supermarketpcc.logica;

public class Bodega extends Inventario implements Organizador {

    public Bodega(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void ordenar() {

    }
}