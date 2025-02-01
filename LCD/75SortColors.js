const sortColors = (nums) => {
    let zeros = 0
    let ones = 1;
    let twos = 2;

    let n = nums.length;

    // for (let i = 0; i < n; i++) {
    //     if(nums[i] === 0){
    //         zeros++;
    //     } else if (nums[i] === 1){
    //         ones++;
    //     }else{
    //         twos++;
    //     }
    // }

    for (let i = 0; i < n; i++) {

    }
}


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
        if (nums[mid] === 0) {
            // Swap nums[low] and nums[mid], then increment both low and mid
            [nums[low], nums[mid]] = [nums[mid], nums[low]];
            low++;
            mid++;
        } else if (nums[mid] === 1) {
            // If nums[mid] is 1, just move mid forward
            mid++;
        } else {
            // Swap nums[mid] and nums[high], then decrement high
            [nums[mid], nums[high]] = [nums[high], nums[mid]];
            high--;
        }
    }
};
