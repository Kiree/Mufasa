import POJO.CreditCard;
import POJO.Person;
import org.junit.Before;
import org.junit.Test;
import service.PersonService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Petteri Salonurmi
 *
 * PersonServiceTest
 * The unit tests for the PersonService class, that handles the Person POJO.
 *
 */
public class PersonServiceTest {

	private PersonService personService;

	@Before
	public void init() {
		personService = new PersonService();
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

	@Test
	public void testCreatingPerson() {
		//Arrange
		Person restPerson = new Person();
		//Act
		Person newPerson = personService.createPersonFromRESTCall(restPerson);
		//Assert
		assertNull("New person should be null.", newPerson);
		fail("WIP");
	}


	@Test
	public void testFirstNameValidInput() {
		//Arrage

		//Act
		//Assert
		fail("TODO");
	}

}
