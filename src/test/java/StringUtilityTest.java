import org.junit.Before;
import org.junit.Test;
import util.StringUtility;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Petteri Salonurmi
 *
 * StringUtilityTest
 * Unit tests for the String Utilities
 *
 */
public class StringUtilityTest {

    private StringUtility stringUtility;

    @Before
    public void initialize() {
        stringUtility = new StringUtility();
    }

    @Test
    public void testIsStringNotNullAndEmpty_nullString() {
        //Arrange
        String nullString = null;
        //Act
        boolean result = stringUtility.isStringNOtNullAndEmpty(nullString);
        //Assert
        assertFalse("The result should be false.", result);
    }

    @Test
    public void testIsStringNotNullAndEmpty_emptyString() {
        //Arrange
        String emptyString = "";
        //Act
        boolean result = stringUtility.isStringNOtNullAndEmpty(emptyString);
        //Assert
        assertFalse("The result should be false.", result);
    }

    @Test
    public void testIsStringNotNullAndEmpty_validString() {
        //Arrange
        String validString = "Hello, World!";
        //Act
        boolean result = stringUtility.isStringNOtNullAndEmpty(validString);
        //Assert
        assertTrue("The result should be true.", result);
    }

}
