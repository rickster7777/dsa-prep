import java.util.Arrays;

public class KRadiiAverages {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1);

        if (k == 0)
            return nums;
        if (2 * k + 1 > n)
            return avgs; // Not enough elements for a full window

        long windowSum = 0;
        int windowSize = 2 * k + 1;

        // Initial window sum
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        avgs[k] = (int) (windowSum / windowSize);

        // Slide the window
        for (int i = k + 1; i < n - k; i++) {
            windowSum = windowSum - nums[i - k - 1] + nums[i + k];
            avgs[i] = (int) (windowSum / windowSize);
        }

        return avgs;
    }

    public static void main(String[] args) {
        KRadiiAverages obj = new KRadiiAverages();
        int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;
        System.out.println(Arrays.toString(obj.getAverages(nums, k)));
        // Output: [-1, -1, -1, 5, 4, 4, -1, -1, -1]
    }
}
