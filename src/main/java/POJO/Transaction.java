package POJO;

/**
 * @author Petteri Salonurmi
 *
 * Transaction
 * A class for tracking bank transactions
 *
 */
public class Transaction {

    private Person person;
    private double amount;
    private boolean response = false;

    public Transaction() {

    }

    public Transaction(Person person, double amount, boolean response) {
        this.person = person;
        this.amount = amount;
        this.response = response;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
