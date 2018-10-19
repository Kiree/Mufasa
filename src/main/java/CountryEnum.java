public enum CountryEnum {

    FINLAND("Finland"),
    UNITED_KINGDOM("United Kingdom"),
    JAPAN("Japan");

    private String country;

    CountryEnum(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

}
