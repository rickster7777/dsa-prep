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
    
    // STEP 1: if n is 0 return
    if (n === 0) {
        return;
    }


   // STEP 2: if m == 0 and n is non zero then while(j >= 0) assign values of nums2 to nums1 from backwards.
    if (m === 0) {
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
        }
        return;
    }

    // STEP 3: when m and n both are non zero loopimg backwards and comparing
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

    // STEP 4: if there are still elements left in nums2. AND nums1 will always be greater than nums2 that's why checking this only for nums2
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

