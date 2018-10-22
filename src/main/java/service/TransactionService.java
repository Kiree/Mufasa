package service;

import POJO.Person;
import POJO.Transaction;

class TransactionService {

    boolean createTransaction(Person person, double amount) {
        if (amount < 0) {
            Transaction transaction = new Transaction(person, amount, true);
            return transaction.isResponse();
        } else {
            Transaction transaction = new Transaction(person, amount, false);
            return transaction.isResponse();
        }
    }

}
