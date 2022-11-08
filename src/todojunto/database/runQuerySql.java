package todojunto.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class runQuerySql {

    private ResultSet rs;
    
    public runQuerySql() {
    }

    public void executeQuery(String sql) {
        try {
            Statement stmt =ConnectionDB.getConn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {}
    }

    public int executeQueryUpdate(String sql) {
        int status;
        try {
            Statement stmt = ConnectionDB.getConn().createStatement();
            //JOptionPane.showMessageDialog(null, sql);
            status = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            status = 0;
        }
        return status;
    }

    public ResultSet getRs() {
        return rs;
    }

}
