package todojunto;

import todojunto.database.ConnectionDB;
import todojunto.controller.StudentController;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class TodoJunto {

    public static void main(String[] args) {
        ConnectionDB.openConnection();
        StudentController studentController = new StudentController();
    }
}
