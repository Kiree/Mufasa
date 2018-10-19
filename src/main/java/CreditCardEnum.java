public enum CreditCardEnum  {

    MASTERCARD("Mastercard"),
    VISA("VISA"),
    DISCOVER("Discover");

    private String creditcard;

    CreditCardEnum(String creditcard) {
        this.creditcard = creditcard;
    }

    public String getCreditcard() {
        return creditcard;
    }

}
