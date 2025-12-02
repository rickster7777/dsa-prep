import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class miniMaxSumFive {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        // My approach

        // Long minSum = 0L, maxSum = 0L;

        // for (int i = 0; i < 5; i++) {
        // minSum += arr.get(i);

        // if (i == 4) {
        // minSum -= arr.get(i);
        // maxSum = minSum + arr.get(i) - arr.get(0);
        // }
        // }
        // System.out.println(minSum + " " + maxSum);

        // Cleaner approach
        // Sort the list
        Collections.sort(arr);

        // Sum all elements
        long totalSum = 0L;
        for (Integer num : arr) {
            totalSum += num;
        }

        // Min sum = total minus largest
        long minSum = totalSum - arr.get(arr.size() - 1);

        // Max sum = total minus smallest
        long maxSum = totalSum - arr.get(0);

        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {

        miniMaxSumFive.miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));

    }
}
