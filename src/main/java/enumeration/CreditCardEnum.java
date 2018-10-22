package enumeration;

public enum CreditCardEnum  {

    MASTERCARD("Mastercard"),
    VISA("VISA"),
    DISCOVER("Discover");

    private String creditCard;

    CreditCardEnum(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCreditCard() {
        return creditCard;
    }

}
