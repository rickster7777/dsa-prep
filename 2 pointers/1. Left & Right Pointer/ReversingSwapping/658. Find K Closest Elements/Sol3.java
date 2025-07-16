import java.util.ArrayList;
import java.util.List;

public class Sol3 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Sol3 solution = new Sol3();
        int[] arr = {1,1,2,3,4,5};
        int k = 4;
        int x = -1;
        List<Integer> closestElements = solution.findClosestElements(arr, k, x);
        System.out.println("Output: " + closestElements); // Output: [1,1,2,3]
    }
}
