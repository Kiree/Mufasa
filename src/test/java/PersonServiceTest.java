import POJO.Person;
import exception.PersonServiceException;
import org.junit.Before;
import org.junit.Test;
import service.PersonService;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Petteri Salonurmi
 *
 * PersonServiceTest
 * The unit tests for the PersonService class, that handles the Person POJO.
 *
 */
public class PersonServiceTest {

	private PersonService personService;

	private String validFirstName = "Tom";
	private String validLastName = "Sawyer";
    private String validUsername = "Tom_Sawyer";
	private String validPassword = "ModernDayWarrior";
    private String validEmail = "tom.sawyer@rush.com";
    private LocalDate validBirthday = LocalDate.of(1981, 2, 28);
    private String validPhone = "1234567809";

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

	@Test (expected = PersonServiceException.class)
    public void testCreatePerson_lastNameNull() throws PersonServiceException {
        //Arrange
        Person restPerson = new Person();
        restPerson.setFirstName("Tom");
        //Act
        Person newPerson = personService.createPersonFromRESTCall(restPerson);
    }

    @Test (expected = PersonServiceException.class)
    public void testCreatePerson_lastNameEmpty() throws PersonServiceException {
        //Arrange
        Person restPerson = new Person();
        restPerson.setFirstName("Tom");
        restPerson.setLastName("");
        //Act
        Person newPerson = personService.createPersonFromRESTCall(restPerson);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_firstPasswordNull() throws PersonServiceException {
        //Arrange
        String firstPassword = null;
        String secondPassword = "Pictures";
        Person restPerson = new Person();
        restPerson.setFirstName(validFirstName);
        restPerson.setLastName(validLastName);
        restPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(restPerson, secondPassword);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_firstPasswordEmpty() throws PersonServiceException {
        //Arrange
        String firstPassword = "";
        String secondPassword = "Pictures";
        Person restPerson = new Person();
        restPerson.setFirstName(validFirstName);
        restPerson.setLastName(validLastName);
        restPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(restPerson, secondPassword);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_firstPasswordLessThanEightLetters() throws PersonServiceException {
        //Arrange
        String firstPassword = "Moving";
        String secondPassword = "Pictures";
        Person restPerson = new Person();
        restPerson.setFirstName(validFirstName);
        restPerson.setLastName(validLastName);
        restPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(restPerson, secondPassword);
        //Assert
        assertTrue("The password should be 8 characters or longer.", receivedPerson.getPassword().length() > 8);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_firstPasswordEightLettersSecondPasswordInvalid() throws PersonServiceException {
        //Arrange
        String firstPassword = "Pictures";
        String secondPassword = "Moving";
        Person restPerson = new Person();
        restPerson.setFirstName(validFirstName);
        restPerson.setLastName(validLastName);
        restPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(restPerson, secondPassword);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_passwordsValidNoMatch() throws PersonServiceException {
        //Arrange
        String firstPassword = "Warrior!";
        String secondPassword = "Moving Pictures";
        Person restPerson = new Person();
        restPerson.setFirstName(validFirstName);
        restPerson.setLastName(validLastName);
        restPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(restPerson, secondPassword);
    }

    @Test
    public void testRestCall_passwordsValidMatch8Characters() throws PersonServiceException {
        //Arrange
        String firstPassword = "Warrior!";
        String secondPassword = "Warrior!";
        Person restPerson = new Person();
        restPerson.setFirstName(validFirstName);
        restPerson.setLastName(validLastName);
        restPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(restPerson, secondPassword);
        //Assert
        assertEquals("The password should be Warrior!", firstPassword, receivedPerson.getPassword());
    }

    @Test
    public void testRestCall_passwordsValidMatch9Characters() throws PersonServiceException {
        //Arrange
        String firstPassword = "ModernDay";
        String secondPassword = "ModernDay";
        Person restPerson = new Person();
        restPerson.setFirstName(validFirstName);
        restPerson.setLastName(validLastName);
        restPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(restPerson, secondPassword);
        //Assert
        assertEquals("The password should be ModernDay", firstPassword, receivedPerson.getPassword());
    }

    @Test
    public void testCreatePerson_validPerson() throws PersonServiceException {
        //Arrange
        Person restPerson = new Person(validFirstName, validLastName, validPassword);
        //Act
        Person newPerson = personService.createPersonFromRESTCall(restPerson);
        //Assert
        assertEquals("The first name should be Tom", validFirstName, newPerson.getFirstName());
        assertEquals("The last name should be Sawyer.", validLastName, newPerson.getLastName());
        assertEquals("The password should be ModernDayWarrior", validPassword, newPerson.getPassword());
    }

}
