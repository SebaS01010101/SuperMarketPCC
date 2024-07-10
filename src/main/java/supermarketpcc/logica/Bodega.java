package supermarketpcc.logica;

import java.io.Serializable;
import java.util.*;

public class Bodega extends Inventario implements Organizador, Serializable {

    private static final long serialVersionUID = 1L;

    private List<Producto> productos;

    public Bodega(String nombre) {
        super(nombre);
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "productos=" + productos +
                '}';
    }

    @Override
    public void ordenar() {
        productos.sort(Comparator.comparing(Producto::getNombre));
    }


}