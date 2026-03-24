package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

public class Streams {

        public static void main(String[] args) {
                // Prob 1
                // Create a HashMap with String keys (name) and Integer values (age)
                Map<String, Integer> nameAgeMap = new HashMap<>();

                // Add entries to the HashMap
                nameAgeMap.put("Alice", 25);
                nameAgeMap.put("Bob", 30);
                nameAgeMap.put("Charlie", 28);
                nameAgeMap.put("Diana", 35);
                nameAgeMap.put("Eve", 22);

                // nameAgeMap.stream().filter(s -> s.age > 25).collect(Collectors.toList());

                // Filter entries where age > 25 and collect/print the names
                var result = nameAgeMap.entrySet().stream()
                                .filter(entry -> entry.getValue() > 25)
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList());

                System.out.println("People older than 25: " + result);

                // Alternative: Print as entries (name -> age)
                var resultEntries = nameAgeMap.entrySet().stream()
                                .filter(entry -> entry.getValue() > 25)
                                .collect(Collectors.toList());

                System.out.println("\nPeople older than 25 (with ages):");
                for (Map.Entry<String, Integer> entry : resultEntries) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                }

                // ---------------------------------------------------------------------------------------------------------------

                // 🟡 Prob 3. Frequency Count
                // boxed concept

                int[] nums = { 1, 2, 2, 3, 3, 3 };

                Map<Integer, Long> map = Arrays.stream(nums).boxed()
                                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

                // // Square each element, sort the array, and return
                int[] arr = Arrays.stream(nums).map(x -> x * x).sorted().toArray();

                int minVal = Arrays.stream(nums).min().getAsInt();
                int maxVal = Arrays.stream(nums).max().getAsInt();
                int maxSum = Arrays.stream(nums).sum();

                /*
                 * min() / max() might have no result (e.g., empty array) → so they return
                 * OptionalInt
                 * sum() always has a valid result → returns 0 if empty
                 */

                List<Integer> result1 = new ArrayList<>();
                int[] intArray = result1.stream().mapToInt(Integer::intValue).toArray();

                List<Integer> list = Arrays.asList(1, 2, 4, 5, 11, 15, 1);

                // Remove duplicates
                List<Integer> unique = list.stream()
                                .distinct()
                                .collect(Collectors.toList());

                System.out.println("Unique in list is -> " + unique);

                int min = list.stream()
                                .mapToInt(Integer::intValue)
                                .min()
                                .getAsInt();

                // 🔹 Max
                int max = list.stream()
                                .mapToInt(Integer::intValue)
                                .max()
                                .getAsInt();

                // 🔹 Sum
                int sum = list.stream()
                                .mapToInt(Integer::intValue)
                                .sum();



                // 🔴 6. Find First / Any
                Optional<Integer> first = list.stream()
                                .filter(x -> x > 10)
                                .findFirst();

                System.out.println("first in list is -> " + first);
        }
}

@SuppressWarnings("unused")
class StreamMock {

public static void main(String[] args) {
        // first non - repeating chars
        String str = "abbccde";

        Character ch = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting())
                )
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("Non- repeating -> " + str);

        // unique elements, sorted, only even numbers
        int[] nums = { 1, 2, 3, 4, 5, 6, 2, 3, 4 };

        List<Integer> result = Arrays.stream(nums).boxed()
                .filter(x -> x % 2 == 0)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Even sorted -> " + result);

        // only odd numbers, remove duplicates, sorted in ascending order return as
        // List<Integer>

        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9, 2);
        list.stream()
                .filter(x -> x % 2 != 0)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // strings starting with 'a' convert to uppercase sort by length (ascending)
        List<String> list1 = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");

        list1.stream()
                .filter(x -> x.startsWith("a"))
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        /*
         * ⚡ Key Learning (Important)
         * 👉 sorted() by default = alphabetical
         * 👉 For custom sorting:
         * Comparator.comparingInt(String::length)
         */

        // sum of squares of all elements
        List<Integer> list2 = Arrays.asList(10, 20, 30, 40);

        // frequency of each string output: Map<String, Long>

        list.stream()
                .map(x -> x * x)
                .mapToInt(Integer::intValue)
                .sum();

        list.stream()
                .mapToInt(x -> x * x)
                .sum();
        // Yes, Both are correct

        // frequency of each string Output: Map<String, Long>
        List<String> list3 = Arrays.asList("a", "bb", "ccc", "dd", "a");

        Map<String, Long> map = list3.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    // Alternative:
    // .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    // first non-repeating element
    List<String> list4 = Arrays.asList("java", "python", "java", "go", "python");
    String s = list4.stream().collect(
        Collectors.groupingBy(
            c -> c,
            LinkedHashMap::new,
            Collectors.counting()))
            .entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);

    // Top 3 unique largest numbers in descending order
    List<Integer> list5 = Arrays.asList(5, 3, 9, 1, 5, 3, 7);
    List<Integer> lis = list5.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .collect(Collectors.toList());

    // Count vowels in a string.
    String countVowels = "abebidofu";

    //char[] chars = countVowels.toCharArray();
    //Arrays.stream(chars).filter(x -> "aeiou".indexOf('x'))


        long vowelCount = countVowels
                .chars() // gives IntStream
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();

        System.out.println(vowelCount);
}
// Convert the 2nd set to an array
// return numSet2.stream().mapToInt(Integer::intValue).toArray();

// Prob 2
/*
 * class Person {
 * private String name;
 * private int age;
 * 
 * // constructor, getters
 * }
 * 
 * // Sample Input:
 * //List<Person> people = Arrays.asList(new Person("John", 22), new
 * Person("Alice", 30), new Person("Bob", 28));
 * 
 * // ⚠️ When Would It Be a Map?
 * 
 * // If input was like:
 * 
 * Map<String, Integer> map = Map.of("John", 22, "Alice", 30);
 * 
 * // Then you'd use:
 * // map.entrySet().stream()
 * 
 * /*
 * 👉 Because Maps don’t stream directly — you stream their entrySet()
 * 💬 Interview Tip
 * If unsure, say:
 * “I’m assuming people is a List of Person objects. If it's a Map, I’ll adapt
 * using entrySet().”
 * 
 * 👉 This shows maturity and flexibility
 * 
 */