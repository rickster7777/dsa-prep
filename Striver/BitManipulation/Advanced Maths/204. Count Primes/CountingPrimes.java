// Exact LC

import java.util.Arrays;

public class CountingPrimes {

    //this solution is sieve of eratosthenes
    // Time complexity: O(n log log n)
    // Space complexity: O(n)
     public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // direct approach
        int n= 20;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            // Check if i is prime
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}

/*
# Sieve of Eratosthenes – Quick Notes

### Purpose

* Print **all prime numbers from `1` to `n`** efficiently.
* Time Complexity: **O(n log log n)**
* Space Complexity: **O(n)**

---

## Algorithm

1. Create a boolean array `isPrime[]` of size `n + 1`.
2. Assume every number from **2 to n** is prime (`true`).
3. Start from `i = 2`.
4. If `i` is prime, mark all its multiples as `false`.
5. Repeat until `i * i > n`.
6. All indices still marked `true` are prime numbers.

---

## Outer Loop

```java
for (int i = 2; i * i <= n; i++)
```

### Purpose

* Finds the next prime number whose multiples need to be marked.

### Why `i * i <= n`?

* Every composite number has **at least one factor ≤ √n**.
* Therefore, checking beyond √n is unnecessary.

Example (`n = 20`):

```
√20 ≈ 4.47

i = 2
i = 3
i = 4
Stop before i = 5
```

---

## `if (isPrime[i])`

```java
if (isPrime[i])
```

### Purpose

* Only process numbers that are still marked prime.
* Skip composite numbers because their multiples were already handled.

Example:

```
i = 4

isPrime[4] == false

→ Skip
```

---

## Inner Loop

```java
for (int j = i * i; j <= n; j += i)
```

### Purpose

* Marks all multiples of `i` as **not prime**.

```java
isPrime[j] = false;
```

---

## Why start from `i * i`?

Multiples smaller than `i²` have **already been marked** by smaller prime numbers.

Example (`i = 5`):

```
5 × 2 = 10   ← already marked by 2
5 × 3 = 15   ← already marked by 3
5 × 4 = 20   ← already marked by 2

First new multiple = 5 × 5 = 25
```

Starting from `i²` avoids duplicate work.

---

## Why `j += i`?

Moves to the next multiple of `i`.

Example (`i = 3`):

```
j = 9
j = 12
j = 15
j = 18
```

---

## Example (`n = 20`)

| `i`  | Prime?       | Multiples Marked                |
| ---- | ------------ | ------------------------------- |
| 2    | ✅            | 4, 6, 8, 10, 12, 14, 16, 18, 20 |
| 3    | ✅            | 9, 12, 15, 18                   |
| 4    | ❌            | Skipped                         |
| Stop | `5 × 5 > 20` | Done                            |

Remaining primes:

```
2 3 5 7 11 13 17 19
```

---

## Key Interview Points

* ✅ `i * i <= n` → Only check up to **√n**.
* ✅ `if (isPrime[i])` → Skip composite numbers.
* ✅ `j = i * i` → Smaller multiples are already processed.
* ✅ `j += i` → Visit only multiples of `i`.
* ✅ Remaining `true` values in `isPrime[]` are the prime numbers.

*/