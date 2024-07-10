package Servlet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supermarketpcc.logica.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvProductoTest {
    private static SvProducto svProducto;
    private static Connection connection;
    int id = 100;
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
        Producto producto = new Alimento(id,nombre, codigoBarras, volumen);

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
        assertTrue(esperado>0);


    }

    @Test
    void getCongelado() {
        try {
            assertNotNull(svProducto.getCongelado(4,"Helado Crunchy Raspberry", 0.1, "844529026"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getFrutaVerdura() {
        try {
            assertNotNull(svProducto.getFrutaVerdura(3,"Naranja Malla 1 Kg", 0.5, "7804673100"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getBebestible() {
        try {
            assertNotNull(svProducto.getBebestible(5,"Cerveza Royal Gold 6 Unidades 355Cc", 1.5, "7802100005"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getNoAlimento() {
        try {
            assertNotNull(svProducto.getNoAlimento(6,"Vanish Prelavado Ropa Color 400 Ml", 0.1, "7791130001"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

    @Test
    void eliminarPorID() {
        svProducto.eliminarPorID(id);
        assertNull(svProducto.productos.get(id));

    }

    @Test
    void eliminarTodoProducto() {
    }

    @Test
    void eliminarPorNombre() {
    }
}