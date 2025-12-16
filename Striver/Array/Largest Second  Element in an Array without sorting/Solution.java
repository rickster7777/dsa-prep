/*
The most efficient way to find the second largest element in an unsorted array is a single pass linear scan while tracking the largest and second largest elements.

✅ Optimal Approach (One Pass)
⏱ Time Complexity

O(n) → only one traversal

💾 Space Complexity

O(1) → constant extra space
*/


public static int findSecondLargest(int[] nums) {
    if (nums.length < 2) {
        throw new IllegalArgumentException("Array must have at least two elements");
    }

    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int num : nums) {
        if (num > largest) {
            secondLargest = largest;
            largest = num;
        } else if (num > secondLargest && num < largest) {
            secondLargest = num;
        }
    }

    if (secondLargest == Integer.MIN_VALUE) {
        throw new IllegalArgumentException("No second largest element");
    }

    return secondLargest;
}
