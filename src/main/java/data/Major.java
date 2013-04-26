package data;

/**
 * Created by: Josh
 * On: 4/25/13 9:44 PM
 */
public enum Major {
    COMPUTER_SCIENCE(1, "Computer Science"),
    MATH(2, "Mathematics"),
    COMPUTER_ENGINEERING(3, "Computer Engineering");

    private final int index;
    private final String description;

    Major(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}
