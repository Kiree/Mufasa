package POJO;

import enumeration.CreditCardEnum;

import java.util.Date;

/**
 * @author Petteri Salonurmi
 *
 * CreditCard
 * A local class for handling the external CreditCard dependency.
 *
 * This is an external dependency. The details for the variables are retreived from an external source
 * AND MUST NOT BE STORED LOCALLY
 */
public class CreditCard {

    private String holderName;
    private CreditCardEnum creditCard;
    private String creditCardNumber;
    private Date expiryDate;

    public CreditCard(String holderName, CreditCardEnum creditCard, String creditCardNumber, Date expiryDate) {
        this.holderName = holderName;
        this.creditCard = creditCard;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public CreditCardEnum getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardEnum creditCard) {
        this.creditCard = creditCard;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

}
