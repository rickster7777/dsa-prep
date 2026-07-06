import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EmployeeRevision {
        public static void main(String[] args) {
                // Easy: 1. even numbers from a list
                List<Integer> list = Arrays.asList(7, 7, 2, 3, 4, 5, 6, 1);
                System.out.println("Even numbers: " + list.stream()
                                .filter(x -> x % 2 == 0)
                                .collect(Collectors.toList()));

                // Easy: 2. convert strings to uppercase
                List<String> lis = Arrays.asList("hello", "world");
                System.out.println("Uppercase: " + lis.stream()
                                .map(String::toUpperCase)
                                .collect(Collectors.toList()));

                // Easy: 3. sort ascending and descending
                System.out.println("Sorted ascending: " + list.stream()
                                .sorted()
                                .collect(Collectors.toList()));

                // With stream
                System.out.println("Sorted descending: " + list.stream()
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList()));

                /*
                 * collect(Collectors.toList()) creates a new list containing the sorted
                 * elements.
                 * The original list remains unchanged.
                 */

                // Without stream
                list.sort(Collections.reverseOrder());

                /*
                 * Sorts the existing list in place.
                 * No new list is created.
                 * The original list is modified.
                 */

                // Easy: 4. distinct values
                System.out.println("Distinct values: " + list.stream()
                                .distinct()
                                .collect(Collectors.toList()));

                // Easy: 5. find first element
                Optional<Integer> first = list.stream().findFirst();
                System.out.println("First element: " + first.orElse(null));

                // Easy: 6. filter strings starting with A
                List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Cherry");
                System.out.println("Starts with A: " + strings.stream()
                                .filter(x -> x.startsWith("A"))
                                .collect(Collectors.toList()));

                // 6.1 Check if all numbers positive
                boolean allPositive = list.stream().allMatch(x -> x > 0);
                System.out.println("All numbers positive: " + allPositive);

                // 6.2 Check if any number negative
                boolean hasNegative = list.stream()
                                .anyMatch(x -> x < 0);
                System.out.println("Has negative number: " + hasNegative);

                // 6.3 Skip first 5 elements
                System.out.println("After skipping first 5 elements: " + list.stream()
                                .skip(5)
                                .collect(Collectors.toList()));
                // Medium: define Employee and use stream operations on employees
                List<Employee> employees = Arrays.asList(
                                new Employee(1, "Alice", "HR", 55000),
                                new Employee(2, "Bob", "IT", 72000),
                                new Employee(3, "Charlie", "IT", 68000),
                                new Employee(4, "Diana", "HR", 59000),
                                new Employee(5, "Eve", "Finance", 81000));

                // 7. Highest paid employee
                Optional<Employee> highestPaid = employees.stream()
                                .max(Comparator.comparing(Employee::getSalary));
                System.out.println("Highest paid: " + highestPaid.orElse(null));
                
                //using maxBy
                Optional<Employee> highestPaid1 = employees.stream()
                                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
                System.out.println("Highest paid (using maxBy): " + highestPaid1.orElse(null));
                // printing just name of the highest paid employee
                String highestPaidName = employees.stream()
                                .max(Comparator.comparing(Employee::getSalary))
                                .map(Employee::getName)
                                .orElse(null);
                System.out.println("Highest paid name: " + highestPaidName);

                // 8. Second highest paid employee: sort descending and skip the first one
                Optional<Employee> secondHighest = employees.stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .skip(1)
                                .findFirst();
                System.out.println("Second highest paid: " + secondHighest.orElse(null));
                // name of the second highest paid employee
                String secondHighestName = employees.stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .skip(1)
                                .map(Employee::getName)
                                .findFirst()
                                .orElse(null);
                System.out.println("Second highest paid name: " + secondHighestName);

                // We can use map after findfirst as well
                String secondHighestPaidEmployeeName = employees.stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .skip(1)
                                .findFirst()
                                .map(Employee::getName)
                                .orElse(null);
                System.out.println("Second highest paid employee name: " + secondHighestPaidEmployeeName);

                // 8.1 Find nth highest salary
                int n = 3;
                employees.stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .skip(n - 1)
                                .findFirst();

                // 9. Group employees by department
                Map<String, List<Employee>> byDept = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment));
                System.out.println("Group by department: " + byDept);

                // Printing just names of employees in each department
                Map<String, List<String>> namesByDept = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.mapping(Employee::getName, Collectors.toList())));
                System.out.println("Names by department: " + namesByDept);

                // 10. Count employees by department
                Map<String, Long> countByDept = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
                System.out.println("Count by department: " + countByDept);

                // 11. Find duplicate values in a list
                List<Integer> values = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);
                Set<Integer> seen = new HashSet<>();
                List<Integer> duplicates = values.stream()
                                .filter(x -> !seen.add(x))
                                .collect(Collectors.toList());
                System.out.println("Duplicates: " + duplicates);

                // 12. Average salary overall
                double avgSalary = employees.stream()
                                .collect(Collectors.averagingDouble(Employee::getSalary));
                System.out.println("Average salary: " + avgSalary);

                // 12.1 Average salary per department
                Map<String, Double> avgSalaryByDept = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.averagingDouble(
                                                                Employee::getSalary)));
                System.out.println("Average salary by department: " + avgSalaryByDept);

                // 13. Sum salary department-wise
                Map<String, Double> sumSalaryByDept = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.summingDouble(
                                                                Employee::getSalary)));
                System.out.println("Salary sum by department: " + sumSalaryByDept);

                // 14. Highest salary per department
                Map<String, Optional<Employee>> highestSalaryByDept = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.maxBy(
                                                                Comparator.comparing(
                                                                                Employee::getSalary))));
                System.out.println("Highest salary employee by department: " + highestSalaryByDept);

                // only the 2nd highest-paid employee in each department
                Map<String, Optional<Employee>> secondHighestByDept = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.collectingAndThen(
                                                                Collectors.toList(),
                                                                listd -> listd.stream().sorted(Comparator.comparing(
                                                                                Employee::getSalary)
                                                                                .reversed())
                                                                                .skip(1)
                                                                                .findFirst())));

                System.out.println("second highest paid per dept"+ secondHighestByDept);

                // 13. Partition employees by salary > 50000
                Map<Boolean, List<Employee>> partitioned = employees.stream()
                                .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
                System.out.println("Partitioned by salary > 50000: " + partitioned);

                // 14. Sort by department then salary
                List<Employee> sortedMulti = employees.stream()
                                .sorted(Comparator.comparing(Employee::getDepartment)
                                                .thenComparing(Employee::getSalary))
                                .collect(Collectors.toList());
                System.out.println("Sorted by department then salary (again): " + sortedMulti);
                // 14.1 we can chain as many thenComparing we want ?
                /*
                 * List<Employee> sortedEmployees = employees.stream()
                 * .sorted(Comparator.comparing(Employee::getDepartment)
                 * .thenComparing(Employee::getSalary)
                 * .thenComparing(Employee::getName)
                 * .thenComparing(Employee::getAge)
                 * .thenComparing(Employee::getJoiningDate)
                 * .thenComparing(Employee::getCity))
                 * .collect(Collectors.toList());
                 * 
                 * 
                 * if some descending fields are required
                 * List<Employee> sortedEmployees = employees.stream()
                 * .sorted(
                 * Comparator.comparing(Employee::getDepartment)
                 * .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                 * .thenComparing(Employee::getName)
                 * .reversed()
                 * )
                 * .collect(Collectors.toList());
                 * 
                 */

                // 15. Convert employee list to maps
                // By id
                Map<Integer, Employee> idToEmployee = employees.stream()
                                .collect(Collectors.toMap(Employee::getId, e -> e));
                System.out.println("ID to employee map: " + idToEmployee);

                // By name
                Map<Integer, String> idToName = employees.stream()
                                .collect(Collectors.toMap(Employee::getId, Employee::getName));
                System.out.println("ID to name map: " + idToName);

                // Advanced

                // 16. Highest Salary Employee Per Department
                // One of the MOST asked stream interview problems.

                // Solution
                Map<String, Optional<Employee>> result = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.maxBy(
                                                                Comparator.comparing(
                                                                                Employee::getSalary))));
                // Better Version (Without Optional)
                // Interviewers like this refinement.

                Map<String, Employee> result1 = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.collectingAndThen(
                                                                Collectors.maxBy(
                                                                                Comparator.comparing(
                                                                                                Employee::getSalary)),
                                                                Optional::get)));

                // nth highest salary employee per department
                int n1 = 2;
                Map<String, Employee> nthHighestByDept = employees.stream().collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                list1 -> list1.stream()
                                                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                                                .skip(n1 - 1)
                                                                .findFirst()
                                                                .orElse(null))));
                System.out.println("Nth highest salary employee per department: " + nthHighestByDept);

                // 20. Complex Reduce Operation
                // Find employee with longest name.
                Optional<Employee> resultRed = employees.stream()
                                .reduce((e1, e2) -> e1.getName().length() > e2.getName().length() ? e1 : e2);

                // Section 3 — String Problems
                // 21. Find duplicate characters
                // Example:
                String str = "Hello";
                Set<Character> set = new HashSet<>();

                str.chars()
                                .mapToObj(c -> (char) c)
                                .filter(c -> !set.add(c))
                                .forEach(System.out::println);

                // 22. Find non-repeating character
                Optional<Character> nonRepeating = str.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(
                                                c -> c, // or Function.identity()
                                                LinkedHashMap::new,
                                                Collectors.counting()))
                                .entrySet()
                                .stream()
                                .filter(e -> e.getValue() == 1)
                                .map(Map.Entry::getKey)
                                .findFirst();
                System.out.println("First non-repeating character: " + nonRepeating);

                // 23. Count frequency of characters
                str.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(
                                                c -> c,
                                                Collectors.counting()));

                // 24. Reverse each word
                String reverseWord = Arrays.stream(str.split(" "))
                                .map(x -> new StringBuilder(x)
                                                .reverse()
                                                .toString())
                                .collect(Collectors.joining(" "));
                System.out.println("Reversed words: " + reverseWord);

                // 25. Find longest string
                List<String> longest = Arrays.asList("apple", "banana", "kiwi", "strawberry");

                Optional<String> longestString = longest.stream().max(Comparator.comparing(String::length));
                System.out.println("Longest string: " + longestString);

                // Section 4 — List/Map Transformations
                // 26. Convert List to Map
                Map<Integer, Employee> idToEmployeeMap = employees.stream()
                                .collect(Collectors.toMap(
                                                Employee::getId,
                                                e -> e));

                // 27. Convert Map values to List
                // List<Employee> employeeListFromMap = new ArrayList<>(map.values());

                // 28. Flatten nested lists
                // List<String> flattenedList = nested.stream()
                // .flatMap(Collection::stream)
                // .collect(Collectors.toList());

                // 29. Convert list of strings to comma-separated string
                // String commaSeparated = list.stream()
                // .collect(Collectors.joining(","));

                // 30. Collect into Set
                // Set<Integer> uniqueValues = list.stream()
                // .collect(Collectors.toSet());

                // Section 5 — reduce() Questions
                // 31. Sum all numbers
                // Integer sum = list.stream()
                // .reduce(0, Integer::sum);
                // Integer sum = list.stream()
                // .reduce(0, (a,b) -> a+b);

                // 32. Multiply all numbers
                // Integer product = list.stream()
                // .reduce(1, (a,b) -> a*b);
                // Integer product = list.stream()
                // .reduce(1, Integer::multiply);

                // 33. Find maximum number
                // Optional<Integer> maxNumber = list.stream()
                // .reduce(Integer::max);

                // 34. Find minimum number
                // Optional<Integer> minNumber = list.stream()
                // .reduce(Integer::min);

                // 35. Concatenate strings
                // String concatenated = list.stream()
                // .reduce("", (a,b) -> a+b);

                // Section 6 — flatMap() Questions
                // 36. Flatten list of lists
                // List<String> flatList = nested.stream()
                // .flatMap(List::stream)
                // .collect(Collectors.toList());

                // 37. Get all employee names from departments
                // List<String> departmentNames = departments.stream()
                // .flatMap(
                // d -> d.getEmployees().stream()
                // )
                // .map(Employee::getName)
                // .collect(Collectors.toList());

                // 38. Flatten Optional values
                // List<Integer> flattenedOptionals = list.stream()
                // .flatMap(Optional::stream)
                // .collect(Collectors.toList());

                // Section 7 — Advanced Collectors
                // 39. groupingBy + mapping
                Map<String, List<String>> namesByDepartment = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.mapping(
                                                                Employee::getName,
                                                                Collectors.toList())));
                System.out.println("Names by department: " + namesByDepartment);

                // 40. collectingAndThen
                List<Employee> unmodifiableEmployeeList = employees.stream()
                                .collect(Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                Collections::unmodifiableList));
                System.out.println("Unmodifiable employee list: " + unmodifiableEmployeeList);

                // 41. TreeMap grouping
                Map<String, List<Employee>> employeesByDeptTreeMap = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                TreeMap::new,
                                                Collectors.toList()));
                System.out.println("TreeMap grouping by department: " + employeesByDeptTreeMap);

                // 42. Concurrent grouping
                Map<String, List<Employee>> concurrentGroupByDept = employees.parallelStream()
                                .collect(Collectors.groupingByConcurrent(
                                                Employee::getDepartment));
                System.out.println("Concurrent grouping by department: " + concurrentGroupByDept);

                // Section 8 — Optional Questions
                // 43. Optional vs null
                // Interview theory question.
                // Important:
                // avoids NullPointerException - Optional forces you to handle missing values
                // expressive API - clear intent that value may not be present
                // functional style - enables method chaining and functional operations

                System.out.println("\n--- Optional vs null Example ---");
                // Bad: Using null (old way)
                Employee nullEmployee = null; // Dangerous - can cause NPE
                // if (nullEmployee != null && nullEmployee.getSalary() > 50000) { } // Verbose checking

                // Good: Using Optional
                Optional<Employee> optionalEmployee = employees.stream()
                                .filter(e -> e.getId() == 2)
                                .findFirst();
                // optionalEmployee.ifPresent(e -> System.out.println("Found: " + e));
                // Safe, expressive, and functional

                // 44. Difference between orElse and orElseGet
                System.out.println("\n--- orElse vs orElseGet Example ---");
                
                // IMPORTANT: orElse ALWAYS evaluates the default value
                System.out.println("Using orElse:");
                Employee emp1 = employees.stream()
                                .filter(e -> e.getId() == 1)
                                .findFirst()
                                .orElse(createDefaultEmployee()); // getValue() ALWAYS executes even if Optional has value
                
                // orElseGet uses lazy evaluation - only executes if Optional is empty
                System.out.println("Using orElseGet:");
                Employee emp2 = employees.stream()
                                .filter(e -> e.getId() == 1)
                                .findFirst()
                                .orElseGet(() -> createDefaultEmployee()); // Only executes if Optional is empty
                
                // Performance difference example:
                Optional<String> opt = Optional.of("John");
                String result1 = opt.orElse(expensiveOperation()); // expensiveOperation() is called ALWAYS
                String result2 = opt.orElseGet(() -> expensiveOperation()); // expensiveOperation() NOT called
                
                System.out.println("result2: " + result2); // "John"
                // 45. Optional map()
                // optional.map(String::toUpperCase);
                // Section 9 — Stream Internals
                // 46. Difference between map and flatMap
                // MOST ASKED THEORY QUESTION.
                // map
                // One-to-one transformation.
                // flatMap
                // One-to-many flattening.
                // 47. Difference between collect and reduce
                // reduce
                // Produces single value.
                // collect
                // Produces collection/container.
                // 48. Lazy evaluation in streams
                // Streams execute only after terminal operation.
                // 49. Stateful vs stateless operations
                // Stateless
                // map
                // filter
                // Stateful
                // sorted
                // distinct
                // 50. Parallel Stream Problems
                // Interviewers often ask:
                // thread safety
                // ordering
                // shared mutable state
                // fork join pool
                // Example:
                // list.parallelStream()

        }

        static class Employee {
                private final int id;
                private final String name;
                private final String department;
                private final double salary;

                Employee(int id, String name, String department, double salary) {
                        this.id = id;
                        this.name = name;
                        this.department = department;
                        this.salary = salary;
                }

                int getId() {
                        return id;
                }

                String getName() {
                        return name;
                }

                String getDepartment() {
                        return department;
                }

                double getSalary() {
                        return salary;
                }

                @Override
                public String toString() {
                        return String.format("%s(%s,%.0f)", name, department, salary);
                }
        }

        // Helper method for Optional examples
        static Employee createDefaultEmployee() {
                System.out.println("  -> createDefaultEmployee() was called");
                return new Employee(0, "Default", "Unknown", 0);
        }

        // Simulates an expensive operation
        static String expensiveOperation() {
                System.out.println("  -> expensiveOperation() was called (expensive!)");
                try {
                        Thread.sleep(100); // Simulate expensive work
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                return "Default Value";
        }
}
