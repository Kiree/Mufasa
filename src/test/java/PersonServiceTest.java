import POJO.Person;
import exception.PersonServiceException;
import org.junit.Before;
import org.junit.Test;
import service.PersonService;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Petteri Salonurmi
 *
 * PersonServiceTest
 * The unit tests for the PersonService class, that handles the Person POJO.
 *
 */
public class PersonServiceTest {

	private PersonService personService;

    private Person validPerson;
	private String validFirstName = "Tom";
	private String validLastName = "Sawyer";
    private String validUsername = "Tom_S4wyer";
	private String validPassword = "ModernDayWarrior";
    private String validEmail = "tom.sawyer@rush.com";
    private LocalDate validBirthday = LocalDate.of(1981, 2, 28);
    private String validPhone = "1234567809";


	@Before
	public void init() {
		personService = new PersonService();
		validPerson = new Person(validFirstName, validLastName, validUsername, validPassword);
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
        validPerson.setUsername(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(validPerson, secondPassword);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_firstPasswordEmpty() throws PersonServiceException {
        //Arrange
        String firstPassword = "";
        String secondPassword = "Pictures";
        validPerson.setUsername(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(validPerson, secondPassword);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_firstPasswordLessThanEightLetters() throws PersonServiceException {
        //Arrange
        String firstPassword = "Moving";
        String secondPassword = "Pictures";
        validPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(validPerson, secondPassword);
        //Assert
        assertTrue("The password should be 8 characters or longer.", receivedPerson.getPassword().length() > 8);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_firstPasswordEightLettersSecondPasswordInvalid() throws PersonServiceException {
        //Arrange
        String firstPassword = "Pictures";
        String secondPassword = "Moving";
        validPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(validPerson, secondPassword);
    }

    @Test (expected = PersonServiceException.class)
    public void testRestCall_passwordsValidNoMatch() throws PersonServiceException {
        //Arrange
        String firstPassword = "Warrior!";
        String secondPassword = "Moving Pictures";
        validPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(validPerson, secondPassword);
    }

    @Test
    public void testRestCall_passwordsValidMatch8Characters() throws PersonServiceException {
        //Arrange
        String firstPassword = "Warrior!";
        String secondPassword = "Warrior!";
        validPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(validPerson, secondPassword);
        //Assert
        assertEquals("The password should be Warrior!", firstPassword, receivedPerson.getPassword());
    }

    @Test
    public void testRestCall_passwordsValidMatch9Characters() throws PersonServiceException {
        //Arrange
        String firstPassword = "ModernDay";
        String secondPassword = "ModernDay";
        validPerson.setPassword(firstPassword);
        //Act
        Person receivedPerson = personService.restCall(validPerson, secondPassword);
        //Assert
        assertEquals("The password should be ModernDay", firstPassword, receivedPerson.getPassword());
    }

    @Test (expected = PersonServiceException.class)
    public void testCreatePerson_usernameInvalidCharacter() throws PersonServiceException {
        //Arrange
        String invalidCharacterUsername = "Tom_Sawyer!";
        validPerson.setUsername(invalidCharacterUsername);
        //Act
        Person receivedPerson = personService.createPersonFromRESTCall(validPerson);
    }

    @Test (expected = PersonServiceException.class)
    public void testCreatePerson_usernameTooLong() throws PersonServiceException {
        //Arrange
        String tooLongUsername = "Moving_Pictures1981";
        validPerson.setUsername(tooLongUsername);
        //Act
        Person receivedPerson = personService.createPersonFromRESTCall(validPerson);
    }

    @Test (expected = PersonServiceException.class)
    public void testCreatePerson_usernameTooManyUnderscores() throws PersonServiceException {
        //Arrange
        String underscoreUsername = "_TOM_SAWYER_";
        validPerson.setUsername(underscoreUsername);
        //Act
        Person receivedPerson = personService.createPersonFromRESTCall(validPerson);
    }

    @Test (expected = PersonServiceException.class)
    public void testCreatePerson_usernameEmpty() throws PersonServiceException {
        //Arrange
        String emptyUsername = "";
        validPerson.setUsername(emptyUsername);
        //Act
        Person receivedPerson = personService.createPersonFromRESTCall(validPerson);
    }

    @Test (expected = PersonServiceException.class)
    public void testCreatePerson_usernameNull() throws PersonServiceException {
        //Arrange
        String nullUsername = null;
        validPerson.setUsername(nullUsername);
        //Act
        Person receivedPerson = personService.createPersonFromRESTCall(validPerson);
    }

    @Test
    public void testCreatePerson_usernameValid15Characters() throws PersonServiceException {
        //Arrange
        String validUsername15characters = "Tom_S4wyerRush1";
        validPerson.setUsername(validUsername15characters);
        //Act
        Person receivedPerson = personService.createPersonFromRESTCall(validPerson);
        //Assert
        assertEquals("The username should be Tom_S4wyerRush1", validUsername15characters, receivedPerson.getUsername());
    }

    @Test
    public void testCreatePerson_usernameValid14Characters() throws PersonServiceException {
	    //Arrange
        String validUsername14characters = "Tom_S4wyerRush";
        validPerson.setUsername(validUsername14characters);
        //Act
        Person receivedPerson = personService.createPersonFromRESTCall(validPerson);
        //Assert
        assertEquals("The username should be Tom_S4wyerRush", validUsername14characters, receivedPerson.getUsername());

    }

    @Test
    public void testCreatePerson_validPerson() throws PersonServiceException {
        //Act
        Person newPerson = personService.createPersonFromRESTCall(validPerson);
        //Assert
        assertEquals("The first name should be Tom", validFirstName, newPerson.getFirstName());
        assertEquals("The last name should be Sawyer.", validLastName, newPerson.getLastName());
        assertEquals("The password should be ModernDayWarrior", validPassword, newPerson.getPassword());
        assertEquals("The username should be Tom_S4wyer", validUsername, newPerson.getUsername());
    }

}
