package service;

import POJO.Person;
import POJO.Transaction;
import exception.CreditCardException;

import java.time.LocalDate;

class TransactionService {

    /**
     * createTransaction
     * Creates and executes a new transaction against a person's BankAccount through their credit card.
     * @param person - The person whose account is being targeted
     * @param amount - The amount of the transaction
     * @return true/false, depending on the response of the transaction
     */
    boolean createTransaction(Person person, double amount) throws CreditCardException {
        if (isCreditCardValid(person)) {
            if (amount < 0) {
                Transaction transaction = new Transaction(person, amount, true);
                return transaction.isResponse();
            } else {
                Transaction transaction = new Transaction(person, amount, false);
                return transaction.isResponse();
            }
        } else {
            throw new CreditCardException("Expired credit card");
        }

    }

    /**
     * isCreditCardValid
     * Checks if the credit card registered to the Person's account is valid.
     * @param person - The person whose card will be checked
     * @return true/false depending on if the card had expired or not
     */
    private boolean isCreditCardValid(Person person) {
        return person.getBankAccount().getCreditCard().getExpiryDate().isAfter(LocalDate.now());
    }

}
