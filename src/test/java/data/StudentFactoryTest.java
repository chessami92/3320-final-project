package data;

import org.testng.annotations.Test;

/**
 * Created by: Josh
 * On: 4/25/13 8:52 PM
 */
public class StudentFactoryTest {
    @Test
    public void testGenerateStudents() throws Exception {
        for (int i = 0; i < 20; ++i) {
            Student student = StudentFactory.generateStudents();
            System.out.println(student);
        }
    }

    @Test
    public void testGenerateName() throws Exception {
        for (int i = 0; i < 20; ++i) {
            String name = StudentFactory.generateName();
            System.out.println(name);
            if (name.length() > 9 || name.length() < 4)
                throw new Exception("Name not the proper length");
        }
    }

    @Test
    public void testGenerateMajors() throws Exception {
        final Major[] possibleMajors = Major.values();

        for (int i = 0; i < 20; ++i) {
            int[] majors = StudentFactory.generateMajors();

            for (int major : majors) {
                System.out.println(possibleMajors[major].getDescription());
            }
        }
    }
}
