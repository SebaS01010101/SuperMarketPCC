package supermarketpcc.logica;

import Servlet.SvProducto;

import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;


public class Inventario implements Mostrar, Serializable {

    List<Producto> productos;

    private String nombre;
    private transient Connection connection;
    private HashMap<String, Estante> estantes;
    private transient SvProducto svProducto;


    public Inventario(String nombre) {
        this.connection = new ConexionSQL().conexionBD();
        this.nombre = nombre;
        this.estantes = new HashMap<>();
        this.svProducto = new SvProducto();
        this.productos = svProducto.obtenerProductos();
    }




    public void agregarEstante(String tipo, Estante estante) {
        estantes.put(tipo, estante);
    }

    public Estante obtenerEstante(String tipo) {
        return estantes.get(tipo);
    }

    public void mostrarProductosEnEstantes() {
        estantes.forEach((tipo, estante) -> {
            Collection<Producto> productosEnEstante = productos.stream()
                    .filter(producto -> producto.getClass().getSimpleName().equals(tipo))
                    .collect(Collectors.toList());
            estante.mostrarProductos(productosEnEstante);
        });
    }

    //intento para jsp seba
    public List<Producto> obtenerProductos(String tipoEstante) {
        Estante estante = obtenerEstante(tipoEstante);
        if (estante != null) {
            return estante.getProductos();
        } else {
            return new ArrayList<>();
        }

    }

    public void listarProductos() {

    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getNombre() {
        return nombre;
    }

    public Connection getConnection() {
        return connection;
    }

    public HashMap<String, Estante> getEstantes() {
        return estantes;
    }

    public SvProducto getSvProducto() {
        return svProducto;
    }

    @Override
    public void mostrar() {

    }

    @Override
    public String toString() {
        return "Inventario{" +
                ", nombre='" + nombre + '\'' +
                ", estantes=" + estantes +
                '}';
    }
}