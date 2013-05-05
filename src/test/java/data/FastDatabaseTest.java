package data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by: Josh
 * On: 5/2/13 11:35 PM
 */
public class FastDatabaseTest {
    FastDatabase fastDatabase;

    @BeforeMethod
    public void setup() {
        fastDatabase = new FastDatabase();

        for(int i = 0; i< 20; ++i){
            fastDatabase.addStudent(StudentFactory.generateStudent());
            System.out.println(fastDatabase.getById(i));
        }
    }

    @Test
    public void testAddStudent() throws Exception {

    }

    @Test
    public void testGetById() throws Exception {

    }

    @Test
    public void testGetPercentilesById() throws Exception {
        double[] percentiles = fastDatabase.getPercentilesById(0);

        for(double percentile : percentiles) {
            if(percentile != 0) {
                System.out.printf("%s, ", percentile);
            }
        }
        System.out.println();
    }

    @Test
    public void testGetHigestGrades() throws Exception {
        Student[] students = fastDatabase.getHighestAchievers();

        System.out.println();
        for(Student student : students) {
            System.out.println(student);
        }
    }
}
