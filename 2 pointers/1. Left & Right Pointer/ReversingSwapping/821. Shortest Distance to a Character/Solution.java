
import static java.lang.System.out;
import java.util.Arrays;

public class Solution {
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        int prev = Integer.MIN_VALUE / 2; // so subtraction doesn't overflow

        // Left to right pass
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }

        // Right to left pass
        prev = Integer.MAX_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }

    public static void main(String[] args) {

        String s = "loveleetcode";
        char c = 'e';
        int[] result = Solution.shortestToChar(s, c);
        out.println(Arrays.toString(result)); // Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

    }

}

/*
 * public int[] shortestToChar(String s, char c) {
 * 
 * List<Integer> list = new ArrayList<>();
 * List<Integer> result = new ArrayList<>();
 * 
 * i was doing this
 * return result.toArray();
 * 
 * how to convert result to array and return it ????
 * 
 * correct way
 * // Convert List<Integer> to int[]
 * int[] arr = new int[result.size()];
 * for (int i = 0; i < result.size(); i++) {
 * arr[i] = result.get(i);
 * }
 * return arr;
 * 
 */

/*
 * 
 * i've already completed the Logic just help me return it
 * import java.util.*;
 * 
 * class Solution {
 * public int[] shortestToChar(String s, char c) {
 * 
 * List<Integer> list = new ArrayList<>();
 * List<Integer> result = new ArrayList<>();
 * 
 * char[] chars = s.toCharArray();
 * 
 * for (int i = 0; i < chars.length; i++) {
 * if (chars[i] == c) {
 * list.add(i);
 * }
 * }
 * 
 * for (int i = 0; i < chars.length; i++) {
 * if (chars[i] != c) {
 * 
 * int j = 0;
 * int maxMin = Integer.MAX_VALUE;
 * 
 * while (j < list.size()) {
 * int min = Math.abs(chars[i] - list.get(j));
 * maxMin = Math.min(min, maxMin);
 * }
 * result.add(maxMin);
 * } else {
 * result.add(0);
 * }
 * }
 * 
 * return result.toArray();
 * }
 * }
 * 
 */