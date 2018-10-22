package service;

import POJO.Person;
import exception.MufasaServiceException;

public class MufasaService {

    private boolean isRefundAvailable;
    private TransactionService transactionService = new TransactionService();

    public MufasaService() {
        this.isRefundAvailable = false;
    }


    /**
     * testDeduct
     * Function for testing deducts.
     * @param person - The person whose account is being targeted
     * @return true/false, depending on the result of the transaction.
     * @throws MufasaServiceException - Thrown if errors happen or if the deduct was not available.
     */
    public boolean testDeduct(Person person) throws MufasaServiceException {
        if (!isRefundAvailable) {
            isRefundAvailable = transactionService.createTransaction(person, -0.01);
            return isRefundAvailable;
        } else {
            throw new MufasaServiceException("Deduct failed.");
        }

    }

    /**
     * testRefund
     * Function for testing refunds.
     * @param person - The person whose account is being targeted
     * @return true/false, depending on the result of the transaction.
     * @throws MufasaServiceException - Thrown if errors happen or if the refund was not available.
     */
    public boolean testRefund(Person person) throws MufasaServiceException {
        if (isRefundAvailable) {
            isRefundAvailable = transactionService.createTransaction(person, 0.01);
            return isRefundAvailable;
        } else {
            throw new MufasaServiceException("Refund failed.");
        }
    }

}
