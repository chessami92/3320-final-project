package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public Student addStudent(Student student) {
        int studentId = students.size();
        student.setId(studentId);
        students.add(student);

        //Add the student to the index corresponding to their majors.
        int[] majors = Arrays.copyOf(student.getMajors(), student.getMajors().length + 1);
        //Also add them to the all students level.
        majors[majors.length - 1] = 0;

        Index newStudentGrade = new Index(studentId, student.getGrade());
        for (int major : majors) {
            insertMajorGrade(gradeIndex[major], newStudentGrade);
        }
        return student;
    }

    /*
     * Adds in the element into the sorted array. Element 0 is the lowest grade.
     * Simply performs an insertion sort, knowing that everything but the last
     * element is sorted. "Pulls" the new element to it's proper location.
     */
    private void insertMajorGrade(List<Index> index, Index newStudentGrade) {
        index.add(newStudentGrade);

        for (int i = index.size() - 2; i >= 0; --i) {
            Index temp = index.get(i);
            if (temp.data > newStudentGrade.data) {
                index.set(i, newStudentGrade);
                index.set(i + 1, temp);
            } else {
                break;
            }
        }
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
        Student student = getById(id);
        if(student == null) {
            return null;
        }

        double[] percentiles = new double[Major.values().length];
        Arrays.fill(percentiles, -1);

        int[] majors = Arrays.copyOf(student.getMajors(), student.getMajors().length + 1);
        //Also check for the all majors category.
        majors[majors.length - 1] = 0;

        for (int major : majors) {
            percentiles[major] = getPercentileByMajor(major, student.getGrade());
        }

        return percentiles;
    }

    /*
     * Returns a percentile, given the major and the student's grade.
     * If the grade passed is not in that major's index, an illegal argument
     * exception is thrown.
     */
    private double getPercentileByMajor(int major, double grade) {
        int low = 0, middle, high = gradeIndex[major].size();

        while (high >= low) {
            middle = (low + high) / 2;
            if (gradeIndex[major].get(middle).data == grade) {
                middle = firstOccurrence(major, middle);
                return ((double) middle) / gradeIndex[major].size();
            }
            if (gradeIndex[major].get(middle).data < grade) {
                low = middle + 1;
            }
            if (gradeIndex[major].get(middle).data > grade) {
                high = middle - 1;
            }
        }

        throw new IllegalArgumentException("Could not find the grade - student must not exist in this major.");
    }

    /*
     * Once found the grade, make sure that the percentile is calculated based
     * on the first occurrence of this grade, case there are duplicates.
     */
    private int firstOccurrence(int major, int index) {
        int newIndex = index;

        while (newIndex != 0 && gradeIndex[major].get(newIndex - 1).data == gradeIndex[major].get(newIndex).data) {
            --newIndex;
        }

        return newIndex;
    }

    @Override
    public Student[] getHighestAchievers() {
        Student[] highestAchievers = new Student[Major.values().length];

        for (int i = 0; i < Major.values().length; ++i) {
            ArrayList<Index> gradesForMajor = gradeIndex[i];
            if (gradesForMajor.size() > 0) {
                int idForHightestInMajor = gradesForMajor.get(gradesForMajor.size() - 1).id;
                highestAchievers[i] = getById(idForHightestInMajor);
            }
        }

        return highestAchievers;
    }

    @Override
    public String toString () {
        return "Fast Database";
    }
}
