package DesignPatterns.structural.Decorator;

/*
The Decorator Design Pattern is a structural design pattern that allows you to add new behavior to an object dynamically without modifying its existing code.

In simple terms:
Wrap an object inside another object that adds extra functionality.

Instead of changing the original class or creating many subclasses, you "decorate" the object.

Real-World Example
Imagine ordering a coffee.

You start with:
Coffee

Add milk:
Coffee + Milk

Add sugar:
Coffee + Milk + Sugar

Add whipped cream:
Coffee + Milk + Sugar + Whipped Cream

The coffee object remains the same. Each topping wraps the previous coffee and adds extra behavior.

Problem without Decorator
Suppose you're building a coffee shop.
*/
// Step 1: Component Interface
interface Coffee {
    double cost();
}

/*
Implementation:
class SimpleCoffee implements Coffee {

    @Override
    public double cost() {
        return 100;
    }
}

Now customers can add:
Milk
Sugar
Cream

Without Decorator, you might create:
SimpleCoffee
MilkCoffee
SugarCoffee
CreamCoffee
MilkSugarCoffee
MilkCreamCoffee
SugarCreamCoffee
MilkSugarCreamCoffee

The number of classes grows rapidly.
*/

//Step 2: Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 100;
    }
}

/*

Notice that the decorator has a Coffee.
This is called composition.

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 20;
    }
}
*/
// Step 3: Abstract Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// Step 4: Concrete Decorators Milk
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 20;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 10;
    }
}

//Step 5: Client
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.cost());
    }
}

/*
Decorator in Spring

One common example is caching.

Suppose you have:
public class ProductService {

    public Product getProduct(int id) {
        ...
    }
}

A caching decorator could wrap the service:
CacheDecorator
↓
ProductService

The decorator checks the cache first and only calls the underlying service if needed.

Another example is wrapping an HTTP request with filters or interceptors that add authentication, logging, or metrics.

Advantages
Add behavior without modifying existing classes.
Follows the Open/Closed Principle.
Avoids a large number of subclasses.
Decorators can be combined in different orders.

Disadvantages
Many small classes may be created.
The order of decorators can affect behavior.
Debugging can be harder because multiple objects are involved.
*/