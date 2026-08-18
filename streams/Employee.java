import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 70000),
                new Employee("Bob", "HR", 50000),
                new Employee("Charlie", "IT", 90000),
                new Employee("David", "HR", 60000),
                new Employee("Eve", "Finance", 75000));

        // 1. Find highest salary employee
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("highestPaid" + highestPaid);

        highestPaid.ifPresent(System.out::println); // Charlie (90000.0)

        // 2. 🔥 If you want highest salary per department (important variation)

        Map<String, Optional<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println("highest salary per department "+  result);


        // 3. Group employees department
        Map<String, List<Employee>> groupDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("group department:" + groupDept);

        // 4. Find average salary per department
        Map<String, Double> avgDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("average salary per department:" + avgDept);
        // average salary per department:{Finance=75000.0, HR=55000.0, IT=80000.0}

        // 5. Sort employees by salary
        List<Employee> empSortSalary = employees.stream().
        sorted(Comparator.comparingDouble(Employee::getSalary))
        .collect(Collectors.toList());


        System.out.println("employees by salary"+empSortSalary);
        // employees by salary[Bob (50000.0), David (60000.0), Alice (70000.0), Eve (75000.0), Charlie (90000.0)]

        // 6. Sort employees by salary in descending order
        List<Employee> empSortSalaryDesc = employees.stream().
        sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
        .collect(Collectors.toList());
        System.out.println("employees by salary (descending): " + empSortSalaryDesc);

        // 7. Filter employees with salary greater than 70 k
        List<Employee> empSalary70 = employees.stream().filter(x -> x.getSalary() > 70000).collect(Collectors.toList());
        System.out.println("salary greater than 70 k"+ empSalary70);
        // salary greater than 70 k[Charlie (90000.0), Eve (75000.0)]
        /*
         downstream collectors
         | Operation | Collector | Return Type |
         | --------- | ------------------- | ------------- |
         | Max | `maxBy()` | `Optional<T>` |
         | Min | `minBy()` | `Optional<T>` |
         | Average | `averagingDouble()` | `Double` |
         | Sum | `summingDouble()` ✅ | `Double` |

         */
        // Map<String, Optional<Employee>> result = employees.stream()
        // .collect(Collectors.groupingBy(
        // Employee::getDepartment,
        // Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        // System.out.println(result);
    }
}
/*
 * 🔹 Explanation
 * 
 * groupingBy(Employee::getDepartment)
 * Groups all employees by their department:
 * 
 * IT → [Alice, Charlie]
 * HR → [Bob, David]
 * Finance → [Eve]
 * Collectors.maxBy(Comparator.comparing(Employee::getSalary))
 * Finds the employee with the highest salary in each department.
 * Optional<Employee>
 * maxBy returns an Optional because the group might be empty.
 * Here, every department has at least one employee.
 * 
 * 🔹 Optional: If you want just Employee without Optional
 * Map<String, Employee> result2 = employees.stream()
 * .collect(Collectors.groupingBy(
 * Employee::getDepartment,
 * Collectors.collectingAndThen(
 * Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
 * Optional::get
 * )
 * ));
 * 
 * Output:
 * 
 * {
 * IT=Charlie (90000.0),
 * HR=David (60000.0),
 * Finance=Eve (75000.0)
 * }
 */