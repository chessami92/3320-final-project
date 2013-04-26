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
        assertEquals(Major.COMPUTER_SCIENCE.getIndex(), 1);
        assertEquals(Major.COMPUTER_SCIENCE.getDescription(), "Computer Science");
        assertEquals(Major.MATH.getIndex(), 2);
        assertEquals(Major.MATH.getDescription(), "Mathematics");
        assertEquals(Major.COMPUTER_ENGINEERING.getIndex(), 3);
        assertEquals(Major.COMPUTER_ENGINEERING.getDescription(), "Computer Engineering");
    }
}
