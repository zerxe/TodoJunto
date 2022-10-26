package todojunto.model.dao;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import todojunto.database.runQuerySql;
import todojunto.model.Student;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class StudentDao {
   
    private runQuerySql runQuery;
            
            
    public StudentDao() {
        runQuery = new runQuerySql();
    }
    
    public ResultSet getRecords(){
        return runQuery.getRs();
    }
    
    public void insertStudent (Student student){
        String sql= "INSERT INTO 'alumnos' ('registro','dni','nombre','apellido1','apellido2') VALUES (NULL, ";
    }
    
    public void updateStudent(Student student) {                                                  

          String sql = "update alumnos set dni='" + student.getDni() + "', nombre='" + student.getNombre() + "', "
        + "apellido1='" + student.getApellido1() + "', apellido2='" + student.getApellido2() + "' "
        + "where registro=" + student.getRegistro();
        if (runQuery.executeQueryUpdate(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Modificación Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }
    
    public void deleteStudent(Student student){
        
         String sql="delete from alumnos where registro=" + student.getRegistro();
     
     if (runQuery.executeQueryUpdate(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Baja Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }

    public void studentsQuery() {
        String sql = "select * from alumnos";
        runQuery.executeQuery(sql);
        //ResultSet rs = ejecutasql.getRs();
    }
    
}
