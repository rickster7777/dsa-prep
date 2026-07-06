/*

✅ When is Sliding Window correct?
✔ Only when all numbers are positive (or zero)


if it contains negative numbers then use hash map + prefix sum
*/


public class Solution {

    public int sumEqualsK(int[] arr, int k) {
        int left = 0, right = 0, sum = 0;
        int maxLen = 0;
        int n = arr.length;

        while (right < n) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;

    }

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int[] arr = { 1, -1, 5, -2, 3 };
        int k = 3;  
        System.out.println(sol.sumEqualsK(arr, k)); // Output: 4 (subarray [1, -1, 5, -2] sums to 3)    


    }
}
