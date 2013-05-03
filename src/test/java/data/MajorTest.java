package data;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by: Josh
 * On: 4/25/13 10:04 PM
 */
public class MajorTest {
    @Test
    public void testSetup() throws Exception {
        assertEquals(Major.ALL_MAJORS.getIndex(), 0);
        assertEquals(Major.ALL_MAJORS.getDescription(), "All Majors");
        assertEquals(Major.COMPUTER_SCIENCE.getIndex(), 1);
        assertEquals(Major.COMPUTER_SCIENCE.getDescription(), "Computer Science");
        assertEquals(Major.MATH.getIndex(), 2);
        assertEquals(Major.MATH.getDescription(), "Mathematics");
        assertEquals(Major.COMPUTER_ENGINEERING.getIndex(), 3);
        assertEquals(Major.COMPUTER_ENGINEERING.getDescription(), "Computer Engineering");
        assertEquals(Major.HISTORY.getIndex(), 4);
        assertEquals(Major.HISTORY.getDescription(), "History");
        assertEquals(Major.PSYCHOLOGY.getIndex(), 5);
        assertEquals(Major.PSYCHOLOGY.getDescription(), "Psychology");
        assertEquals(Major.BUSINESS.getIndex(), 6);
        assertEquals(Major.BUSINESS.getDescription(), "Business");
        assertEquals(Major.FINE_ARTS.getIndex(), 7);
        assertEquals(Major.FINE_ARTS.getDescription(), "Fine Arts");
    }
}
