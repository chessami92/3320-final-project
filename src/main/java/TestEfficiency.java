import data.Student;
import data.StudentDatabase;

import java.util.ArrayList;

/**
 * Created by: Josh
 * On: 4/25/13 10:33 PM
 */
public class TestEfficiency {

    /*
     * Main program for testing the efficiency of both solutions
     */
    private static void main(String[] args) {
        Statistics inefficient = testLinearAlgorithm();
        Statistics efficient = testEfficientAlgorithm();
        //Display results below
    }

    /*
     * Method to test the inefficient algorithm that simply uses an arraylist and linear searches.
     * Returns a statistics object containing the times it took to perform various operations.
     */
    private static Statistics testLinearAlgorithm() {
        Statistics statistics = new Statistics();

        ArrayList<Student> students = new ArrayList<Student>();
        students.ensureCapacity(10000); //Make sure array is resized seldom.

        return statistics;
    }

    /*
     * Method to test the efficient algorithm that uses several data structures for efficient retrieval.
     * Returns a statistics object containing the times it took to perform various operations.
     */
    private static Statistics testEfficientAlgorithm() {
        Statistics statistics = new Statistics();

        StudentDatabase studentDatabase = new StudentDatabase();

        return statistics;
    }
}
