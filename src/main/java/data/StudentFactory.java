package data;

import java.util.Random;

/**
 * Created by: Josh
 * On: 4/25/13 2:56 PM
 */
public class StudentFactory {
    private static final Random random = new Random();
    private static final Major[] possibleMajors = Major.values();

    public static Student generateStudents(int currentStudent) {
        final String name = generateName() + " " + generateName();
        final double grade = random.nextDouble() * 100;
        final int[] majors = generateMajors();

        return new Student(currentStudent, name, grade, majors);
    }

    /*
     * Create a name with random letters. The first letter will be upper case.
     */
    public static String generateName() {
        final int characters = random.nextInt(4) + 4;
        final char[] name = new char[characters];

        for (int i = 0; i < name.length; ++i) {
            //Generate a lower case character.
            name[i] = (char) (random.nextInt(26) + 97);
        }

        name[0] -= 32; //Convert first character to upper case

        return new String(name);
    }

    /*
     * Generates an int list representing majors.
     */
    public static int[] generateMajors() {
        //A number 0 to 1 - a probability for how many majors are generated.
        final double probabilityMajors = random.nextDouble();

        //How many majors the person will have. 85% chance of 1, 10% chance of 2, 5% chance of 3.
        final int numberMajors;

        if (probabilityMajors <= 0.85) {
            numberMajors = 1;
        } else if (probabilityMajors <= 0.95) {
            numberMajors = 2;
        } else {
            numberMajors = 3;
        }

        final int[] majors = new int[numberMajors];

        for (int i = 0; i < majors.length; ++i) {
            //Make sure to not assign the person "all majors"
            majors[i] = random.nextInt(possibleMajors.length - 1) + 1;
        }

        return majors;
    }
}
