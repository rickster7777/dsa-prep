import java.util.*;
import java.util.stream.Collectors;

public class SolutionStream {
    public static int[] intersection(int[] nums1, int[] nums2) {
        // Convert arrays to Sets using Streams
        Set<Integer> numSet1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> numSet2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        // Retain only common elements
        numSet1.retainAll(numSet2);

        // Convert the result back to an int array
        // return numSet1.stream().mapToInt(Integer::intValue).toArray();
        // To Use it method return type should be updated OptionalInt
        // return numSet1.stream()
        //         .mapToInt(Integer::intValue)
        //         .reduce((a, b) -> a + b)
        //            .orElse(0);

        //OR
        // To Use it method return type should be updated int
        // return numSet1.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [2]
    }
}
