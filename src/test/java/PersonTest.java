import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonTest {

	private PersonTest person;

	@Before
	public void init() {
		person = new PersonTest();
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
	public void testFirstNameValidInput() {
		//Arrage
		//Act
		//Assert
		fail("TODO");
	}

}
