import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {
        /*
         * 🔹 1. Count consonants in a string (similar to your vowel problem)
         * ❓ Problem:
         * 
         * Count all consonants in a string using streams.
         * 
         * ✅ Solution:
         * 
         */
        String str = "abebidofu";

        long count = str.toLowerCase()
                .chars()
                .filter(c -> Character.isLetter(c))
                .filter(c -> "aeiou".indexOf(c) == -1)
                .count();

        System.out.println(count);

        /*
         * 🔹 2. Find first non-repeated character
         * ❓ Problem:
         * 
         * Return the first non-repeating character in a string.
         * 
         * ✅ Solution:
         * 
         * import java.util.*;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String str = "swiss";
        
        Map<Character, Integer> freq = new LinkedHashMap<>();
        
        // Count frequency of each character
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Find first non-repeating character
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeating character: " + entry.getKey());
                return;
            }
        }
        
        System.out.println("No non-repeating character found");
    }
}
         * 
         */

        String str1 = "swiss";

        Character result = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result);

        /*
         * 🔹 3. Find duplicate elements in a list
         * ❓ Problem:
         * 
         * Print all duplicate numbers from a list.
         * 
         * ✅ Solution:
         */

        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 1);

        Set<Integer> seen = new HashSet<>();

        list.stream()
                .filter(n -> !seen.add(n))
                .forEach(System.out::println);

        /*
         * 🔹 4. Find second highest number
         * ❓ Problem:
         * 
         * Find the second largest number in a list.
         * 
         * ✅ Solution:
         * 
         */

        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);

        Integer secondHighest = list1.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        /*
         * System.out.println(secondHighest);
         * 🔹 5. Group words by length
         * ❓ Problem:
         * 
         * Group a list of words based on their length.
         * 
         * ✅ Solution:
         * 
         */

        List<String> words = Arrays.asList("java", "stream", "api", "code");

        Map<Integer, List<String>> result1 = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(result1);

        /*
         * 🔹 6. Convert list of strings to uppercase and join
         * ❓ Problem:
         * 
         * Convert all strings to uppercase and join with comma.
         * 
         * ✅ Solution:
         * 
         */

        List<String> list2 = Arrays.asList("epam", "interview", "java");

        String result2 = list2.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(result2);

        /*
         * 🔹 7. Find frequency of each character
         * ❓ Problem:
         * 
         * Count frequency of each character in a string.
         * 
         * ✅ Solution:
         */

        String str3 = "hello";

        Map<Character, Long> freq = str3.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(freq);

        // Partition numbers into even/odd using streams

        int[] nums2 = {1,2,3,4,5,6,7,8};

        Map<Boolean, List<Integer>> result4 =
            Arrays.stream(nums2)
                  .boxed()
                  .collect(Collectors.groupingBy(x -> x % 2 == 0));

        System.out.println(result4);

        // {false=[1, 3, 5], true=[2, 4, 6]}

        // 💡 If you want cleaner keys (Even/Odd instead of true/false):
        //   .collect(Collectors.groupingBy(x -> x % 2 == 0 ? "Even" : "Odd"));

        Map<Boolean, List<Integer>> result5 =
            Arrays.stream(nums2)
                  .boxed()
                  .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        System.out.println(result5);
        // {false=[1, 3, 5, 7], true=[2, 4, 6, 8]}

        // Use partitioningBy when:
        // You only need two groups (like even/odd, pass/fail, etc.)


        //Extract only the values from partitioningBy
        // .collect(Collectors.partitioningBy(x -> x % 2 == 0))
        // .values();

        List<List<Integer>> ordered = Arrays.asList(
                result5.get(false), // odd
                result5.get(true)   // even
        );

        System.out.println(ordered);


        //Check if 2 strings are anagrams using streams
         String s1 = "listen";
        String s2 = "silent";

        boolean isAnagram =
            s1.length() == s2.length() &&
            s1.chars().sorted()
              .boxed()
              .collect(Collectors.toList())
              .equals(
                  s2.chars().sorted()
                    .boxed()
                    .collect(Collectors.toList())
              );

        System.out.println(isAnagram);


        //Sort Map by Value (Ascending)
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 50);
        map.put("banana", 20);
        map.put("orange", 40);

        LinkedHashMap<String, Integer> sortedMap =
            map.entrySet()
               .stream()
               .sorted(Map.Entry.comparingByValue())
               .collect(Collectors.toMap(
                   Map.Entry::getKey,
                   Map.Entry::getValue,
                   (e1, e2) -> e1,
                   LinkedHashMap::new
               ));

        System.out.println(sortedMap);

        //2️⃣ Sort Map by Value (Descending)
        LinkedHashMap<String, Integer> sortedDesc =
        map.entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(
           Map.Entry::getKey,
           Map.Entry::getValue,
           (e1, e2) -> e1,
           LinkedHashMap::new
       ));

        System.out.println(sortedDesc);
        
}
}


