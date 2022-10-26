package todojunto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import todojunto.FrmPrincipal;
import todojunto.model.Student;
import todojunto.model.dao.StudentDao;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class StudentController implements ActionListener {

    private StudentDao studentdao;
    private FrmPrincipal frmmenu;
    private Student student;

    public StudentController() {
        studentdao = new StudentDao();
        student = new Student();
        frmmenu = new FrmPrincipal();
        frmmenu.getTxtRegistro().setEditable(false);

        buttonsActionListener();

        frmmenu.setVisible(true);

    }

    private void modificaciones() {

        //modeloalumno.modificaciones(alumno);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Altas":
                break;
            case "Modificar":
                studentdao.updateStudent(student());
                break;
            case "Bajas":
                studentdao.deleteStudent(student());
                break;
            case "Salir":
                System.exit(0);
                break;
            case "Limpiar":
                clearForm();
            default:

        }
        frmmenu.updateView();
    }

    public Student student() {
        student.setRegistro(Integer.parseInt(frmmenu.getTxtRegistro().getText()));
        student.setDni(frmmenu.getTxtDni().getText());
        student.setNombre(frmmenu.getTxtNombre().getText());
        student.setApellido1(frmmenu.getTxtApellido1().getText());
        student.setApellido2(frmmenu.getTxtApellido2().getText());
        return student;
    }

    public void buttonsActionListener() {
        frmmenu.getBtnAltas().addActionListener(this);
        frmmenu.getBtnModificaciones().addActionListener(this);
        frmmenu.getBtnBajas().addActionListener(this);
        frmmenu.getBtnSalir().addActionListener(this);
        frmmenu.getBtnClear().addActionListener(this);
    }

    public void clearForm() {
        frmmenu.getTxtRegistro().setText("");
        frmmenu.getTxtDni().setText("");
        frmmenu.getTxtNombre().setText("");
        frmmenu.getTxtApellido1().setText("");
        frmmenu.getTxtApellido2().setText("");
    }
}
