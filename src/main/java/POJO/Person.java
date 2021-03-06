package POJO;

import enumeration.CountryEnum;

import java.time.LocalDate;

/**
 * @author Petteri Salonurmi
 *
 * Person
 * A person stored within the system.
 *
 */
public class Person {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private CountryEnum country; // REST will throw error if the country is not in correct form
    private LocalDate birthday; //REST will throw error if the date is not in correct form
    private String phone;
    private String email;
    private BankAccount bankAccount; //MUST NOT BE STORED LOCALLY

    /**
     * Person
     * The default constructor.
     */
    public Person() {

    }

    /**
     * Person
     * A more simple constructor with only some of the parameters
     *
     * @param firstName - The first name of the Person.
     * @param lastName - The last name of the Person.
     * @param password - The password of the Person.
     * @param username - The username of the Person.
     * @param country - The chosen country of the Person.
     * @param birthday - The birthday of the Person.
     * @param phone - The phone number of the Person.
     * @param email - The email of the Person.
     */
    public Person(String firstName, String lastName, String username, String password, CountryEnum country,
                  LocalDate birthday, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.country = country;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Person
     * The full constructor.
     *
     * @param firstName - The first name of the person
     * @param lastName - The last name of the person
     * @param username - The username of the person
     * @param password - The password of the person
     * @param country - The country of the person
     * @param birthday - The birth date of the person
     * @param phone - The phone number of the person
     * @param email - The email of the person
     * @param bankAccount - The BankAccount of the person
     */
    public Person(String firstName, String lastName, String username, String password, CountryEnum country,
           LocalDate birthday, String phone, String email, BankAccount bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.country = country;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.bankAccount = bankAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    public LocalDate getBirthDate() {
        return birthday;
    }

    public void setBirthDate(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
