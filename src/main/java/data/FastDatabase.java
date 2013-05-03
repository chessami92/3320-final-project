package data;

import java.util.ArrayList;

/**
 * Created by: Josh
 * On: 5/2/13 11:23 PM
 */
public class FastDatabase implements StudentDatabase {
    private ArrayList<Student> students;
    private ArrayList<Index>[] gradeIndex;

    public FastDatabase() {
        students = new ArrayList<Student>(10000);

        gradeIndex = new ArrayList[Major.values().length];
        for (int i = 0; i < gradeIndex.length; ++i) {
            gradeIndex[i] = new ArrayList<Index>(10000);
        }
    }

    @Override
    public boolean addStudent(Student student) {
        student.setId(students.size());
        students.add(student);
        //Add in the required indicies...
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
        return new double[0];
    }

    @Override
    public Student[] getHighestAchievers() {
        return new Student[0];
    }
}
