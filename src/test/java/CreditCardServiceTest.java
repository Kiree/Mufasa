import POJO.CreditCard;
import org.junit.Before;
import org.junit.Test;
import service.CreditCardService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Petteri Salonurmi
 *
 * CreditCardServiceTest
 * The unit tests for testing the CreditCard service.
 *
 */
public class CreditCardServiceTest {

    private CreditCardService creditCardService;

    @Before
    public void initialize() {
        creditCardService = new CreditCardService();
    }

    @Test
    public void testCreditCardService() {
        //Arrange
        //Act
        //Assert
        fail("TODO");
    }

    @Test
    public void testMockCreditCard() {
        //Arrange
        CreditCard creditCardMock = mock(CreditCard.class);
        when(creditCardMock.getHolderName()).thenReturn("Obi-Wan Kenobi");
        //Act
        String holderName = creditCardMock.getHolderName();
        //Assert
        assertEquals("The name should be Obi-Wan Kenobi.", "Obi-Wan Kenobi", holderName);
    }

}
