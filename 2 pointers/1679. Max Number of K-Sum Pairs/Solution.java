import java.util.HashMap;
import  java.util.Map;


public class Solution {
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int target = k - num;
            if (map.containsKey(target) && map.get(target) > 0) {
                count++;
                map.put(target, map.get(target) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }
}
