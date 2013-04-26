package data;

import java.util.ArrayList;

/**
 * Created by: Josh
 * On: 4/25/13 10:49 PM
 */
public class StudentDatabase {
    ArrayList<Student> students;

    public StudentDatabase() {
        students = new ArrayList<Student>();
        students.ensureCapacity(10000);
        //TODO: create the rest of the data structures required.
    }
}
