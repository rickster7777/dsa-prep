// Sieve of Eratosthenes
/*
📌 Sieve of Eratosthenes (Prime Numbers)
Purpose

Find all prime numbers ≤ n efficiently.

🧠 Idea (1–2 lines)
Assume all numbers are prime.
Repeatedly mark multiples of each prime as non-prime.

🔁 Steps
1. Create a boolean array isPrime[0..n]
2. Mark 0 and 1 as not prime
3. For i = 2 to √n
4. If i is prime → mark all multiples of i as not prime

Remaining true values are primes

🧪 Example (n = 10)
Initial: 2 3 4 5 6 7 8 9 10
After 2:    X   X   X
After 3:        X
Primes → 2 3 5 7

*/

/*
Sieve of Eratosthenes:
Create a boolean array isPrime[0...n], initially set all values to true.
Set isPrime[0] = false and isPrime[1] = false (0 and 1 are not prime).
Start from p = 2, the first prime number.
For each p:
If isPrime[p] is true, mark all multiples of p (i.e., p*2, p*3, …) as false.
Continue this process until p * p > n (no need to go beyond √n).
At the end, isPrime[i] tells whether i is a prime number.

Algorithm for the question:
Use the Sieve of Eratosthenes to mark all primes up to the maximum value R in any query.
Build a prefix sum array primeCount[i] where each element represents the number of primes ≤ i.
For each query [L, R], calculate count = primeCount[R] - primeCount[L-1].
Return the result for each query.
*/

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
        if (queries == null || queries.isEmpty()) {
            return new ArrayList<>();
        }

        // Find the maximum value in the queries
        // to determine the sieve range
        int maxVal = 0;
        for (int[] query : queries) {
            maxVal = Math.max(maxVal, query[1]);
        }

        // Step 1: Use the Sieve of Eratosthenes
        // to find all primes up to maxVal
        boolean[] isComposite = new boolean[maxVal + 1];

        for (int p = 2; p * p <= maxVal; p++) {
            if (!isComposite[p]) {
                for (int i = p * p; i <= maxVal; i += p) {
                    isComposite[i] = true;
                }
            }
        }
        // Step 2: Create a prefix sum array to count primes up to each number
        int[] primeCount = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            primeCount[i] = primeCount[i - 1];
            if (i >= 2 && !isComposite[i]) {
                primeCount[i]++;
            }
        }

        // Step 3: Process each query to find the number
        // of primes in the given range
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            if (start == 0) {
                result.add(primeCount[end]);
            } else {
                result.add(primeCount[end] - primeCount[start - 1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<int[]> queries = new ArrayList<>();
        queries.add(new int[] { 2, 5 });
        queries.add(new int[] { 4, 20 });

        // Creating an instance of Solution class
        Solution solution = new Solution();

        // Function call to find the number of primes in each range
        System.out.println(solution.primesInRange(queries)); // Output: [3, 2]
    }
}
