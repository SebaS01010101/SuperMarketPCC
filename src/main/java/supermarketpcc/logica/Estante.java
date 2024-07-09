package supermarketpcc.logica;

import java.io.Serializable;
import java.util.*;


public class Estante extends Inventario implements Organizador{

    private static final long serialVersionUID = 1L;

    private String tipo;
    private double volumenMax;
    private double volumenActual;
    private List<Producto> productosEstante;

    public Estante( String nombre, String tipo, double volumenMax) {
        super(nombre);
        this.tipo = tipo;
        this.volumenMax = volumenMax;
        this.volumenActual = 0;
        this.productosEstante = new ArrayList<>();

    }

    public boolean puedeAgregarProducto(Producto producto) {
        return volumenActual + producto.getVolumen() <= volumenMax;
    }

    public void agregarProducto(Producto producto) {
        if (puedeAgregarProducto(producto)) {
            volumenActual += producto.getVolumen();
            productosEstante.add(producto);
            System.out.println("Producto agregado al estante de " + tipo);
        } else {
            System.out.println("No hay suficiente espacio en el estante de " + tipo);
        }
    }

    public void mostrarProductos(Collection<Producto> productos) {
        System.out.println("Estante: " + tipo + " (Volumen máximo: " + volumenMax + ", Volumen actual: " + volumenActual + ")");
        productos.forEach(producto -> System.out.println(" - " + producto.getNombre() + " (Volumen: " + producto.getVolumen() + ")"));
    }

    //intento para jsp seba

    public List<Producto> getProductos() {
        return productosEstante;
    }


    public void eliminarProductoEstante() {

        throw new UnsupportedOperationException();
    }

    public void agregarEstante() {

        throw new UnsupportedOperationException();

    }

    public String getTipo() {
        return tipo;
    }

    public double getVolumenMax() {
        return volumenMax;
    }

    public double getVolumenActual() {
        return volumenActual;
    }

    @Override
    public String toString() {
        return "Estante{" +
                (super.toString()) +
                "productos = " + productosEstante +
                "volumenActual=" + volumenActual +
                ", tipo='" + tipo + '\'' +
                ", volumenMax=" + volumenMax +
                '}';
    }

    @Override
    public void ordenar() {
        throw new UnsupportedOperationException();

    }
}