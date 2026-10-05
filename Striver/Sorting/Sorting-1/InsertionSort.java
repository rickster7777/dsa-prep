/*
How it works

For each element:

Pick the current element as the key.
Compare it with elements to its left.
Shift larger elements one position to the right.
Insert the key into its correct position.
Example

Array: 5 3 4 1

Start: 5 | 3 4 1
Insert 3: 3 5 | 4 1
Insert 4: 3 4 5 | 1
Insert 1: 1 3 4 5

Result: 1 3 4 5

Complexity
Case	Time
Best	O(n)
Average	O(n²)
Worst	O(n²)
Space	O(1)

Key advantage: Insertion sort works very well for small or nearly sorted arrays.

*/
public class InsertionSort {
    public static void insertion(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at its correct position
            arr[j + 1] = key;
        }

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
        InsertionSort.insertion(arr);

        int[] arr2 = {12, 11, 13, 5, 6};
        InsertionSort.insertion(arr2);
    }
}

/*
Remember the main logic
int key = arr[i];
int j = i - 1;


while (j >= 0 && arr[j] > key) {
    arr[j + 1] = arr[j];
    j--;
}


arr[j + 1] = key;

The important idea is: take one element (key), shift larger elements to the right, then insert the key.
*/

/*
Yes. **`j` can become `-1`** in insertion sort.

For example, with:

```java
int[] arr = {2, 3, 1};
```

When `key = 1`:

```java
j = 1;  // arr[j] = 3
```

`3 > 1`, so shift:

```java
arr[2] = arr[1];
j--;       // j = 0
```

Now `arr[0] = 2`, and `2 > 1`, so:

```java
arr[1] = arr[0];
j--;       // j = -1
```

Now the `while` condition:

```java
while (j >= 0 && arr[j] > key)
```

becomes false because `j >= 0` is false.

Then:

```java
arr[j + 1] = key;
```

becomes:

```java
arr[0] = key;
```

So **`j = -1` is perfectly valid** here. It means the key belongs at the **first position**.

⚠️ The condition `j >= 0` is important because it prevents Java from trying to access `arr[-1]`, which would cause an `ArrayIndexOutOfBoundsException`.

*/