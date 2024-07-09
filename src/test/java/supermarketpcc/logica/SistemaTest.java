package supermarketpcc.logica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaTest {
    Sistema sistema = new Sistema();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ingresarUsuario() {
        String user = "admin";
        String pass = "admin";
        assertTrue(sistema.ingresarUsuario(user, pass));
    }

    @Test
    void registrarUsuario() {
        String nonbre = "joses";
        String user = "josesito";
        String pass = "1234";
        String ID_tipo = "1";
        sistema.registrarUsuario(nonbre, user, pass, ID_tipo);
        assertTrue(sistema.ingresarUsuario(user, pass));
    }

    @Test
    void registrarProducto() {
    }

    @Test
    void eliminarProducto() {
    }
}