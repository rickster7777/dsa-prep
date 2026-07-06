package DesignPatterns.Creational.Singleton;



/*
The Singleton Design Pattern is a creational design pattern that ensures a class has only one instance and provides 
a global point of access to that instance.

Why use Singleton?

Use the Singleton pattern when:
Only one instance of an object should exist.
Multiple parts of an application need to share the same object.
The object manages shared resources.

Examples:
Database connection manager
Logger
Configuration manager
Cache manager
Thread pool


*/

//Naive approach
class Logger {
  public void log(String message) {
    System.out.println("Log: " + message);
  }
}

class Application {
    public void run() {
        Logger logger = new Logger();  // New instance created every time
        logger.log("Application started.");
    }
}

class UserService {
    public void login(String username) {
        Logger logger = new Logger();  // Another new instance created
        logger.log("User " + username + " logged in.");
    }
}
/*
The Problem with the naive approach: Multiple Instances of the Logger

The Problem with the Traditional Approach: Messy and Inefficient 😓
1. Multiple Instances of Logger:
2. Inconsistent Logging:
3. Difficulty Managing State:


Following are the better approaches

| Implementation         | Lazy | Thread-Safe | Performance    | Recommended        |
| ---------------------- | ---- | ----------- | -----------    | ------------------ |
| Eager Initialization   | ❌    | ✅           | High        | Small applications |
| Lazy Initialization    | ✅    | ❌           | High        | No                 |
| Synchronized Method    | ✅    | ✅           | Medium      | Acceptable         |
| Double-Checked Locking | ✅    | ✅           | High        | Yes                |
| Bill Pugh              | ✅    | ✅           | Very High   | **Yes**            |
| Enum Singleton         | ✅    | ✅           | Excellent   | **Best for Java**  |


*/

class SingletonEager {

    /*
     * Eager Initialization
     *
     * Advantages:
     * - Simple implementation
     * - Thread-safe (instance created during class loading)
     *
     * Disadvantages:
     * - Instance is created even if it's never used.
     */

    // Instance is created when the class is loaded
    private static final SingletonEager INSTANCE = new SingletonEager();

    // Private constructor prevents instantiation
    private SingletonEager() {
    }

    // Global access point
    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}


class SingletonLazy {
    /*
    Lazy Initialization (Not Thread-Safe)

    The instance is created only when needed.

    Problem
    Multiple threads can create multiple instances.
    */
    private static SingletonLazy instance;

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}


/*
Thread-Safe Singleton
Advantage
Thread-safe

Disadvantage
Synchronization reduces performance.
*/

class SingletonThreadSafe {

    private static SingletonThreadSafe instance;

    private SingletonThreadSafe() {}

    public static synchronized SingletonThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
}


/*
4. Double-Checked Locking (Recommended)
Advantages

Thread-safe
Better performance than synchronizing every call

*/

class SingletonDoubleCheck {

    private static volatile SingletonDoubleCheck instance;

    private SingletonDoubleCheck() {}

    public static SingletonDoubleCheck getInstance() {

        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }

        return instance;
    }
}


/*
5. Bill Pugh Singleton (Best Practice)

Uses a static inner helper class.

Advantages:
- Lazy initialization
- Thread-safe
- No synchronization overhead
- Widely recommended
*/
class SingletonBillPugh {

    private SingletonBillPugh() {
    }

    private static class SingletonHelper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

/*
6. Enum Singleton (Best in Java)

Uses the enum type to create a singleton instance.

Advantages:
- Thread-safe
- Prevents serialization issues
- Protects against reflection attacks
- Simplest implementation
*/
enum SingletonEnum {
    INSTANCE;

