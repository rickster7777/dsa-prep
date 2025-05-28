class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2)); // 1
        System.out.println(obj.sumRange(2, 5)); // -1
        System.out.println(obj.sumRange(0, 5)); // -3
    }
}

/*
 * 📌 Summary
 * Approach                         Prefix Array Size    Handles left = 0 cleanly?    Extra Condition?
 * prefix[right + 1] - prefix[left]        n + 1                ✅ Yes                      ❌ No

 * prefix[right] - prefix[left - 1]         n                   ❌ (Needs special case)       ✅ Yes

 * So yes — both approaches work, but the n + 1 style is often used in
 * interviews and clean implementations to avoid conditional logic.

 * Let me know if you want to see both approaches in Java or JS!
 */