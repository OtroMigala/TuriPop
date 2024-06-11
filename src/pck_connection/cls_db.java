package pck_connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class cls_db {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO = "TURIPOP";
    private static final String CONTRASENA = "turipop"; // Ingresa la contraseña correspondiente

    /**
     * Establece una conexión a la base de datos.
     * @return La conexión establecida.
     */
    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    /**
     * Cierra la conexión a la base de datos.
     * @param conexion La conexión a cerrar.
     */
    public static void desconectar(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Desconexión exitosa de la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar de la base de datos: " + e.getMessage());
        }
    }
}