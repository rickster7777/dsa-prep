import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Brute Force Solution
    public static int countSubarraysWithXorKBruteForce(int[] nums, int K) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int xor = 0;
            for (int j = i; j < nums.length; j++) {
                xor ^= nums[j];
                if (xor == K) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countSubarraysWithXorK(int[] nums, int K) {
        int count = 0;
        int prefixXor = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1); // Base case: XOR of empty subarray is 0

        for (int num : nums) {
            prefixXor ^= num; // Update prefix XOR

            // Check if there exists a prefix XOR that when XORed with current prefixXor gives K
            int requiredXor = prefixXor ^ K;
            count += freqMap.getOrDefault(requiredXor, 0);

            // Update frequency map with current prefix XOR
            freqMap.put(prefixXor, freqMap.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        int K = 6;
        System.out.println(countSubarraysWithXorK(nums, K)); // Output: 4
    }
}
