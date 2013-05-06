package data;

/**
 * Created by: Josh
 * On: 4/25/13 9:44 PM
 */
public enum Major {
    ALL_MAJORS(0, "All Majors"),
    COMPUTER_SCIENCE(1, "Computer Science"),
    MATH(2, "Mathematics"),
    COMPUTER_ENGINEERING(3, "Computer Engineering"),
    HISTORY(4, "History"),
    PSYCHOLOGY(5, "Psychology"),
    BUSINESS(6, "Business"),
    FINE_ARTS(7, "Fine Arts"),
    CHEMICAL_ENGINEERING(8, "Chemical Engineering"),
    ENGLISH(9, "English");

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
