package Servlet;

import org.junit.jupiter.api.*;
import supermarketpcc.logica.*;
import java.sql.Connection;
import java.sql.SQLException;
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

    @AfterAll
    static void afterAll() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
// getfrutaVerdura, getBebestible no funcionan al correr el test entero pero por separado si. Razon: No se sabe realmente no tiene logica.
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
            assertNotNull(svProducto.getBebestible(5,"Cerveza Royal Gold 6 Unidades 355Cc", 1, "7802100005"));
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
    void eliminarPorID() throws SQLException {
        int idEsperado = svProducto.agregarProducto(nombre, volumen, codigoBarras);
        assertTrue(svProducto.eliminarPorID(idEsperado));
    }

    @Test
    void eliminarTodoProducto() {
        svProducto.agregarProducto(nombre, volumen, codigoBarras);
        assertTrue(svProducto.eliminarTodoProducto(codigoBarras));
    }

    @Test
    void eliminarPorNombre() {
        svProducto.agregarProducto(nombre, volumen, codigoBarras);
        assertTrue(svProducto.eliminarPorNombre(nombre));
    }

}