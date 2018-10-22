import POJO.BankAccount;
import POJO.CreditCard;
import POJO.Person;
import exception.CreditCardException;
import exception.MufasaServiceException;
import org.junit.Before;
import org.junit.Test;
import service.MufasaService;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Petteri Salonurmi
 *
 * MufasaServiceTest
 * The unit tests for the MufasaService.java
 */
public class MufasaServiceTest {

    private MufasaService mufasaService;
    private Person mPerson;
    private CreditCard mCreditCard;

    @Before
    public void initialize() {
        mufasaService = new MufasaService();
        mPerson = mock(Person.class);
        BankAccount mBankAccount = mock(BankAccount.class);
        mCreditCard = mock(CreditCard.class);
        when(mPerson.getBankAccount()).thenReturn(mBankAccount);
        when(mBankAccount.getCreditCard()).thenReturn(mCreditCard);
        when(mCreditCard.getExpiryDate()).thenReturn(LocalDate.now().plusDays(1));
    }

    @Test
    public void testDeduction_validDeduction() throws MufasaServiceException, CreditCardException {
        //Arrange
        //Act
        boolean result = mufasaService.testDeduct(mPerson);
        //Assert
        assertTrue("Result should be true.", result);
    }

    @Test (expected = MufasaServiceException.class)
    public void testDeduction_invalidDeduction() throws MufasaServiceException, CreditCardException {
        //Arrange
        //Act
        mufasaService.testDeduct(mPerson);
        boolean result = mufasaService.testDeduct(mPerson);
    }

    @Test
    public void testRefund_validRefund() throws MufasaServiceException, CreditCardException {
        //Arrange
        //Act
        mufasaService.testDeduct(mPerson);
        boolean result = mufasaService.testRefund(mPerson);
        //Assert
        assertFalse("Result should be false.", result);
    }

    @Test (expected = MufasaServiceException.class)
    public void testRefund_invalidRefund() throws MufasaServiceException, CreditCardException {
        //Arrange
        //Act
        mufasaService.testRefund(mPerson);
    }

    @Test (expected = CreditCardException.class)
    public void testDeduction_expiredCreditCard() throws MufasaServiceException, CreditCardException {
        //Arrange
        when(mCreditCard.getExpiryDate()).thenReturn(LocalDate.now().minusDays(1));
        //Act
        mufasaService.testDeduct(mPerson);
    }

}
