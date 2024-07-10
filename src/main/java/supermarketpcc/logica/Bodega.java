package supermarketpcc.logica;

import java.util.*;

public class Bodega extends Inventario implements Organizador {

    private List<Producto> productos ;
    private Map<String, Integer> stock;
    public Bodega( String nombre) {
        super(nombre);
       this.productos = new ArrayList<>();
        this.stock = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        Integer count = stock.getOrDefault(producto.getNombre(), 0);
        if (count == 0) {
            productos.add(producto);
        }
        stock.put(producto.getNombre(), count + 1);
    }

    public int stockProducto(String nombreProducto) {
        return stock.getOrDefault(nombreProducto, 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bodega{productos=");
        for (Producto p : productos) {
            sb.append(p.getNombre()).append(": ").append(stockProducto(p.getNombre())).append(", ");
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void ordenar() {
        productos.sort(Comparator.comparing(Producto::getNombre));
    }


}