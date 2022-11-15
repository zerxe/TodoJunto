package todojunto.controller;

import todojunto.view.JFrameStudent;
import todojunto.model.Student;
import todojunto.model.dao.StudentDao;
import todojunto.view.StudentViewTable;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class StudentController  {

    private StudentDao studentdao;
    private JFrameStudent jfStudent;
    private Student student;
    private StudentListener studentListener;
    private StudentViewTable studentViewTable;

    public StudentController() {
        studentdao = new StudentDao();
        student = new Student();
        jfStudent = new JFrameStudent();
        studentdao.studentsQuery();
        
        
        studentViewTable = new StudentViewTable(studentdao);
        studentListener = new StudentListener(jfStudent,studentViewTable);
        
        
        jfStudent.getTablaAlumnos().setModel(studentViewTable);
        jfStudent.getTxtRegistro().setEditable(false);

        jfStudent.setVisible(true);
        
    }

}
