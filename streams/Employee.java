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

        Map<String, Optional<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.println(result);
    }
}
/*
🔹 Explanation

groupingBy(Employee::getDepartment)
Groups all employees by their department:

IT → [Alice, Charlie]
HR → [Bob, David]
Finance → [Eve]
Collectors.maxBy(Comparator.comparing(Employee::getSalary))
Finds the employee with the highest salary in each department.
Optional<Employee>
maxBy returns an Optional because the group might be empty.
Here, every department has at least one employee.
🔹 Optional: If you want just Employee without Optional
Map<String, Employee> result2 = employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.collectingAndThen(
            Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
            Optional::get
        )
    ));

Output:

{
 IT=Charlie (90000.0),
 HR=David (60000.0),
 Finance=Eve (75000.0)
}
*/