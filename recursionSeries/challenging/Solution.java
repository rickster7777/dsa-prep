class Solution {

    public static void numbersFrom(int n) {
        // handle non-positive input gracefully
        // if (n <= 0) {
        //     return;
        // }

        // base case: when n == 1, print 1
        if (n == 1) {
            System.out.println(1);
            return;
        }

        numbersFrom(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 10;
        numbersFrom(n);
    }
}