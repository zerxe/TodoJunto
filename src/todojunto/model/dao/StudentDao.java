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

    public ResultSet getRecords() {
        return runQuery.getRs();
    }

    public void insertStudent(Student student) {

        if (student != null) {
            if (checkStudent(student)) {
                String sql = "INSERT INTO `alumnos` (`registro`, `dni`, `nombre`, `apellido1`, `apellido2`) "
                        + "VALUES (NULL, '" + student.getDni() + "', '" + student.getName() + "', '" + student.getSurname1() + "', '" + student.getSurname2() + "');";
                if (runQuery.executeQueryUpdate(sql) > 0) {
                    JOptionPane.showMessageDialog(null, "Alta Correcta");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha Habido un Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El alumno con DNI: " + student.getDni() + " ya existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha habido un error en un campo del formulario");
        }
    }

    public void updateStudent(Student student) {
        if (student != null) {
            String sql = "update alumnos set dni='" + student.getDni() + "', nombre='" + student.getName() + "', "
                    + "apellido1='" + student.getSurname1() + "', apellido2='" + student.getSurname2() + "' "
                    + "where registro=" + student.getID();
            if (runQuery.executeQueryUpdate(sql) > 0) {
                JOptionPane.showMessageDialog(null, "Modificación Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Ha Habido un Error");
            }
        }
    }

    public void deleteStudent(Student student) {
        if (student != null) {
            String sql = "delete from alumnos where registro=" + student.getID();
            if (runQuery.executeQueryUpdate(sql) > 0) {
                JOptionPane.showMessageDialog(null, "Baja Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Ha Habido un Error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Alumno no seleccionado");
        }
    }

    public void studentsQuery() {
        String sql = "select * from alumnos";
        runQuery.executeQuery(sql);
        resultSet = runQuery.getRs();
    }

    public Student getStudentJFrame(JFrameStudent jfStudent) {
        if (validateJFStudentFields(jfStudent)) {
            Student student = new Student();
            try {
                student.setID(Integer.parseInt(jfStudent.getTxtRegistro().getText()));
            } catch (Exception e) {}
            student.setDni(jfStudent.getTxtDni().getText());
            student.setName(jfStudent.getTxtNombre().getText());
            student.setSurname1(jfStudent.getTxtApellido1().getText());
            student.setSurname2(jfStudent.getTxtApellido2().getText());
            return student;
        }
        return null;
    }

    public int getRowCount() {
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int getColumnCount() {
        try {
            resultSet.last();
            return resultSet.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public Student getStudent(int index) {
        Student student = new Student();
        try {
            resultSet.absolute(index);
            student.setID(resultSet.getInt(1));
            student.setDni(resultSet.getString(2));
            student.setName(resultSet.getString(3));
            student.setSurname1(resultSet.getString(4));
            student.setSurname2(resultSet.getString(5));
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    public void getSelectecRowViewTable(int fila, JFrameStudent jfs) {
        jfs.getTxtDni().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 1)));
        jfs.getTxtRegistro().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 0)));
        jfs.getTxtNombre().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 2)));
        jfs.getTxtApellido1().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 3)));
        jfs.getTxtApellido2().setText(String.valueOf(jfs.getTablaAlumnos().getValueAt(fila, 4)));
    }

    public boolean validateJFStudentFields(JFrameStudent jfStudent) {
        if (jfStudent.getTxtDni().getText().equals("")) {
            return false;
        } else if (jfStudent.getTxtNombre().getText().equals("")) {
            return false;
        } else if (jfStudent.getTxtApellido1().getText().equals("")) {
            return false;
        } else if (jfStudent.getTxtApellido2().getText().equals("")) {
            return false;
        }
        return true;
    }

    public boolean checkStudent(Student student) {
        String sql = "select * from alumnos WHERE dni ='" + student.getDni() + "'";
        runQuery.executeQuery(sql);
        try {
            if (runQuery.getRs().getRow() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
