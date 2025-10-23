import java.util.*;

public class SubsequencePrinter {

    // Function to print all subsequences of the array
    public static void printSubsequences(int[] arr, int index, List<Integer> current) {
        // Base case: If we have processed all elements
        if (index == arr.length) {
            // Print the current subsequence
            System.out.println(current);
            return;
        }

        // Include the current element in the subsequence
        current.add(arr[index]);
        printSubsequences(arr, index + 1, current);

        // Backtrack: Remove the current element from the subsequence
        current.remove(current.size() - 1);

        // Exclude the current element from the subsequence
        printSubsequences(arr, index + 1, current);
    }

    public static void main(String[] args) {
        // Example input array
        int[] arr = {1, 2, 3};

        // List to hold the current subsequence
        List<Integer> current = new ArrayList<>();

        // Call the function to print all subsequences
        printSubsequences(arr, 0, current);
    }
}
