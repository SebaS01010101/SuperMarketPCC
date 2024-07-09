package supermarketpcc.logica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConexionSQLTest {
    ConexionSQL conexionSQL = new ConexionSQL();

    final static String host = "jdbc:mysql://localhost/supermercado_inventario";
    final static String user = "root";
    final static String password = "";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void conexionBD() {
        conexionSQL.conexionBD();
        assertNotNull(conexionSQL.getConnection());

    }

    @Test
    void cerrarConexion() {
    }
}