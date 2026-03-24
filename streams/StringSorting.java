

import java.util.List;

public record StringSorting() {
    🔹 1. Sort a List of Strings (Ascending)
List<String> list = Arrays.asList("java", "stream", "api", "code");

Collections.sort(list);
System.out.println(list);
✅ Output
[api, code, java, stream]
🔹 2. Using Streams (Modern way)
List<String> sorted = list.stream()
        .sorted()
        .toList();

System.out.println(sorted);
🔹 3. Reverse Order
list.sort(Comparator.reverseOrder());

or

List<String> sorted = list.stream()
        .sorted(Comparator.reverseOrder())
        .toList();
🔹 4. Sort by Length
List<String> sorted = list.stream()
        .sorted(Comparator.comparing(String::length))
        .toList();
✅ Output
[api, java, code, stream]
🔹 5. Sort by Length (Descending)
List<String> sorted = list.stream()
        .sorted(Comparator.comparing(String::length).reversed())
        .toList();
🔹 6. Case-Insensitive Sorting
list.sort(String.CASE_INSENSITIVE_ORDER);
🔹 7. Sort Array of Strings
String[] arr = {"java", "stream", "api", "code"};

Arrays.sort(arr);
System.out.println(Arrays.toString(arr));
🔹 8. Custom Sorting (Example)

Sort by last character:

List<String> sorted = list.stream()
        .sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
        .toList();
🧠 Key Concepts
sorted() → returns a new sorted stream
Collections.sort() / list.sort() → modifies original list
Comparator → controls sorting logic
⚡ Interview Tip

Most asked pattern:

list.stream().sorted().toList();
}
