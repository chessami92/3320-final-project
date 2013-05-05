package data;

/**
 * Created by: Josh
 * On: 4/25/13 10:49 PM
 */
public interface StudentDatabase {

    public Student addStudent(Student student);

    public Student getById(int id);

    public double[] getPercentilesById(int id);

    public Student[] getHighestAchievers();
}
