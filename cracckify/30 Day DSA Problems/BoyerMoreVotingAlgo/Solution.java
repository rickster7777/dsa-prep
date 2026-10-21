package Striver.ArrayMed.BoyerMoreVotingAlgo;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        // First pass: Find the candidate element
        for (int index = 0; index < nums.length; index++) {

            // If count drops to 0, we pick a new candidate
            // This works because the majority element appears more than n/2 times
            if (count == 0) {
                candidate = nums[index];
                count = 1;
            } else {
                // Increment or decrement count based on current element
                // If it matches the candidate, increment count
                // Otherwise, decrement count
                if (candidate == nums[index]) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return candidate;
        // // Second pass: Verify if the candidate is actually the majority element
        // count = 0;
        // for (int num : nums) {
        //     if (num == candidate) {
        //         count++;
        //     }
        // }

        // // Return the candidate only if it occurs more than half the time
        // if (count > nums.length / 2) {
        //     return candidate;
        // }

        // return -1; // If no majority element, return a placeholder (or handle as needed)
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 3, 3, 4 };
        solution.majorityElement(nums);
    }
}
