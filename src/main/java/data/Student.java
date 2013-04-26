package data;

/**
 * Created by: Josh
 * On: 4/25/13 2:45 PM
 */
public class Student {
    private int studentId;
    private String name;
    private double grade;
    private int[] majors;

    Student(int studentId, String name, double grade, int[] majors) {
        this.studentId = studentId;
        this.name = name;
        if (grade > 100)
            this.grade = 100;
        else if(grade < 0 )
            this.grade = 0;
        else
            this.grade = grade;
        this.majors = majors;
    }
}
