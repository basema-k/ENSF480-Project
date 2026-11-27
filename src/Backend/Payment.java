package backend;


import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The class holding the payment information.
 * 
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-25 
 */


interface Payment {
    public void isValidPayment();

}

class CreditCardPayment implements Payment{
    @Override 
    public void isValidPayment(){
        
    }

}

class PayPalPayment implements Payment{
    @Override
    public void isValidPayment(){
        
    }
}

class Context {
    private Payment payment;

    public Context(Payment payment){
        this.payment = payment;
    }

    public void executePayment(){
        payment.isValidPayment();
    }
}