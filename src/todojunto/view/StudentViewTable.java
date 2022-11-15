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
        
        if (columnIndex == 0){
            student = studentDao.getStudent(rowIndex+1);
          
            return student.getID();
        }else if (columnIndex == 1) {
            return student.getDni();
        }else if (columnIndex == 2) {
            return student.getName();
        }else if (columnIndex == 3) {
            return student.getSurname1();
        }else if (columnIndex == 4) {
            return student.getSurname2();            
        }
        return null;
        
    }
    public void refresh(){
        studentDao.studentsQuery();
        fireTableDataChanged();
    }
    
    
    
}
