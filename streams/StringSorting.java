import java.util.*;

public class StringSorting {
    public static void main(String[] args) {
        // 1. Sort a List of Strings (Ascending)
        List<String> list = new ArrayList<>(Arrays.asList("java", "stream", "api", "code"));
        Collections.sort(list);
        System.out.println(list);
        // ✅ Output: [api, code, java, stream]

        // 2. Using Streams (Modern way)
        List<String> sortedAscending = list.stream()
                .sorted()
                .toList();
        System.out.println(sortedAscending);

        // 3. Reverse Order
        List<String> reverseSorted = list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(reverseSorted);

        // 4. Sort by Length
        List<String> sortByLength = list.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
        System.out.println(sortByLength);

        // 5. Sort by Length (Descending)
        List<String> sortByLengthDesc = list.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .toList();
        System.out.println(sortByLengthDesc);

        // 6. Case-Insensitive Sorting
        List<String> caseInsensitive = new ArrayList<>(Arrays.asList("Java", "stream", "API", "code"));
        caseInsensitive.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(caseInsensitive);

        // 7. Sort Array of Strings
        String[] arr = {"java", "stream", "api", "code"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 8. Custom Sorting (Sort by last character)
        List<String> sortByLastChar = list.stream()
                .sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
                .toList();
        System.out.println(sortByLastChar);
    }
}
