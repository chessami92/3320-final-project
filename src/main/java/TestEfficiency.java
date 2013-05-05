import data.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by: Josh
 * On: 4/25/13 10:33 PM
 */
public class TestEfficiency {
    private static final Scanner in = new Scanner(System.in);
    private static final StudentDatabase[] DATABASES = {new SlowDatabase(), new FastDatabase()};
    private static final String MENU = "************************\n"
            + "Main menu\n"
            + "0 - Get student by ID\n"
            + "1 - Find percentile by ID\n"
            + "2 - Find highest achievers\n"
            + "3 - Add new student\n"
            + "4 - Exit ";
    private static final String ID_PROMPT = "Enter the student's id: ";
    private static final String TIME_TOOK = "Fast database took %s nanoseconds, and slow database took %s nanoseconds.\n";
    private static final String FASTER = "Fast database was %.2f times faster than the slow database.\n";
    private static final String SLOWER = "Fast database was %.2f times slower than the slow database.\n";
    private static final String DOES_NOT_EXIST = "Student could not be found in the databse.";
    private static Map<String, Long> databaseTimes = new HashMap<String, Long>();

    /*
     * Main program for testing the efficiency of both solutions
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10000; ++i) {
            Student student = StudentFactory.generateStudent();
            for (StudentDatabase database : DATABASES) {
                database.addStudent(student);
            }
        }

        int input;
        do {
            System.out.print(MENU);
            input = in.nextInt();

            if (input == 0) {
                getById();
            } else if (input == 1) {
                getPercentileById();
            } else if (input == 2) {
                getHighestAchievers();
            } else if (input == 3) {
                addNewStudent();
            }
        }
        while (input != 4);
    }

    private static void getById() {
        int id = inputId();
        for (StudentDatabase database : DATABASES) {
            long startTime = System.nanoTime();
            System.out.println(database);

            Student student = database.getById(id);
            System.out.println(student == null ? DOES_NOT_EXIST : student);
            long timeTook = System.nanoTime() - startTime;
            databaseTimes.put(database.toString(), timeTook);
        }

        printTimesTook();
    }

    private static void getPercentileById() {
        int id = inputId();
        Major[] majors = Major.values();
        for (StudentDatabase database : DATABASES) {
            long startTime = System.nanoTime();
            System.out.println(database);

            double[] percentiles = database.getPercentilesById(id);
            if (percentiles == null) {
                System.out.println(DOES_NOT_EXIST);
            }
            for (int i = 0; i < percentiles.length; ++i) {
                if (percentiles[i] != -1) {
                    System.out.printf("%s: %5.2f\n", majors[i].getDescription(), percentiles[i]);
                }
            }
            long timeTook = System.nanoTime() - startTime;
            databaseTimes.put(database.toString(), timeTook);
        }

        printTimesTook();
    }

    private static int inputId() {
        System.out.print(ID_PROMPT);
        return in.nextInt();
    }

    private static void getHighestAchievers() {
        printTimesTook();
    }

    private static void addNewStudent() {
        Student student = StudentFactory.generateStudent();
        for (StudentDatabase database : DATABASES) {
            long startTime = System.nanoTime();

            System.out.println(database);
            System.out.println(database.addStudent(student));

            long timeTook = System.nanoTime() - startTime;
            databaseTimes.put(database.toString(), timeTook);
        }

        printTimesTook();
    }

    private static void printTimesTook() {
        long fastTime = databaseTimes.get("Fast Database");
        long slowTime = databaseTimes.get("Slow Database");
        System.out.printf(TIME_TOOK, fastTime, slowTime);

        if (fastTime < slowTime) {
            double timesFaster = ((double) slowTime) / fastTime;
            System.out.printf(FASTER, timesFaster);
        } else {
            double timesSlower = ((double) fastTime) / slowTime;
            System.out.printf(SLOWER, timesSlower);
        }
    }
}
