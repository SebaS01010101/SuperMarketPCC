package supermarketpcc.logica;

import Servlet.SvProducto;

import java.io.Serializable;
import java.sql.*;
import java.util.*;


public class Inventario implements Mostrar, Serializable {

    private List<Producto> productos;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public String getNombre() {
        return nombre;
    }


    public HashMap<String, Estante> getEstantes() {
        return estantes;
    }

    @Override
    public void mostrar() {

    }

    @Override
    public String toString() {
        return "Inventario{" +
                "nombre='" + nombre + '\'' +
                ", productos=" + productos +
                '}';
    }
}