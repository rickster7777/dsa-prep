/*
What the loops do

Outer loop (i)

Controls the number of passes.
After each pass, the largest element moves to the end.
Range reduces because the last i elements are already sorted.

Inner loop (j)
Compares adjacent elements.
Performs swaps during each pass.


*/

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop (i)
        // Controls the number of passes.
        // After each pass, the largest element moves to the end.
        // Range reduces because the last i elements are already sorted.
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // THis inner loop performs the comparisons and swaps
            // It goes up to n-i-1 because the last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, array is already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4};

        bubbleSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
Initial Array
[ 5, 3, 8, 4 ]

Bubble Sort Visualization

👉 Largest element bubbles to the end in each pass.

Pass 1
(5,3) → swap → [ 3, 5, 8, 4 ]
(5,8) → no swap → [ 3, 5, 8, 4 ]
(8,4) → swap → [ 3, 5, 4, 8 ]

Pass 2
(3,5) → no swap → [ 3, 5, 4, 8 ]
(5,4) → swap → [ 3, 4, 5, 8 ]

Pass 3
(3,4) → no swap → [ 3, 4, 5, 8 ] ✅ sorted


📌 Observation:
Comparisons and swaps happen many times.
Largest number moves right step-by-step.
*/