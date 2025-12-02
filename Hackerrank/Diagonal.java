import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Diagonal {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        if (arr == null || arr.size() == 0) return 0;

        int n = arr.size();
        int sumPrimary = 0, sumSecondary = 0;

        for (int i = 0; i < n; i++) {
        sumPrimary += arr.get(i).get(i);
        sumSecondary += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(sumPrimary - sumSecondary);

        //My approach nested for loop in sumRight isn't working correctly
        // int n = arr.size();
        // int sumLeft = 0, sumRight = 0;

        // for (int i = 0; i < n; i++) {
        //     sumLeft += arr.get(i).get(i);
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = n - 1; j <= 0; j--) {
        //         sumRight += arr.get(j).get(j);
        //     }
        // }

        //return Math.abs(sumLeft - sumRight);
    }

    // Simple main to test the sample input
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(11, 2, 4));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(10, 8, -12));

        int result = diagonalDifference(arr);
        System.out.println(result); // expected 15
    }

}