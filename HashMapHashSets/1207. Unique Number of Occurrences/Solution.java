
import java.util.*;

public class Solution {
    /**
     * This method checks if the number of occurrences of each number in the array is unique.
     * It uses a HashMap to count occurrences and a HashSet to track unique counts.
     *
     * @param arr the input array of integers
     * @return true if all occurrences are unique, false otherwise
     */

    public static boolean uniqueOccurence(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num: arr){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> occurrences = new HashSet<>();

        occurrences.addAll(countMap.values());

        return occurrences.size() == countMap.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean result = uniqueOccurence(arr);
        System.out.println("Are the occurrences of each number unique? " + result);
    }
}
