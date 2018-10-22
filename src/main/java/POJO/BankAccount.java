package POJO;

/**
 * @author Petteri Salonurmi
 *
 * BankAccount
 * A local class for handling the external Bank Account dependency.
 *
 * This is an external dependency. The details for the variables are retreived from an external source
 * AND MUST NOT BE STORED LOCALLY
 */
public class BankAccount {

    private String streetAddress;
    private String city;
    private String postalCode;
    private String password;
    private CreditCard creditCard; //MUST NOT BE STORED LOCALLY

    public BankAccount() {

    }

    public BankAccount(String streetAddress, String city, String postalCode, String password, CreditCard creditCard) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.password = password;
        this.creditCard = creditCard;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

}
