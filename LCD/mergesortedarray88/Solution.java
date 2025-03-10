package lcd.mergesortedarray88;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // STEP 1: if n  is 0 return
        if (n == 0) {
            return;
        }

        // STEP 2: if m == 0 and n is non zero then while(j >= 0) assign values of nums2 to nums1 from backwards.
        if (m == 0) {
            while (j >= 0) {
                nums1[j] = nums2[j];
                j--;
            }
            return;
        }

        // STEP 3: when m and n both are non zero loopimg backwards and comparing
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

        // STEP 4: if there are still elements left in nums2. AND nums1 will always be greater than nums2 that's why checking this only for nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;

        solution.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

    }
    // when using merge function as static
    // public static void main(String[] args) {
    //
    // int[] nums1 = {1,2,3,0,0,0};
    // int m = 3;
    // int[] nums2 ={2,5,6};
    // int n = 3;

    // merge(nums1, m, nums2, n);

    // System.out.println(Arrays.toString(nums1));

    // }
}