package data;

/**
 * Created by: Josh
 * On: 4/25/13 10:49 PM
 */
public interface StudentDatabase {

    /*
     * Add a student, given their name, a grade, and their majors.
     * The database returns the student, with a newly generated id on it.
     */
    public Student addStudent(Student student);

    /*
     * Get a student given an id. Returns the student record if found,
     * and returns a null if not found.
     */
    public Student getById(int id);

    /*
     * Return the percentile information for a given student. The method returns
     * a double array, where each element corresponds to to the Major enum index.
     * Any major that does not apply to the student is given the percentil -1.
     */
    public double[] getPercentilesById(int id);

    /*
     * Return an array of the highest achievers for each of the major. The method
     * returns an array of students, where each element corresponds to the Major
     * enum index. Any majors that do not have a student in them have are null.
     */
    public Student[] getHighestAchievers();
}
