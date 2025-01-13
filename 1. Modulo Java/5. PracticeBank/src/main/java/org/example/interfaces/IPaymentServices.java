package org.example.interfaces;

public interface IPaymentServices extends ITransaction {
    String PAYMENT_TAG = "Pago de serivicios";
    /**
     * Make payment to a service
     * @param service to pay
     * @param amount to pay
     */
    void makePayment(String service, double amount);
}
