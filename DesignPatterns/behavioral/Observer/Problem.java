/*
The Observer Design Pattern is a behavioral design pattern where one object (the Subject) automatically notifies multiple dependent objects (Observers) whenever its state changes.

In simple terms:

One object changes → Everyone interested gets notified automatically.

This is commonly called the Publish-Subscribe (Pub/Sub) model.

Problem without Observer
Suppose you're building an e-commerce application.

When an order is placed, you need to:
Send an email
Send an SMS
Update inventory
Generate an invoice
Notify the warehouse
*/


// Without the Observer pattern:

class OrderService {

    public void placeOrder(Order order) {

        saveOrder(order);

        emailService.sendEmail(order);

        smsService.sendSMS(order);

        inventoryService.updateStock(order);

        invoiceService.generate(order);

        warehouseService.notify(order);
    }
}

/*
Problems
OrderService knows about every other service.
Every new notification requires changing OrderService.
Tight coupling.
Difficult to test.
*/
public class Problem {
    public static void main(String[] args) {
        Order order = new Order(1, "Laptop", 1);

        OrderService orderService = new OrderService();

        orderService.placeOrder(order);
    }
}
