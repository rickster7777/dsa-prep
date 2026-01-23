public class Solution {

    // converting to string

    static int digits(int n) {

        return String.valueOf(n).length();
    }

    // without converting to string
    static int countDigits(int n) {

        int count = 0;

        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    // chatGPT

    /*
    int digits = (int) Math.log10(n) + 1;

    */
    static int countDigitsRec(int n) {
        if (n == 0)
            return 0;
        return 1 + countDigitsRec(n / 10);
    }

    public static void main(String[] args) {
        int n = 123459;
        System.out.println(Solution.digits(n));
        System.out.println(Solution.countDigits(n));
    }
}
