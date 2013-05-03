package data;

/**
 * Created by: Josh
 * On: 5/2/13 11:25 PM
 */
public class Index implements Comparable<Double> {
    int id;
    double data;

    @Override
    public int compareTo(Double other) {
        return ((Double) data).compareTo(other);
    }
}
