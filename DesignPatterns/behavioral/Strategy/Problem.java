/*
The Strategy Design Pattern is a behavioral design pattern that lets you define a family of algorithms, 
encapsulate each one in its own class, and make them interchangeable at runtime.

In simple terms:

Instead of writing lots of if-else or switch statements, move each algorithm into its own class and 
choose the one you need at runtime.
*/

class PaymentService {

    public void pay(String type, double amount) {

        if ("CARD".equals(type)) {
            System.out.println("Paid using Credit Card");
        } else if ("UPI".equals(type)) {
            System.out.println("Paid using UPI");
        } else if ("PAYPAL".equals(type)) {
            System.out.println("Paid using PayPal");
        } else {
            throw new IllegalArgumentException("Invalid payment");
        }
    }
}

public class Problem {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.pay("UPI", 1000);
    }
}

/*
Problems
Every new payment method requires modifying PaymentService.
Lots of if-else statements.
Violates the Open/Closed Principle (open for extension, closed for modification).
Hard to test individual algorithms.

*/