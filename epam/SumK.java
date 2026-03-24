import java.util.Arrays;

public class SumK {

    public static int[] sumK(int[] nums, int k) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int limit = i - k + 1;

            int sum = 0;
            for (int j = limit; j <= i; j++) {

                if (j < 0) {
                    continue;
                } else {
                    sum += nums[j];
                }

            }
            arr[i] = sum;

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        // Output: [1,3,6,9,12]
        System.out.println(Arrays.toString(sumK(nums, k)));
    }
}

// 🔍 Summary

// ✅ Your logic is correct
// ⚠️ Slightly inefficient
// 🚀 Sliding window is better for large inputs

/*
| Pattern        | When used                       |
| -------------- | ------------------------------- |
| Sliding Window | Fixed size or positive numbers  |
| Prefix Sum     | Sum queries / negatives allowed |
| Kadane         | Max sum problems                |

Subarray Sum Equals K (LeetCode 560)
643 Maximum Average Subarray I
209 Minimum Size Subarray Sum
*/