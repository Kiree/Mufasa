import POJO.Person;
import exception.MufasaServiceException;
import org.junit.Before;
import org.junit.Test;
import service.MufasaService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * @author Petteri Salonurmi
 *
 * MufasaServiceTest
 * The unit tests for the MufasaService.java
 */
public class MufasaServiceTest {

    private MufasaService mufasaService;

    @Before
    public void initialize() {
        mufasaService = new MufasaService();
    }

    @Test
    public void testDeduction_validDeduction() throws MufasaServiceException {
        //Arrange
        Person personMock = mock(Person.class);
        //Act
        boolean result = mufasaService.testDeduct(personMock);
        //Assert
        assertTrue("Result should be true.", result);
    }

    @Test (expected = MufasaServiceException.class)
    public void testDeduction_invalidDeduction() throws MufasaServiceException {
        //Arrange
        Person personMock = mock(Person.class);
        //Act
        mufasaService.testDeduct(personMock);
        boolean result = mufasaService.testDeduct(personMock);
    }

    @Test
    public void testRefund_validRefund() throws MufasaServiceException {
        //Arrange
        Person personMock = mock(Person.class);
        //Act
        mufasaService.testDeduct(personMock);
        boolean result = mufasaService.testRefund(personMock);
        //Assert
        assertFalse("Result should be false.", result);
    }

    @Test (expected = MufasaServiceException.class)
    public void testRefund_invalidRefund() throws MufasaServiceException {
        //Arrange
        Person personMock = mock(Person.class);
        //Act
        mufasaService.testRefund(personMock);
    }

}
