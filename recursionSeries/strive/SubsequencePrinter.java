import java.util.ArrayList;
import java.util.List;

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



/*
Call: (0, [])
│
├── Include 1 → (1, [1])
│   │
│   ├── Include 2 → (2, [1, 2])
│   │   │
│   │   ├── Include 3 → (3, [1, 2, 3])
│   │   │   └── print [1, 2, 3] and return ↑
│   │   │
│   │   └── Exclude 3 → (3, [1, 2])
│   │       └── print [1, 2] and return ↑
│   │
│   └── Exclude 2 → (2, [1])
│       │
│       ├── Include 3 → (3, [1, 3])
│       │   └── print [1, 3] and return ↑
│       │
│       └── Exclude 3 → (3, [1])
│           └── print [1] and return ↑
│
└── Exclude 1 → (1, [])
    │
    ├── Include 2 → (2, [2])
    │   │
    │   ├── Include 3 → (3, [2, 3])
    │   │   └── print [2, 3] and return ↑
    │   │
    │   └── Exclude 3 → (3, [2])
    │       └── print [2] and return ↑
    │
    └── Exclude 2 → (2, [])
        │
        ├── Include 3 → (3, [3])
        │   └── print [3] and return ↑
        │
        └── Exclude 3 → (3, [])
            └── print [] and return ↑

[1, 2, 3]
[1, 2]
[1, 3]
[1]
[2, 3]
[2]
[3]
[]

*/

/*
1️⃣ 78. Subsets →
2️⃣ 90. Subsets II →
3️⃣ 77. Combinations →
4️⃣ 39. Combination Sum →
5️⃣ 40. Combination Sum II →
22
17
93
7️⃣ 131. Palindrome Partitioning

🧩 Level 3 — Subsequence Logic Specifically
6️⃣ 491. Non-decreasing Subsequences →
1143
300
 */