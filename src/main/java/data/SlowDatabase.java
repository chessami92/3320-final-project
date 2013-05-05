package data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by: Josh
 * On: 5/2/13 7:58 PM
 */
public class SlowDatabase implements StudentDatabase {
    private ArrayList<Student> students;

    public SlowDatabase() {
        students = new ArrayList<Student>();
        students.ensureCapacity(10000);
    }

    @Override
    public Student addStudent(Student student) {
        student.setId(students.size());
        students.add(student);
        return student;
    }

    @Override
    public Student getById(int id) {
        if (id > students.size() - 1 || id < 0) {
            return null;
        } else {
            return students.get(id);
        }
    }

    @Override
    public double[] getPercentilesById(int id) {
        //Retrieve the student.
        Student student = getById(id);
        if (student == null) {
            return null;
        }

        double[] percentiles = new double[Major.values().length];
        Arrays.fill(percentiles, -1);

        int[] majors = Arrays.copyOf(student.getMajors(), student.getMajors().length + 1);
        //Also check for the all majors category.
        majors[majors.length - 1] = 0;

        for (int major : majors) {
            int numberBetter = 0;
            int totalStudents = 0;
            for (Student otherStudent : students) {
                int[] otherStudentMajors = otherStudent.getMajors();
                if (hasMajor(otherStudentMajors, major)) {
                    ++totalStudents;
                    if (student.getGrade() > otherStudent.getGrade()) {
                        ++numberBetter;
                    }
                }
            }
            percentiles[major] = ((double) numberBetter) / totalStudents;
        }

        return percentiles;
    }

    private boolean hasMajor(int[] otherStudentMajors, int major) {
        //Always returns true for all majors.
        if (major == 0) {
            return true;
        } else {
            for (int checkMajor : otherStudentMajors) {
                if (checkMajor == major) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Student[] getHighestAchievers() {
        Student[] highestAchievers = new Student[Major.values().length];

        for (Student student : students) {
            int[] majors = student.getMajors();
            majors = Arrays.copyOf(majors, majors.length + 1);

            //Also calculate in the score for all majors.
            majors[majors.length - 1] = 0;

            for (int major : majors) {
                if (highestAchievers[major] == null) {
                    highestAchievers[major] = student;
                } else if (student.getGrade() > highestAchievers[major].getGrade()) {
                    highestAchievers[major] = student;
                }
            }
        }

        return highestAchievers;
    }

    @Override
    public String toString() {
        return "Slow Database";
    }
}
