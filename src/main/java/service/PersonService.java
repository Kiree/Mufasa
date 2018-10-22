package service;

import POJO.Person;
import exception.PersonServiceException;
import util.StringUtility;

/**
 * @author Petteri Salonurmi
 *
 * PersonService
 * A service class for handling the Person POJO
 *
 */
public class PersonService {

    private StringUtility stringUtility = new StringUtility();

    /**
     * createPersonFromRESTCall
     * Creates a new person person based on the one received from the REST layer.
     *
     * @param receivedPerson - The person received from the REST API call.
     * @return person - The formatted and evaluated person based on the received person.
     */
    public Person createPersonFromRESTCall(Person receivedPerson) throws PersonServiceException {

        Person person = new Person();
        if (isValidName(receivedPerson.getFirstName())) {
            person.setFirstName(receivedPerson.getFirstName());
        }

        return person;
    }

    /**
     * isValidName
     * Validates the given name against the regex.
     *
     * @param nameToBeValidated - The name that needs to be validated
     * @return true/false depending on if the regex matched.
     * @throws PersonServiceException - Throw error if the name was null or empty
     */
    private boolean isValidName(String nameToBeValidated) throws PersonServiceException {
        if (stringUtility.isStringNOtNullAndEmpty(nameToBeValidated)) {
            String regex = "[a-zA-Z]";
            return nameToBeValidated.matches(regex);
        } else {
            throw new PersonServiceException();
        }
    }

}
