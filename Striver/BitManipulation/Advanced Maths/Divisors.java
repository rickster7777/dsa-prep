import java.util.Arrays;

public class Divisors {
    public int[] divisors(int n) {

        // To store the divisors
        int[] temp = new int[n]; // Temporary array with max possible size
        int count = 0;

        int sqrtN = (int) Math.sqrt(n);

        // Iterate from 1 to sqrtN
        for (int i = 1; i <= sqrtN; i++) {

            // If a divisor is found
            if (n % i == 0) {
                // Add it to the answer
                temp[count++] = i;

                /*
                 * Add the counterpart divisor
                 * if it's different from i
                 */
                if (i != n / i) {
                    temp[count++] = n / i;
                }
            }
        }

        // Copy only the filled part of temp to the result array
        int[] ans = Arrays.copyOf(temp, count);

        // Sorting the result
        Arrays.sort(ans);

        // Return the result
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;

        // Creating an instance of Divisors class
        Divisors sol = new Divisors();

        // Function call to find all divisors of n
        int[] ans = sol.divisors(n);

        System.out.print("The divisors of " + n + " are: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

/*
why this part

/* Add the counterpart divisor if it's different from i

if (i != n / i) {
temp[count++] = n / i;
}

√6 ≈ 2.45, so sqrtN = 2
Loop runs: i = 1, 2

i = 1:  6 % 1 == 0 ✓
        Add: i = 1
        i != 6/1? → 1 != 6? YES ✓ → Add: 6/1 = 6
        Result: [1, 6]

i = 2:  6 % 2 == 0 ✓
        Add: i = 2
        i != 6/2? → 2 != 3? YES ✓ → Add: 6/2 = 3
        Result: [1, 6, 2, 3]



√36 = 6
Loop runs: i = 1, 2, 3, 4, 5, 6

i = 1:  36 % 1 == 0 ✓
        Add: i = 1
        i != 36/1? → 1 != 36? YES → Add: 36/1 = 36
        Result: [1, 36]

i = 2:  36 % 2 == 0 ✓
        Add: i = 2
        i != 36/2? → 2 != 18? YES → Add: 36/2 = 18
        Result: [1, 36, 2, 18]

i = 3:  36 % 3 == 0 ✓
        Add: i = 3
        i != 36/3? → 3 != 12? YES → Add: 36/3 = 12
        Result: [1, 36, 2, 18, 3, 12]

i = 4:  36 % 4 == 0 ✓
        Add: i = 4
        i != 36/4? → 4 != 9? YES → Add: 36/4 = 9
        Result: [1, 36, 2, 18, 3, 12, 4, 9]

i = 5:  36 % 5 ≠ 0 ✗
        Skip

i = 6:  36 % 6 == 0 ✓
        Add: i = 6
        i != 36/6? → 6 != 6? NO ❌ (DON'T add again!)
        Result: [1, 36, 2, 18, 3, 12, 4, 9, 6]


Without the check at i = 6:

Add: i = 6       
Add: 36/6 = 6  ← DUPLICATE!        
Result: [1, 36, 2, 18, 3, 12, 4, 9, 6, 6] ❌

The check if (i != n/i) ensures:
When i = 6 and n/i = 6, we don't add it twice. We only add 6 once!

Why this works mathematically:

When you iterate only to √n, you cover all divisor pairs
For most pairs: i ≠ n/i (like 2 and 18, 3 and 12)
For perfect squares: i = n/i (like 6 = 36/6), so you skip the duplicate
*/