    public void display() {
        System.out.println("Singleton instance");
    }
}

public class Main {
    public static void main(String[] args) {
        SingletonEager s1 = SingletonEager.getInstance();
        SingletonEager s2 = SingletonEager.getInstance();

        System.out.println(s1 == s2); // true

        SingletonBillPugh billPugh1 = SingletonBillPugh.getInstance();
        SingletonBillPugh billPugh2 = SingletonBillPugh.getInstance();
        System.out.println(billPugh1 == billPugh2); // true

        SingletonEnum.INSTANCE.display();
    }
}



/*
Distributed systems approach

How it works actually in the real-world production applications
which are using the microservices architecture how logging and db connections are managed currently in the industry

This is where the difference between object-oriented design patterns and distributed system architecture becomes important.
In modern production systems, the Singleton pattern is still used—but only inside a single service instance, not across the
entire microservices ecosystem.


Let's walk through a typical production setup.

                    Internet
                        |
                 API Gateway / Load Balancer
                        |
       -----------------------------------------
       |              |               |
   User Service   Order Service   Payment Service
       |              |               |
    5 instances     3 instances     4 instances

Suppose the User Service has 5 replicas.

Each replica is an independent process (often inside its own container).

User Service

Replica 1 (JVM)
    Logger
    Connection Pool

Replica 2 (JVM)
    Logger
    Connection Pool

Replica 3 (JVM)
    Logger
    Connection Pool

Each JVM has its own singleton objects.

1. How logging works in production

Applications do not share a logger instance across services.

Instead, every service has its own logger.

For example in Spring Boot:

private static final Logger logger =
        LoggerFactory.getLogger(UserService.class);

Internally:

One JVM
     |
 Logging Framework
     |
 Logger instances

The logging framework (such as SLF4J with Logback or Log4j2) manages these efficiently, and loggers are effectively reused.

The important part is where logs go.

Instead of writing to local files permanently, containers usually write logs to stdout/stderr.

Application
      |
 stdout
      |
Docker
      |
Kubernetes
      |
Log Collector

A log collector gathers logs from every service.

Common production stacks include:
Fluent Bit
Fluentd
Vector
OpenTelemetry Collector

Those forward logs to centralized platforms such as:
Elastic Stack (Elasticsearch + Kibana)
Grafana Loki
Splunk
Datadog
New Relic

So even though every service has its own logger, developers see all logs in one centralized place.

Example:
10:31 User Service
User created

10:31 Payment Service
Payment initiated

10:31 Order Service
Order completed

You can search across all services using a request or trace ID.

2. How database connections are managed

This is one of the biggest misconceptions.
Applications do not open a new database connection for every request because that would be slow.
Instead, each service maintains a connection pool.

                PostgreSQL
                 ^
                 |
        -------------------
        |    Pool        |
        -------------------
      /   |   |   |   |   \
   Conn Conn Conn Conn Conn

When a request arrives:

HTTP Request
      |
Business Logic
      |
Connection Pool
      |
Database

The application borrows an existing connection, executes the query, and returns it to the pool.

No new TCP connection is created for every request.

Example with Spring Boot

Spring Boot typically uses HikariCP as the default connection pool.

User Service

Hikari Pool

Connection 1
Connection 2
Connection 3
...
Connection 20

If 100 requests arrive:

20 requests use existing connections.
The remaining requests wait briefly for a connection to become available (subject to pool configuration).


3. What if there are multiple replicas?

Suppose:

User Service
5 replicas

Each replica has:

Replica 1
20 DB connections

Replica 2
20 DB connections

Replica 3
20 DB connections

Replica 4
20 DB connections

Replica 5
20 DB connections

Total:

100 connections
This is why database connection limits matter. If you have many services and replicas, the total number of open connections can become 
very large.

4. How large companies handle thousands of connections

Large systems often add another layer between applications and the database.

Microservices
      |
Connection Pool
      |
PgBouncer / ProxySQL / RDS Proxy
      |
Database

These proxies multiplex connections, reducing the number of actual database connections while allowing many clients to interact efficiently.

5. How configuration is managed

Configuration is usually loaded once when a service starts.

Configuration
      |
Singleton Bean
      |
Whole Application

Examples:

Database URL
API keys
Feature flags
Cache configuration

In frameworks like Spring Boot, configuration is typically managed as singleton beans by the dependency injection container.

6. How caching works

Each service may have:

Local Cache

Replica 1
Cache

Replica 2
Cache

Replica 3
Cache

For data that needs to be shared across replicas, teams typically use a distributed cache:

Services
     |
 Redis

This ensures all replicas see the same cached data.

7. How scheduled jobs work

If every replica runs a scheduled task independently:

Replica 1
Run cleanup

Replica 2
Run cleanup

Replica 3
Run cleanup

The job executes three times.

To avoid that, production systems use:

Distributed locks
Leader election
Dedicated job schedulers

Only one instance performs the task at a given time.

A common misconception

Many people think there's one global logger or one global database connection shared by all microservices.

In practice:
    Each service instance has its own logger and its own connection pool.
    Shared infrastructure (logging backends, databases, caches) provides a unified view or shared state where needed.
    Coordination across services is handled with distributed systems techniques (message brokers, distributed locks, leader election, tracing),
    not with the Singleton pattern.

That's one of the reasons microservices scale well: each instance is largely self-contained, while relying on shared infrastructure only
for the resources that truly need to be centralized
*/
