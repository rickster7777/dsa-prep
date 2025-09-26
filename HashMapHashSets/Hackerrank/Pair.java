/*
Sample Input
5
john tom
john mary
john tom
mary anna
mary anna
Sample Output

1
2
2
3
3
Explanation

After taking the first input, you have only one pair: (john,tom)
After taking the second input, you have two pairs: (john, tom) and (john, mary)
After taking the third input, you still have two unique pairs.
After taking the fourth input, you have three unique pairs: (john,tom), (john, mary) and (mary, anna)
After taking the fifth input, you still have three unique pairs.
 */

import java.util.*;

public class Pair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Set<String> pairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String pair = scanner.nextLine().trim();

            // Add the pair as a string to the set
            pairs.add(pair);

            // Print the number of unique pairs so far
            System.out.println(pairs.size());
        }
    }
}
