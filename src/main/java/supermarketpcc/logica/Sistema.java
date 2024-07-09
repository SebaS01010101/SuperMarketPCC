package supermarketpcc.logica;

import Servlet.SvProducto;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Sistema {

    private Inventario inventario;
    private transient SvProducto svProducto;
    private transient Connection connection;
    private List<Estante> estantes;
    private Bodega bodega;

    public Sistema() {
        this.inventario = new Inventario("Inventario Principal");
        this.svProducto = new SvProducto();
        this.connection = new ConexionSQL().conexionBD();
        this.estantes = new ArrayList<>();
        this.bodega = new Bodega("Bodega Principal");
    }


    public Producto buscarProductoPorId(int id) {
        List<Producto> productos = svProducto.obtenerProductos();

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        System.out.println("Producto con ID " + id + " no encontrado.");
        return null;
    }

    public void cargarProductosEnEstantes(int id, List<Estante> estantes) {
        Producto producto = buscarProductoPorId(id);

        if (producto != null) {
            Map<Class<? extends Producto>, String> tipoEstanteMap = new HashMap<>();
            tipoEstanteMap.put(Congelado.class, "Congelados");
            tipoEstanteMap.put(FrutaVerdura.class, "Frutas y Verduras");
            tipoEstanteMap.put(Bebestible.class, "Bebestibles");
            tipoEstanteMap.put(Alimento.class, "Alimento");
            tipoEstanteMap.put(NoAlimento.class, "No Alimento");

            String tipoEstante = tipoEstanteMap.get(producto.getClass());

            if (tipoEstante != null) {
                Estante estanteCorrespondiente = estantes.stream()
                        .filter(e -> e.getTipo().equals(tipoEstante))
                        .findFirst()
                        .orElse(null);

                if (estanteCorrespondiente != null) {
                    estanteCorrespondiente.agregarProducto(producto);
                    System.out.println("Producto agregado al estante de " + tipoEstante);
                } else {
                    System.out.println("Estante de tipo " + tipoEstante + " no existe.");
                }
            } else {
                System.out.println("Tipo de producto desconocido: " + producto.getNombre());
            }
        } else {
            System.out.println("Producto con ID " + id + " no encontrado.");
        }
    }


    //json metodos
    public void serializableEstantes() {
        try {
            FileOutputStream fileOut = new FileOutputStream("estantes.json");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(estantes);
            objectOut.close();
            System.out.println("Estantes serializados en estantes.json");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void serializableEstantes(List<Estante> estantesActualizados) {
        try {
            FileOutputStream fileOut = new FileOutputStream("estantes.json");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(estantesActualizados);
            objectOut.close();
            System.out.println("Estantes serializados en estantes.json");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Estante> deserializableEstantes() {
        try {
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("estantes.json"));
            estantes = (List<Estante>) objectIn.readObject();
            objectIn.close();
            System.out.println("Estantes deserializados de estantes.json");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estantes;
    }


    public void serializableBodega() {
        try {
            FileOutputStream fileOut = new FileOutputStream("bodega.json");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(bodega);
            objectOut.close();
            System.out.println("Bodega serializada en bodega.json");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void serializableBodega(Bodega bodegaActualizada) {
        try {
            FileOutputStream fileOut = new FileOutputStream("bodega.json");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(bodegaActualizada);
            objectOut.close();
            System.out.println("Bodega serializada en bodega.json");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Bodega deserializableBodega() {
        try {
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("bodega.json"));
            bodega = (Bodega) objectIn.readObject();
            objectIn.close();
            System.out.println("Bodega deserializada de bodega.json");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bodega;
    }


    public void cargarProductoBodega(int id) {
        Producto productoEnBodega = buscarProductoPorId(id);

        if (productoEnBodega != null) {
            bodega.agregarProducto(productoEnBodega);
            System.out.println("Producto agregado a la bodega");
        } else {
            System.out.println("Producto con ID " + id + " no encontrado.");
        }

    }

    public boolean ingresarUsuario(String imputUsuario, String inputContrasenia) {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM usuario WHERE usuario='" + imputUsuario + "' AND contrasenia='" + inputContrasenia + "' ";
            statement.executeQuery(sql);
            if (statement.getResultSet().next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void registrarUsuario(String inputNombre, String inputUsuario, String inputContrasenia, String inputRol) {
        try {
            PreparedStatement prepareStatement = null;
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO usuario(nombre, usuario, contrasenia, ID_rol) VALUES ('" + inputNombre + "','" + inputUsuario + "','" + inputContrasenia + "','" + inputRol + "')";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarDeEstante() {
        // en desarrollo
        new UnsupportedOperationException();
    }


}
