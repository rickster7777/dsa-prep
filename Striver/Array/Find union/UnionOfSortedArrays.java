import java.util.ArrayList;
import java.util.List;

public class UnionOfSortedArrays {

    public static List<Integer> findUnion(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays using two pointers
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                // Add arr1[i] to result if it's not a duplicate
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                // Add arr2[j] to result if it's not a duplicate
                if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                }
                j++;
            } else {
                // If both are equal, add one and move both pointers
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        // Add remaining elements of arr1 if any
        while (i < arr1.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }

        // Add remaining elements of arr2 if any
        while (j < arr2.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        List<Integer> union = findUnion(arr1, arr2);

        System.out.println("Union of arrays: " + union);
    }
}
