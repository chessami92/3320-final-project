package data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by: Josh
 * On: 5/2/13 10:46 PM
 */
public class SlowDatabaseTest {
    private StudentDatabase slowDatabase;

    @BeforeMethod
    public void setup() {
        slowDatabase = new SlowDatabase();

        for (int i = 0; i < 10; ++i) {
            slowDatabase.addStudent(StudentFactory.generateStudent());
            System.out.println(slowDatabase.getById(i));
        }
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println(slowDatabase.getById(5));
    }

    @Test
    public void testGetPercentilesById() throws Exception {
        Major[] majors = Major.values();
        double[] percentiles = slowDatabase.getPercentilesById(0);
        for (int i = 0; i < percentiles.length; ++i) {
            if (percentiles[i] != 0) {
                System.out.printf("%s: %5.2f\n", majors[i].getDescription(), percentiles[i]);
            }
        }
    }

    @Test
    public void testGetHighestGrades() throws Exception {
        System.out.println("Highest scorers");

        Major[] majors = Major.values();
        Student[] students = slowDatabase.getHighestAchievers();
        for(int i = 0; i < students.length; ++i) {
            System.out.printf("%-25s|%s\n", majors[i].getDescription(), students[i]);
        }
    }
}
