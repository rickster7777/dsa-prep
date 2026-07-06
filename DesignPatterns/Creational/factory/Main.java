// Step 1: Product Interface
interface Notification {
    void send();
}
// Step 2: Concrete Products
class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Email");
    }
}


class SMSNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS");
    }
}


// Step 3: Factory Class
class NotificationFactory {

    public static Notification createNotification(String type) {

        if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailNotification();
        }

        if ("SMS".equalsIgnoreCase(type)) {
            return new SMSNotification();
        }

        throw new IllegalArgumentException("Invalid notification type");
    }
}


// Step 4: Client
public class Main {

    public static void main(String[] args) {

        Notification notification =
                NotificationFactory.createNotification("EMAIL");

        notification.send();
    }
}
/*
Where is it used in Java?
The Factory pattern appears throughout the Java ecosystem.

Examples include:
Calendar.getInstance()
NumberFormat.getInstance()
DocumentBuilderFactory.newInstance()
DriverManager.getConnection()
Executors.newFixedThreadPool()


Advantages
Encapsulates object creation.
Reduces coupling between client and concrete classes.
Makes code easier to extend.
Promotes programming to interfaces.


Disadvantages
Adds an extra class (the factory).
The factory can become large if it creates many different object types.
Simple factories using if/switch may need modification whenever a new product is added.


| Factory Pattern                        | Singleton Pattern                         |
| -------------------------------------- | ----------------------------------------- |
| Creates objects                        | Restricts object creation to one instance |
| Focuses on **how** objects are created | Focuses on **how many** objects exist     |
| Can create many objects                | Returns the same object every time        |
| Encapsulates creation logic            | Encapsulates instance management          |


Factory Method Pattern vs Simple Factory

The example above is often called a Simple Factory. The classic Factory Method pattern (from the Gang of Four design patterns) is slightly different.

Instead of a single factory class with if/switch statements, it uses inheritance:

            Creator (abstract)
                  |
         createProduct()
                  |
      -----------------------
      |                     |
 EmailFactory          SMSFactory
      |                     |
 EmailNotification    SMSNotification

Each factory subclass knows how to create one type of product.

Simple Factory: One factory class decides which object to create.
Factory Method: Subclasses decide which object to create through polymorphism.

In practice, you'll encounter Simple Factory frequently in application code because
it's straightforward, while Factory Method is useful when frameworks or libraries need
to let subclasses customize object creation.


what's this Gang of Four design pattern

what's this Gang of Four design pattern

Gang of Four (GoF) refers to the four authors of the book:

"Design Patterns: Elements of Reusable Object-Oriented Software" (1994)

The authors are:

Erich Gamma
Richard Helm
Ralph Johnson
John Vlissides

Because there were four authors, the software community nicknamed them the Gang of Four (GoF).

This book became one of the most influential books in software engineering because it documented 23 common solutions to recurring object-oriented design problems. It didn't invent these ideas; it organized and described patterns that experienced developers were already using.

Why was the book important?

Imagine every project has similar problems:

How do you create objects flexibly?
How do you notify multiple objects about changes?
How do you simplify a complex subsystem?
How do you add behavior without changing existing code?

Instead of solving these from scratch every time, the GoF cataloged proven solutions called design patterns.

Are GoF patterns still relevant?

Yes, but they're used differently today.

Modern frameworks often implement these patterns for you:

Spring uses dependency injection instead of manually writing many factories or singletons.
Hibernate/JPA uses patterns like Factory, Proxy, and Template Method internally.
Java Collections uses Iterator extensively.
Java Executors use Factory methods.
Logging frameworks use Singleton-like shared configuration and Factory methods.

As a result, developers often use GoF patterns every day without explicitly implementing them.

Should you memorize all 23?

Not necessarily. It's more valuable to understand when and why to use them. A practical learning order is:

Singleton
Factory Method
Builder
Strategy
Observer
Decorator
Adapter
Facade
Proxy
Template Method

These appear frequently in enterprise Java applications and in frameworks like Spring.

Once you're comfortable with those, the remaining patterns become much easier to understand because many build on similar object-oriented principles.
*/