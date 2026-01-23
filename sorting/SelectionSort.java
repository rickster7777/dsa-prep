public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;


        // Outer loop (i)
        // Controls the number of passes.
        // After each pass, the smallest element moves to the front.
        // Range reduces because the first i elements are already sorted.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap minimum element with first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        selectionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
Selection Sort Visualization

👉 Smallest element is selected and placed in correct position.

Pass 1 (find minimum)
[ 5, 3, 8, 4 ]
min = 3 → swap with 5
[ 3, 5, 8, 4 ]

Pass 2 (find minimum in remaining)
[ 3 | 5, 8, 4 ]
min = 4 → swap with 5
[ 3, 4, 8, 5 ]

Pass 3
[ 3, 4 | 8, 5 ]
min = 5 → swap with 8
[ 3, 4, 5, 8 ] ✅ sorted


📌 Observation:

Only one swap per pass.

Smallest number moves directly to correct position.
*/