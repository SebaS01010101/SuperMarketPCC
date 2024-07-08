package Servlet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supermarketpcc.logica.Producto;

import static org.junit.jupiter.api.Assertions.*;

class SvProductoTest {

    @BeforeEach
    void setUp() {
        Producto p1 = new Producto(1, "nombre", "codigoBarras", 1.0) {
            @Override
            public void mostrar() {

            }
        };
        SvProducto serv = new SvProducto();
    }

    @Test
    void agregarProducto() {
    }

    @Test
    void obtenerProductos() {

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