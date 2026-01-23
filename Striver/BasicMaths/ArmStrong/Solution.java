/*


Mathematical Concepts to Remember

Digit extraction: number % 10
Digit removal: number / 10
Power calculation: Math.pow(digit, n)
Counting digits: Math.log10(number)+1 or loop
Loop invariants: Keep track of running sum

*/
class Solution {
    public boolean isArmstrong(int num) {

        int original = num;
        int sum = 0;

        // Step 1: Count number of digits
        int n = String.valueOf(num).length();  // or use log10

        // Step 2: Iterate through digits
        while (num != 0) {
            int digit = num % 10;                // extract last digit
            sum += Math.pow(digit, n);           // add digit^n to sum
            num /= 10;                            // remove last digit
        }

        // Step 3: Compare sum with original number
        return sum == original;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int testNum = 153; // Example Armstrong number
        System.out.println(sol.isArmstrong(testNum)); // Output: true
        //how 153 is armstrong number
        // 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153


    }
}

