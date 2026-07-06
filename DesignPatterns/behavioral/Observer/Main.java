import java.util.ArrayList;
import java.util.List;


// Step 1: Observer Interface

interface Observer {
    void update(String message);
}


// Step 2: Concrete Observers
// Email Observer
class EmailObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Email: " + message);
    }
}


//SMS Observer
class SMSObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("SMS: " + message);
    }
}

// Step 3: Subject

class OrderService {

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void placeOrder() {

        System.out.println("Order placed");

        notifyObservers("New order placed");
    }

    private void notifyObservers(String message) {

        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Step 4: Client
public class Main {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        orderService.addObserver(new EmailObserver());
        orderService.addObserver(new SMSObserver());

        orderService.placeOrder();
    }
}