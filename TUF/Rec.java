
import java.util.Arrays;

public class Rec {

    // Prints numbers from 1 to n in increasing order
    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }

        printIncreasing(n - 1);
        System.out.println(n);
    }

    // Prints numbers from n to 1 in decreasing order
    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        printDecreasing(n - 1);
    }

    // prints name n times
    public static void printName(int n) {
        if (n == 1) {
            System.out.println("rishav");
            return;
        }

        System.out.println("rishav");
        printName(n - 1);
    }

    // Better version of above
    public static void printNameBetter(int n) {
        if (n == 0)
            return; // cleaner base case

        System.out.println("rishav");
        printNameBetter(n - 1);
    }

    // Print sum upto n
    public static void printSum(int n, int sum) {
        if (n == 1) {
            sum += n;
            System.out.println(sum);
            return;
        }

        sum += n;
        printSum(n - 1, sum);
    }

    // Better version of above
    public static int calculateSum(int n, int sum) {
        if (n == 0)
            return sum;
        return calculateSum(n - 1, sum + n);
    }

    // To calc the factorial.
    public static int printFact(int n, int fact) {
        if (n == 0)
            return fact;

        fact *= n;
        return printFact(n - 1, fact);
    }

    // reverse an array
    public static int[] reverseArray(int[] arr, int n, int[] rev) {

        if (n == 0) {
            return rev;
        }

        rev[rev.length - n] = arr[n - 1];

        return reverseArray(arr, n - 1, rev);
    }

    // Alternative: Reverse in place (without extra array)
    public static void reverseInPlace(int[] arr, int start, int end) {
        if (start >= end)
            return;

        // swap
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseInPlace(arr, start + 1, end - 1);
    }


    // Alternative: Reverse in place (without extra array)
    public static boolean  checkPalindrome(String s, int start, int end) {
        if (start >= end)
            return  true;


        if  (s.charAt(start) !=  s.charAt(end)) return false;

        return checkPalindrome(s, start + 1, end - 1);
    }


    public static int[] fibo(int n, int[] arr, int i) {

        if (i == n) {
            return arr;
        }


        arr[i] = arr[i - 2] + arr[i - 1];
        // i++; this can be written in the function itself that way looks better shown below
        return fibo(n, arr, i + 1);

        // int[] arr = new int[5];

        // arr[0] = 0;
        // arr[1] = 1;

        // for (int i = 2; i < n; i++) {
        //     arr[i] = arr[i - 2] + arr[i - 1];
        // }

        // return arr;
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 5;
        printIncreasing(n); // Prints numbers in increasing order
        printDecreasing(n); // Prints numbers in decreasing order
        printName(m); // Print name N times above both techniques can be used in here to print n
                      // times.
        printSum(m, 0);

        System.out.println(printFact(m, 1)); // If it's returned directly instead of using the print statement then it
                                             // needs to be collected and printed separately.

        // correct array initialization syntax in Java
        int[] arr = { 1, 2, 3, 4, 5 };
        int len = arr.length;

        int[] rev = new int[arr.length];

        System.out.println(Arrays.toString(reverseArray(arr, len, rev)));

        //System.out.println(fibo(m));

        String s = "cac";

        System.out.println(checkPalindrome(s, 0, s.length() - 1));


        int[] fibArray = new int[5];
        fibArray[0] = 0;
        fibArray[1] = 1;
        System.out.println(Arrays.toString((fibo(m, fibArray, 2))    ));
    }
}
