// https://leetcode.com/problems/merge-sorted-array/description/

// var merge = function (nums1, m, nums2, n) {
//     let total = m + n - 1;
//     let numlength = n - 1;
//     //for(let i =0; i< n ; i++)
//     for (let i = numlength; i >= 0; i--) {
//         nums1[total] = nums2[i];
//         total--;
//     }

//     return nums1;
// };
var merge = function (nums1, m, nums2, n) {
    let i = m - 1;
    let j = n - 1;
    let k = m + n - 1

    if (n === 0) {
        return;
    }

    if (m === 0) {
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
        }
    }

    //Loopimg backwards and comparing

    while (i >= 0 && j >= 0) {
        //swapping backwards
        if(nums1[i] > nums2[j]){
            nums1[k] = nums1[i];
            i--;
            k--;
        }  else{
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    //nums1 will always be greater than nums2 that's why checking this only for nums2
    while (j >= 0) {
        nums1[k] = nums2[j];
        j--;
        k--;
    }

    return nums1;
};
const nums1 = [1, 2, 3, 0, 0, 0];
const m = 3;

const nums2 = [2, 5, 6];
const n = 3;

console.log(merge(nums1, m, nums2, n));


/**
 * solution in o(m + n) time
 */

/*
import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = n - 1; 
        int k = m + n - 1;

        
        if (n == 0) {
            return;
        }

        if (m == 0) {
            while (j >= 0) {
                nums1[j] = nums2[j];
                j--;
            }
            return;
        }

        //swapping as elements in both the arrays need to be compared.
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j]; 
                j--;
            }
            k--; 
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}

*/