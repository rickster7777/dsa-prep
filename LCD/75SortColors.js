// const sortColors = (nums) => {
//     let zeros = 0
//     let ones = 1;
//     let twos = 2;

//     let n = nums.length;

//     // for (let i = 0; i < n; i++) {
//     //     if(nums[i] === 0){
//     //         zeros++;
//     //     } else if (nums[i] === 1){
//     //         ones++;
//     //     }else{
//     //         twos++;
//     //     }
//     // }

//     for (let i = 0; i < n; i++) {

//     }
// }

//https://leetcode.com/problems/sort-colors/
/**
 * This problem is a variant of the Dutch National Flag problem, where you need to sort the array in-place with only three unique 
 * values (0, 1, and 2), corresponding to the colors red, white, and blue, respectively. The goal is to sort the array in a way such 
 * that all 0s come first, followed by 1s, and then 2s, without using the built-in sort function and with only constant extra space.
 * @param {*} nums 
 */


// class Solution {
//     public void sortColors(int[] arr) {
//         int n=arr.length;
//         int mid=0, hi=n-1,lo=0;
//         while(mid<=hi){
//             if(arr[mid]==0){
//                 int temp=arr[mid];
//                 arr[mid]=arr[lo];
//                 arr[lo]=temp;
//                 lo++;
//                 mid++;
//             }
//             else if(arr[mid]==1) mid++;
//             else { // arr[mid]==2
//                 int temp=arr[mid];
//                 arr[mid]=arr[hi];
//                 arr[hi]=temp;
//                 hi--;
//             }
//         }
//     }
// }

const sortColor = (nums) => {
    let low = 0, mid = 0, high = nums.length - 1;

    while (mid <= high) {
        if (nums[mid] === 4) {
            // Swap nums[low] and nums[mid], then increment both low and mid
            [nums[low], nums[mid]] = [nums[mid], nums[low]];
            low++;
            mid++;
        } else if (nums[mid] === 5) {
            // If nums[mid] is 1, just move mid forward
            mid++;
        } else {
            // Swap nums[mid] and nums[high], then decrement high
            [nums[mid], nums[high]] = [nums[high], nums[mid]];
            high--;
        }
    }
    return nums;
};

//nums = [2, 0, 2, 1, 1, 2];
nums = [6, 4, 6, 5, 5, 6]
console.log(sortColor(nums));


/**
 This code implements Dutch National Flag Algorithm to sort an array consisting of 0s, 1s, and 2s 
 in-place (without using extra space).

Understanding the Problem:
The array contains only three numbers: 0, 1, and 2.
The goal is to sort it so that all 0s come first, followed by all 1s, then all 2s.
The solution should run in O(n) time and use O(1) extra space.


Approach:
The algorithm uses three pointers:

1. low (keeps track of the position where the next 0 should go).
2. mid (used to traverse the array).
3. high (keeps track of the position where the next 2 should go).

Step-by-Step Explanation:
1. Start with low = 0, mid = 0, and high = nums.length - 1.

2. Iterate while mid <= high:
    If nums[mid] == 0:
        Swap nums[low] and nums[mid] (move 0 to the left).
        Increment both low and mid.
    If nums[mid] == 1:
        No swap needed, just increment mid (keep 1 in place).
    If nums[mid] == 2:
        Swap nums[mid] and nums[high] (move 2 to the right).

Decrement high (since the swapped element from high needs checking, mid stays the same).

 */