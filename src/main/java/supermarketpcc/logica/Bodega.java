package supermarketpcc.logica;

import Servlet.SvProducto;

import java.util.ArrayList;
import java.util.List;

public class Bodega extends Inventario implements Organizador {

    List<Producto> productos;
    SvProducto svProducto = new SvProducto();

    public Bodega( String nombre) {
        super( nombre);
        this.productos = new ArrayList<>();
    }

    @Override
    public void ordenar() {

    }

    public int stockProducto(String codigoBarras) {
        int stock = 0;
        for (Producto producto : productos) {
            if (producto.getCodigoBarras().equals(codigoBarras)) {
                stock++;
            }
        }
        return stock;

    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}