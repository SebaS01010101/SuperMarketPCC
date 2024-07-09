package supermarketpcc.logica;

import java.util.ArrayList;
import java.util.List;

public class Bodega extends Inventario implements Organizador {

    List<Producto> productos;

    public Bodega( String nombre) {
        super( nombre);
        this.productos = new ArrayList<>();
    }

    @Override
    public void ordenar() {

    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}