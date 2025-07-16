import java.util.Arrays;

public class ProductExcept {
    public static int[] product(int[] nums) {

        int[] answer = new int[nums.length];

        int prefix = 1;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        int sufffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= sufffix;
            sufffix *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = ProductExcept.product(nums);

        System.out.println(Arrays.toString(result));
    }
}