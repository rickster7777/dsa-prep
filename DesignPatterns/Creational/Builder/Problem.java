/*
The Builder Design Pattern is a creational design pattern used to construct complex objects step by step.
It is especially useful when an object has many optional parameters or when creating the object requires multiple steps.

Instead of passing many constructor arguments, you build the object by specifying only the properties you need.


Problems
Constructor becomes very long.
Easy to swap parameters accidentally.
Hard to read.
Difficult to add new fields later.

This is often called the telescoping constructor problem.
*/

class User {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;

    public User(String firstName,
            String lastName,
            int age,
            String email,
            String phone,
            String address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}

public class Problem {
    public static void main(String[] args) {
        User user = new User(
                "John",
                "Doe",
                25,
                "john@gmail.com",
                "9876543210",
                "New York");
    }
}

/*
Builder in Java

One of the most common examples is StringBuilder.

StringBuilder sb = new StringBuilder();

sb.append("Hello");
sb.append(" ");
sb.append("World");

String result = sb.toString();

Here:

append() adds data step by step.
toString() produces the final object.
Builder in Spring

Spring uses the builder style in many APIs.

For example:
ResponseEntity.ok()
              .header("Version", "1")
              .body(user);

Each method configures the response, and the final call produces the object.

Advantages
Improves readability.
Avoids constructors with many parameters.
Supports optional fields naturally.
Makes immutable objects easier to create.
Reduces the risk of passing parameters in the wrong order.

Disadvantages
Requires additional code (builder class).
Can be unnecessary for simple objects with only a few fields.


When should you use the Builder pattern?

The Builder pattern is a good choice when:

A class has many constructor parameters (especially optional ones).
You want to create immutable objects.
Object construction involves multiple steps.
You want code that's easy to read and maintain.

For enterprise Java development, you'll encounter the Builder pattern frequently in libraries and 
frameworks. A notable example is Project Lombok, where the @Builder annotation generates the 
builder code automatically, making this pattern even more convenient to use.




Decorator
Adapter
Facade
Proxy
Template Me
*/