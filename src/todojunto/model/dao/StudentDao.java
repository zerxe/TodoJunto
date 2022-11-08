package todojunto.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import todojunto.view.JFrameStudent;
import todojunto.database.runQuerySql;
import todojunto.model.Student;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class StudentDao {
   
    private runQuerySql runQuery;
    private ResultSet resultSet;
            
            
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

          String sql = "update alumnos set dni='" + student.getDni() + "', nombre='" + student.getName() + "', "
        + "apellido1='" + student.getSurname1() + "', apellido2='" + student.getSurname2() + "' "
        + "where registro=" + student.getID();
        if (runQuery.executeQueryUpdate(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Modificación Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }
    
    public void deleteStudent(Student student){
        
         String sql="delete from alumnos where registro=" + student.getID();
     
     if (runQuery.executeQueryUpdate(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Baja Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }

    public void studentsQuery() {
        String sql = "select * from alumnos";
        runQuery.executeQuery(sql);
        resultSet = runQuery.getRs();
    }
    
    public Student getStudentJFrame(JFrameStudent jfStudent){
        Student student = new Student();
        student.setID(Integer.parseInt(jfStudent.getTxtRegistro().getText()));
        student.setDni(jfStudent.getTxtDni().getText());
        student.setName(jfStudent.getTxtNombre().getText());
        student.setSurname1(jfStudent.getTxtApellido1().getText());
        student.setSurname2(jfStudent.getTxtApellido2().getText());
        return student;
    }
 

    public int getRowCount(){
       studentsQuery();
       
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
       
    }

    public int getColumnCount(){
        studentsQuery();
        try {
            resultSet.last();
            return resultSet.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }

    public Object getStudentViewTable(int rowIndex, int columnIndex) {
        studentsQuery();
        try {
            resultSet.absolute(rowIndex +1);
            Object o = resultSet.getObject(columnIndex+1);
            return o;
        } catch (SQLException ex) {
            return ex.toString();
        }
        
    }
    
    public void getSelectecRowViewTable(int fila,JFrameStudent jfs) {

        jfs.getTxtDni().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 1)));
        jfs.getTxtRegistro().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 0)));
        jfs.getTxtNombre().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 2)));
        jfs.getTxtApellido1().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 3)));
        jfs.getTxtApellido2().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 4)));

    }
    
}
