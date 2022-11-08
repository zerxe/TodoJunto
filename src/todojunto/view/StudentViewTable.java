package todojunto.view;

import javax.swing.table.AbstractTableModel;
import todojunto.model.Student;
import todojunto.model.dao.StudentDao;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class StudentViewTable extends AbstractTableModel {
    
    private StudentDao studentDao;
    private Student student;
    
    
    public StudentViewTable(StudentDao studentDao) {
        this.studentDao = studentDao;
        
    }

    @Override
    public int getRowCount() {
        return studentDao.getRowCount();
   }

    @Override
    public int getColumnCount() {
        return studentDao.getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return studentDao.getStudentViewTable(rowIndex , columnIndex);

    }
    
    
    
}
