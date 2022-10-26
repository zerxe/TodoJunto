package todojunto.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class ConnectionDB {

    private static Connection conn;
    private static String jdbc = "jdbc:mysql://";
    private static String url ="localhost:3306";
    private static String database = "books";
    private static String user = "root";
    private static String password = "";
            
    public ConnectionDB() {
    }

    public static void openConnection() {
        try {
            conn = DriverManager.getConnection(jdbc+url+"/"+database, user,password);
          //  JOptionPane.showMessageDialog(null, "Conectado!!!!");
        } catch (SQLException ex) {
            conn = null;
            throw new RuntimeException("Error con la conexión!!!");
        }
    }

    public static Connection getConn() {
        return conn;
    }

}
