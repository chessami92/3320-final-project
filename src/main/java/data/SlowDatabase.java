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
    public boolean addStudent(Student student) {
        student.setId(students.size());
        students.add(student);
        return true;
    }

    @Override
    public Student getById(int id) {
        if (id > students.size() - 1 && id >= 0) {
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

        for (int major : student.getMajors()) {
            int numberBetter = 0;
            for (Student otherStudent : students) {
                if (student.getGrade() > otherStudent.getGrade()) {
                    ++numberBetter;
                }
            }
            percentiles[major] = (double) numberBetter / students.size();
        }

        return percentiles;
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
}
