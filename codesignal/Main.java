// class Base {
//     private Base() {
//         System.out.println("Base Constructor");
//     }

//     public static void printMessage() {
//         System.out.println("Message from Base");
//     }
// }

// class Derived extends Base {
//     // Constructor in Derived is allowed because it's within the class hierarchy
//     Derived() {
//         super();  // Calls the private constructor of Base
//         System.out.println("Derived Constructor");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Derived d = new Derived();
//         d.printMessage();  // This works fine.
//     }
// }

// class Base {
//     private Base() {
//         System.out.println("Base Constructor");
//     }

//     public static void printMessage() {
//         System.out.println("Message from Base");
//     }
// }

// class Derived extends Base {
//     // Constructor in Derived is allowed because it's within the class hierarchy
//     Derived() {
//         super();  // Calls the private constructor of Base
//         System.out.println("Derived Constructor");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Derived d = new Derived();
//         d.printMessage();  // This works fine.
//     }
// }

// class Animal {
//     public static void sound() {
//         System.out.println("Animal sound");
//     }

//     public void speak() {
//         System.out.println("Animal speaks");
//     }
// }

// class Dog extends Animal {
//     public static void sound() {
//         System.out.println("Dog sound");
//     }

//     public void speak() {
//         System.out.println("Dog barks");
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         Animal a = new Dog();
//         a.sound();
//         a.speak();
//     }
// }




// Scenario 3 – Null references and methods
// class Person {
//     public String getName() {
//         return "John Doe";
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         Person p = null;
//         System.out.println(p.getName());
//     }
// }
/*
 Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Person.getName()" because "p" is null
        at Test.main(Test.java:92)
 */

//  class Vehicle {
//     public final void start() {
//         System.out.println("Vehicle is starting");
//     }
// }

// class Car  extends Vehicle{
//     public void start() {
//         System.out.println("Car is starting");
//     }
// }
/*
Cannot override the final method from VehicleJava(67109265)
Car
public void start()
 */

//  class A {
//     int x = 10;
// }

// class B extends A {
//     int x = 20;
    
//     public void print() {
//         System.out.println(x);
//         System.out.println(super.x);
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         B obj = new B();
//         obj.print();
//     }
// }

// 20
// 10

class Parent {
    private void foo() { System.out.println("Parent foo"); }
    void callFoo() { foo(); }
}
class Child extends Parent {
    private void foo() { System.out.println("Child foo"); }
}
public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.callFoo();
    }
}


List<String> words = Arrays.asList("Hello", "World");
String sentence = String.join(" ", words); // "Hello World"


