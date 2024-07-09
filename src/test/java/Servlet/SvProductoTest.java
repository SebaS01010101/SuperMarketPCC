package Servlet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supermarketpcc.logica.*;
import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvProductoTest {
    private static SvProducto svProducto;
    private static Connection connection;

    String nombre = "Producto1";
    double volumen = 1.0;
    String codigoBarras = "12345";

    @BeforeAll
    static void setUp() {
        svProducto = new SvProducto();
        connection = new ConexionSQL().conexionBD();
    }

    @BeforeEach
    void set() {

    }

    @Test
    void agregarProducto() {
        int idEsperada=svProducto.agregarProducto(nombre, volumen, codigoBarras);
        svProducto.obtenerProductos();
        assertEquals(idEsperada, svProducto.productos.get(idEsperada).getId());

    }

    @Test
    void obtenerProductos() {
        svProducto.obtenerProductos();
        int esperado = svProducto.productos.size();
        assertEquals(esperado, svProducto.productos.size());


    }

    @Test
    void getCongelado() {
    }

    @Test
    void getFrutaVerdura() {
    }

    @Test
    void getBebestible() {
    }

    @Test
    void getNoAlimento() {
    }

    @Test
    void insertCongelado() {
    }

    @Test
    void insertFrutaVerdura() {
    }

    @Test
    void insertBebestible() {
    }

    @Test
    void insertAlimento() {
    }

    @Test
    void insertNoAlimento() {
    }
}