package lcd.BoyerMoreVotingAlgo;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        // First pass: Find the candidate element
        for (int index = 0; index < nums.length; index++) {
            if (count == 0) {
                candidate = nums[index];
                count = 1;
            } else {
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
