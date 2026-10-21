
import java.util.ArrayList;
import java.util.List;


/*
Given a sorted integer array arr, two integers k and x, return
the k closest integers to x in the array. The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
 */

/*
Solution Explanation:
This code uses binary search to find the starting index of the best contiguous window of `k` elements in a sorted array.
Since a window can start anywhere from index `0` through `arr.length - k`, `low` and `high` bound the possible starting indices.

At each step, `mid` is a candidate starting index. The code compares `arr[mid]`, the left edge of that candidate window,
with `arr[mid + k]`, the first element just beyond the window. If `x - arr[mid]` is greater than `arr[mid + k] - x`,
the element just beyond the window is closer to `x` than the window’s leftmost element. So the window should shift right,
and the search continues from `mid + 1`. Otherwise, the current window may be the answer, so the search keeps `mid` as a
possibility by setting `high = mid`.

Java’s integer division truncates toward zero; because `low` and `high` are nonnegative here, `(low + high) / 2` gives
the same result as rounding down. When `low == high`, the search has found the window’s starting index. The `k` closest
elements are then `arr[low]` through `arr[low + k - 1]`.
*/
public class Sol1 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        // STEP 1: setting high to arr.length - k because we want to find the starting index of the k closest elements
        int high = arr.length - k;

        while (low < high) {
            // STEP 2: Calculate mid index between low and high
            int mid = (low + high) / 2;
            //STEP 3: Compare the distance between x and both ends of the window
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Build result from the window starting at 'low'
        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Sol1 solution = new Sol1();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> closestElements = solution.findClosestElements(arr, k, x);
        System.out.println(closestElements); // Output: [1, 2, 3, 4]

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9};
        int k2 = 4;
        int x2 = 4;
        List<Integer> closestElements2 = solution.findClosestElements(arr2, k2, x2);
        System.out.println(closestElements2); // Output: [2,3,4,5]
    /*
    Both `[2, 3, 4, 5]` and `[3, 4, 5, 6]` have the same distances from `x = 4`: `0, 1, 1, 2`.
    When distances tie, the problem chooses the **smaller elements**, so `[2, 3, 4, 5]` wins.

    In the binary search, when the left and right candidates are equally distant,
    the `else` branch moves `high` leftward, preserving the window with the smaller values.
      */
    }
}

