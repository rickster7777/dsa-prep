
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static Map<Character, List<String>> groupFirstLetterStream(String[] letters) {

        Map<Character, List<String>> map = Arrays.stream(letters).collect(Collectors.groupingBy(s -> s.charAt(0)));

        return map;
    }

    public static Map<Character, List<String>> groupFirstLetter(String[] letters) {
        Map<Character, List<String>> map = new HashMap<>();

        for (String letter : letters) {
            if (letter.length() > 0) {
                char firstChar = letter.charAt(0);
                map.putIfAbsent(firstChar, new ArrayList<>());
                map.get(firstChar).add(letter);
            }
        }

        return map;
    }

    public static void main(String[] args) {

        String[] strings = { "apple", "banana", "apricot", "blueberry", "cherry" };
        System.out.println(groupFirstLetterStream(strings));

    }
}
