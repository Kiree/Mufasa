package service;

import POJO.Person;
import exception.PersonServiceException;
import util.StringUtility;

import java.time.LocalDate;

/**
 * @author Petteri Salonurmi
 *
 * PersonService
 * A service class for handling the Person POJO
 *
 */
public class PersonService {

    private StringUtility stringUtility = new StringUtility();
    private final static int passwordMinLength = 8;

    /**
     * restCall
     * Simulates a REST called received from the front-end. In reality should be in a controller class.
     *
     * @param receivedPerson - The person received from the frontend
     * @param secondPassword - The second password received from the frontend
     * @return A new person created based on the service logic.
     * @throws PersonServiceException - Throw error if the passwords had shenanigans going on
     */
    public Person restCall(Person receivedPerson, String secondPassword, String secondEmail) throws PersonServiceException {
        if (validatePasswordMatch(receivedPerson.getPassword(), secondPassword) && validateEmailMatch(receivedPerson.getEmail(), secondEmail)) {
            return createPersonFromRESTCall(receivedPerson);
        } else {
            throw new PersonServiceException("Invalid password.");
        }
    }

    /**
     * createPersonFromRESTCall
     * Creates a new person person based on the one received from the REST layer.
     *
     * @param receivedPerson - The person received from the REST API call.
     * @return person - The formatted and evaluated person based on the received person.
     */
    public Person createPersonFromRESTCall(Person receivedPerson) throws PersonServiceException {
        Person person = new Person();
        person.setFirstName(validateAndReturnFirstName(receivedPerson));
        person.setLastName(validateAndReturnLastName(receivedPerson));
        person.setPassword(receivedPerson.getPassword()); //Already validated pre method call.
        person.setUsername(validateAndReturnUsername(receivedPerson));
        person.setCountry(receivedPerson.getCountry()); //Error thrown in REST if the country is not in accepted list.
        person.setBirthDate(validateAndReturnBirthday(receivedPerson));
        person.setPhone(validateAndReturnPhone(receivedPerson));
        person.setEmail(receivedPerson.getEmail());

        return person;
    }

    /**
     * validateAndReturnFirstName
     * Validates the given person's first name against the regex and returns it
     *
     * @param receivedPerson - The person whose name needs to be validated
     * @return receivedPerson.getFirstName() - The validated name
     * @throws PersonServiceException - Throw error if the name was null or empty
     */
    private String validateAndReturnFirstName(Person receivedPerson) throws PersonServiceException {
        String regex = "[a-zA-Z]+";
        if (stringUtility.isStringNotNullAndEmpty(receivedPerson.getFirstName()) && receivedPerson.getFirstName().matches(regex)) {
            return receivedPerson.getFirstName();
        } else {
            throw new PersonServiceException("Invalid first name.");
        }
    }

    /**
     * validateAndReturnLastName
     * Validates the given person's last name against the regex and sets it
     *
     * @param receivedPerson - The person whose name needs to be validated
     * @return receivedPerson.getLastName() - The validated name
     * @throws PersonServiceException - Throw error if the name was null or empty
     */
    private String validateAndReturnLastName(Person receivedPerson) throws PersonServiceException {
        String regex = "[a-zA-Z]+";
        if (stringUtility.isStringNotNullAndEmpty(receivedPerson.getLastName()) && receivedPerson.getLastName().matches(regex)) {
            return receivedPerson.getLastName();
        } else {
            throw new PersonServiceException("Invalid last name.");
        }
    }


    /**
     * validatePasswordMatch
     * Checks that the first and second passwords match.
     *
     * @param firstPassword - The first password
     * @param secondPassword - The second password
     * @return True/false, depending on if the passwords were valid and matched.
     */
    private boolean validatePasswordMatch(String firstPassword, String secondPassword) {
        if (isValidPassword(firstPassword) && isValidPassword(secondPassword)) {
            return firstPassword.equals(secondPassword);
        } else {
            return false;
        }
    }

    /**
     * isValidPassword
     * Validates the given password against the password criteria.
     * @param password - The password to be checked.
     * @return true/false depending on if the password was valid or not.
     */
    private boolean isValidPassword(String password) {
        return (stringUtility.isStringNotNullAndEmpty(password) && (password.length() > (passwordMinLength - 1)));
    }

    /**
     * validateAndReturnUsername
     * Validates the username of the user.
     * @param receivedPerson - The person Received from the front-end
     * @return The username of the Person
     * @throws PersonServiceException - Throw error if the username was empty, null or invalid.
     */
    private String validateAndReturnUsername(Person receivedPerson) throws PersonServiceException {
        String regex = "^[a-zA-Z0-9]+(_[a-zA-Z0-9]+)";
        if (stringUtility.isStringNotNullAndEmpty(receivedPerson.getUsername())
                && receivedPerson.getUsername().matches(regex)
                && (receivedPerson.getUsername().length() < 16)) {
            return receivedPerson.getUsername();
        } else {
            throw new PersonServiceException("Invalid username.");
        }
    }

    /**
     * validateAndReturnBirthday
     * Checks the validity of the given birthday and returns it.
     * @param receivedPerson - The person received from the Front-end
     * @return The birthday of the Person
     * @throws PersonServiceException - Throw error if the birthday was null or invalid.
     */
    private LocalDate validateAndReturnBirthday(Person receivedPerson) throws PersonServiceException {
        LocalDate currentDate18YearsAgo = LocalDate.now().minusYears(18);

        if ((receivedPerson.getBirthDate() != null) && receivedPerson.getBirthDate().isBefore(currentDate18YearsAgo)) {
            return receivedPerson.getBirthDate();
        } else {
            throw new PersonServiceException("Invalid birthday.");
        }
    }

    /**
     * validateAndReturnPhone
     * Checks the validity of the given phone number and returns it.
     * @param receivedPerson - The person received from the Front-end
     * @return The phone number of the Person
     * @throws PersonServiceException - Throw error if the phone number was null, empty or invalid
     */
    private String validateAndReturnPhone(Person receivedPerson) throws PersonServiceException {
        String regex = "^[0-9]+";
        if (stringUtility.isStringNotNullAndEmpty(receivedPerson.getPhone())
                && receivedPerson.getPhone().matches(regex)) {
            return receivedPerson.getPhone();
        } else {
            throw new PersonServiceException("Invalid phone number.");
        }
    }

    /**
     * validateEmailMatch
     * Validate if the emails received from front-end were empty, null and matched.
     * @param firstEmail - The first email received from the Front-end
     * @param secondEmail - The second email received from the front-end
     * @return true/false, depending on if the emails were valid and matched
     */
    private boolean validateEmailMatch(String firstEmail, String secondEmail) {
        return (stringUtility.isStringNotNullAndEmpty(firstEmail)
                && stringUtility.isStringNotNullAndEmpty(secondEmail)
                && firstEmail.equals(secondEmail));
    }

}
