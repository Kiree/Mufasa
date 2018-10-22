import org.junit.Before;
import org.junit.Test;
import service.BankAccountService;

import static org.junit.Assert.fail;

/**
 * @author Petteri Salonurmi
 *
 * BankAccountServiceTest
 * The unit tests for testing the BankAccount service.
 *
 */
public class BankAccountServiceTest {

    private BankAccountService bankAccountService;

    @Before
    public void initialize() {
        bankAccountService = new BankAccountService();
    }

    @Test
    public void testBankAccountService() {
        //Arrange
        //Act
        //Assert
        fail("TODO");
    }

}
