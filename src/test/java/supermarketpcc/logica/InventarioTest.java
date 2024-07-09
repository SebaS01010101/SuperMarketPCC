package supermarketpcc.logica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarioTest {
    Inventario inventario = new Inventario();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buscarProductoPorNombre() {
        String esperado = "chocman";
        Producto producto = inventario.buscarProductoPorNombre("chocman");
        assertEquals(esperado, producto.getNombre());
    }

    @Test
    void buscarProductoPorCodigoBarra() {
    }

    @Test
    void buscarProductoId() {
    }
}