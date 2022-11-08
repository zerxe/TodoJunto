package todojunto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import todojunto.view.JFrameStudent;
import todojunto.model.dao.StudentDao;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class StudentListener implements ActionListener, MouseListener {
    
    private JFrameStudent jfStudent;
    private StudentDao studentDao;
    
    public StudentListener(JFrameStudent jfStudent) {
       this.jfStudent = jfStudent;
       studentDao = new StudentDao();
       ActionListener();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object control = e.getSource();
        if (control.equals(jfStudent.getBtnAltas()) ) {
           studentDao.insertStudent(studentDao.getStudentJFrame(jfStudent));
        }else if (control.equals(jfStudent.getBtnBajas())) {
            studentDao.deleteStudent(studentDao.getStudentJFrame(jfStudent));
        }else if (control.equals(jfStudent.getBtnModificaciones())) {
            studentDao.updateStudent(studentDao.getStudentJFrame(jfStudent));
        }else if (control.equals(jfStudent.getBtnClear())) {
            clearForm();
        }else if (control.equals(jfStudent.getBtnSalir())) {
            System.exit(0);
        }
        clearForm();
    }
    
    public void ActionListener() {
        jfStudent.getBtnAltas().addActionListener(this);
        jfStudent.getBtnModificaciones().addActionListener(this);
        jfStudent.getBtnBajas().addActionListener(this);
        jfStudent.getBtnSalir().addActionListener(this);
        jfStudent.getBtnClear().addActionListener(this);
        jfStudent.getTablaAlumnos().addMouseListener(this);
    }
    
    public void clearForm() {
        jfStudent.getTxtRegistro().setText("");
        jfStudent.getTxtDni().setText("");
        jfStudent.getTxtNombre().setText("");
        jfStudent.getTxtApellido1().setText("");
        jfStudent.getTxtApellido2().setText("");
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        Object control = e.getSource();
        if (control.equals(jfStudent.getTablaAlumnos())) {
            studentDao.getSelectecRowViewTable(jfStudent.getTablaAlumnos().getSelectedRow(),jfStudent);
        }
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
      
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }
    
}
