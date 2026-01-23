import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SEGMENTED SIEVE OF ERATOSTHENES
 * 
 * Problem: Find all primes up to a very large number (e.g., 10^9)
 * 
 * Normal Sieve Issue:
 * - Creating a boolean array of size 10^9 requires ~1GB of memory
 * - Too much space to handle large numbers
 * 
 * Segmented Sieve Solution:
 * - Only create a boolean array of size sqrt(n) for initial prime generation
 * - Divide the range [2, n] into segments of size sqrt(n)
 * - For each segment, mark multiples using primes found in initial sieve
 * - Memory Usage: O(sqrt(n)) instead of O(n)
 * - Time Complexity: O(n * log(log(n)))
 */
public class SegmentedSieve {

    /**
     * STEP 1: Simple Sieve of Eratosthenes
     * Finds all primes up to 'limit' using standard sieve algorithm
     * This is used to get prime factors needed for segmented sieve
     * 
     * Key Point: We only need primes up to sqrt(n), not all primes up to n
     * 
     * @param limit Upper bound for finding primes (= sqrt(n))
     * @return List of all primes up to limit
     */
    static List<Integer> simpleSieve(int limit) {
        // Create boolean array and mark all numbers as potentially prime
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        // 0 and 1 are not prime
        isPrime[0] = isPrime[1] = false;

        // Standard sieve algorithm: O(limit * log(log(limit)))
        // Only iterate up to sqrt(limit) because any composite number has a factor <= sqrt(n)
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as not prime
                // Start from i*i because smaller multiples are already marked
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect all prime numbers into a list
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    /**
     * STEP 2: Segmented Sieve - Memory Efficient Approach
     * 
     * MAIN DIFFERENCE FROM NORMAL SIEVE:
     * ================================
     * Normal Sieve: Creates ONE large boolean array of size n
     * Segmented Sieve: Divides range into SEGMENTS, processes one at a time
     * 
     * This is the KEY MEMORY OPTIMIZATION:
     * - Instead of allocating O(n) space
     * - We allocate O(sqrt(n)) space and reuse it for each segment
     * - For n = 10^9, we need ~31,623 space per segment (32KB) vs 1GB for normal
     * 
     * Algorithm Steps:
     * 1. Find all primes up to sqrt(n) using simple sieve
     * 2. Divide range [2, n] into segments of size sqrt(n)
     * 3. For each segment, mark multiples of each prime using the primes from step 1
     * 4. Unmarked numbers in each segment are prime
     * 
     * @param n Upper bound to find primes up to
     */
    static void segmentedSieve(long n) {
        // OPTIMIZATION 1: Only find primes up to sqrt(n)
        // We don't need all primes, just up to sqrt(n)
        // Why? Because any composite number has at least one factor <= sqrt(n)
        int limit = (int) Math.sqrt(n);
        List<Integer> primes = simpleSieve(limit);

        // OPTIMIZATION 2: Process the range in segments (blocks/chunks)
        // Each segment has size = sqrt(n), which is memory efficient
        int low = limit;   // Starting point of current segment
        int high = 2 * limit;  // Ending point of current segment (exclusive)

        // Process all segments until we've covered the entire range [2, n]
        while (low < n) {
            // Adjust high if it exceeds n
            if (high > n) high = (int) n;

            /**
             * CRITICAL MEMORY OPTIMIZATION:
             * Create a boolean array of size (high - low), NOT size n
             * This array represents only the current segment [low, high)
             * For example: if n = 10^9, this array size = ~31,623, NOT 10^9
             */
            boolean[] mark = new boolean[high - low];
            Arrays.fill(mark, true);  // Assume all numbers in segment are prime

            // For each prime found in simpleSieve, mark its multiples in this segment
            for (int prime : primes) {
                /**
                 * Find the first multiple of 'prime' in range [low, high)
                 * Formula: ((low + prime - 1) / prime) * prime
                 * This is ceiling division to find first multiple >= low
                 * 
                 * Example: low=100, prime=7
                 * First multiple of 7 >= 100 is 105
                 */
                int start = (low + prime - 1) / prime * prime;
                
                // Mark all multiples of this prime in the segment
                // The index adjustment (j - low) maps the actual number to array index
                for (int j = start; j < high; j += prime) {
                    mark[j - low] = false;  // Mark as composite
                }
            }

            // Print all unmarked numbers in this segment (these are primes)
            for (int i = low; i < high; i++) {
                if (mark[i - low]) {  // Index = actual_number - low
                    System.out.print(i + " ");
                }
            }

            // Move to next segment
            low = high;
            high += limit;  // Next segment of size sqrt(n)
        }
    }


    public static void main(String[] args) {
        /**
         * Example: Find all primes up to 1 billion (10^9)
         * 
         * Normal Sieve would need:
         * - Memory: ~1 GB (1 billion booleans)
         * - This would cause OutOfMemoryError
         * 
         * Segmented Sieve uses:
         * - Memory: ~31 KB per segment (only sqrt(10^9) = 31,623)
         * - Can handle numbers much larger than normal sieve
         */
        segmentedSieve(1_000_000_000L);
    }
}