/*
In Collections
To reverse a collection: Collections.reverse(list);

sort in descending order
1. Collections.sort(list, Collections.reverseOrder());
2. list.sort(Comparator.reverseOrder());


Integer[] arr = {5, 1, 3, 2, 4};
Arrays.sort(arr, Collections.reverseOrder());


// Primitive array in descending order
Arrays.sort(arr); // ascending

        // reverse array
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }


In streams
// integer list
.sorted()
.sorted(Comparator.reverseOrder())


// By length
.sorted(Comparator.comparingInt(String::length))
.sorted(Comparator.comparingInt(String::length).reversed())

// Map (by value)
.sorted(Map.Entry.comparingByValue())
.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())

// Map (by key)
.sorted(Map.Entry.comparingByKey()) 
.sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
*/
/*
swap variable without using extra variable

Arithmetic
int a = 5, b = 10;

        a = a + b; // a = 15
        b = a - b; // b = 5
        a = a - b; // a = 10

        System.out.println("a = " + a + ", b = " + b);



Binary
int a = 5, b = 10;

        a = a ^ b; // XOR step 1
        b = a ^ b; // XOR step 2
        a = a ^ b; // XOR step 3

        System.out.println("a = " + a + ", b = " + b);

| Feature     | `groupingBy`           | `partitioningBy`        |
| ----------- | ---------------------- | ----------------------- |
| Keys        | Any type               | Only `true` / `false`   |
| Use case    | Multiple groups        | Binary split            |
| Performance | Slightly more flexible | Slightly more optimized |



boxed() is used only when we're working with Arrays.stream() not when list.stream() ?

Yes—exactly. 👍

✅ Key idea:
.boxed() is needed when you're working with a primitive stream like IntStream, LongStream, etc.
It is NOT needed when you're already working with objects like List<Integer>.
🔍 Why?
1. Arrays.stream(int[]) → gives IntStream (primitive)
int[] arr = {1, 2, 3};

Arrays.stream(arr)   // IntStream
IntStream deals with primitive int
But collectors like groupingBy, partitioningBy require objects (Integer)
So you must convert → .boxed()
Arrays.stream(arr)
      .boxed()  // int → Integer
      .collect(Collectors.partitioningBy(x -> x % 2 == 0));


2. list.stream() → gives Stream<Integer> (already objects)
List<Integer> list = Arrays.asList(1, 2, 3);

list.stream()   // Stream<Integer>
Already Integer, so no conversion needed ✅
list.stream()
    .collect(Collectors.partitioningBy(x -> x % 2 == 0));


--------------------------------------------------------------------------------------------------

✅ When to use mapToInt() vs .boxed()
🔹 1. Use mapToInt() → when you want primitive operations (int)

Use it when:

You need numeric operations like sum(), average(), min(), max()
You want better performance (avoids boxing/unboxing)
You’re converting from objects → primitives
✅ Example:
List<Integer> list = Arrays.asList(1, 2, 3, 4);

// Sum using mapToInt
int sum = list.stream()
              .mapToInt(Integer::intValue)
              .sum();

System.out.println(sum); // 10

👉 Here:

Stream<Integer> → IntStream
Then you can use .sum() directly
✅ Another example (objects → int field):
class Person {
    int age;
}

int totalAge = people.stream()
                     .mapToInt(p -> p.age)
                     .sum();
🔹 2. Use .boxed() → when you need objects (Integer)

Use it when:

You started with a primitive stream (IntStream)
You need to use Collectors like:
groupingBy
partitioningBy
toList(), toSet()
✅ Example:
int[] arr = {1, 2, 3, 4};

List<Integer> list = Arrays.stream(arr)
                           .boxed()
                           .collect(Collectors.toList());
*/