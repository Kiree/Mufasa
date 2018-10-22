package service;

import POJO.Person;

import java.util.logging.Logger;

/**
 * @author Petteri Salonurmi
 *
 * PersonService
 * A service class for handling the Person POJO
 *
 */
public class PersonService {

    private static final Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person createPersonFromRESTCall(Person receivedPerson) {
        Person person = new Person();

        logger.info("Created a new person.");

        return person;
    }

    private boolean validateName(String nameToBeValidated) {
        return false;
    }

}
