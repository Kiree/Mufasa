import POJO.Person;
import exception.PersonServiceException;
import org.junit.Before;
import org.junit.Test;
import service.PersonService;

import static org.junit.Assert.assertEquals;

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

	@Test (expected = PersonServiceException.class)
	public void testCreatePerson_firstNameNull() throws PersonServiceException {
		//Arrange
		Person restPerson = new Person();
		//Act
		Person newPerson = personService.createPersonFromRESTCall(restPerson);
	}

	@Test (expected = PersonServiceException.class)
	public void testCreatePerson_firstNameEmpty() throws PersonServiceException {
		//Arrange
		Person restPerson = new Person();
		restPerson.setFirstName("");
		//Act
		Person newPerson = personService.createPersonFromRESTCall(restPerson);
	}

	@Test
	public void testCreatePerson_firstNameValid() throws PersonServiceException {
		//Arrange
		String firstName = "Tom";
		Person restPerson = new Person(firstName);
		//Act
		Person newPerson = personService.createPersonFromRESTCall(restPerson);
		//Assert
		assertEquals("The first name should be Tom.", firstName, newPerson.getFirstName());
	}

}
