// Step 1: Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 2: Concrete Strategies
// Credit Card
class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

// UPI
class UPIPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

//PayPal
class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal");
    }
}


// Step 3: Context Class
// The context uses a strategy but doesn't know its implementation.

class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Step 4: Client
public class Main {

    public static void main(String[] args) {

        // You can easily switch strategies.
        PaymentStrategy strategy = new UPIPayment();

        PaymentService service = new PaymentService(strategy);

        service.makePayment(1000);

        // or

        PaymentStrategy strategypal = new PayPalPayment();

        // No changes are needed inside PaymentService.
    }
}
/*
Strategy in Spring Boot

Spring makes Strategy implementations easy to use through dependency injection.

Example:

public interface PaymentStrategy {
    void pay(double amount);
}

Implementations:

@Component
public class UPIPayment implements PaymentStrategy { ... }
@Component
public class CreditCardPayment implements PaymentStrategy { ... }

The appropriate implementation can then be injected or selected based on configuration or business rules, rather than using if-else logic.

Strategy in the JDK

A common example is sorting with different comparators.

Collections.sort(list, Comparator.comparing(Employee::getSalary));

or

Collections.sort(list, Comparator.comparing(Employee::getName));

The sorting algorithm stays the same.

The comparison strategy changes.

Here, Comparator is the strategy.

Advantages
Eliminates long if-else or switch statements.
Easy to add new algorithms.
Algorithms can be tested independently.
Follows the Open/Closed Principle.
Promotes composition over inheritance.

Disadvantages
Introduces more classes.
Clients must know which strategy to choose.
Can add unnecessary complexity if there are only one or two simple algorithms.

*/