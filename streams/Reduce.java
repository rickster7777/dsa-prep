package streams;
import java.util.*;
import java.util.stream.*;

public class Reduce {

        public static void main(String[] args) {
                List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
                int sum = numbers.stream()
                        .reduce(0, Integer::sum); // Identity is 0 for sum
                System.out.println("Sum: " + sum); // Output: Sum: 15
        
                int product = numbers.stream()
                        .reduce(1, (a, b) -> a * b); // Identity is 1 for product
                System.out.println("Product: " + product); // Output: Product: 120
        
                Optional<Integer> max = numbers.stream()
                        .reduce(Integer::max); // No identity, returns Optional
                max.ifPresent(m -> System.out.println("Max: " + m)); // Output: Max: 5

        }
        
}
