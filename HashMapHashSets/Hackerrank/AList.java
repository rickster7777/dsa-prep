package HashMapHashSets.Hackerrank;
/*
 Sample Input

5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Sample Output

74
52
37
ERROR!
ERROR!

 */
import java.io.*;
import java.util.*;




public class AList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of lists
        List<List<Integer>> data = new ArrayList<>();

        // Read n lists
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt(); // Number of elements
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                list.add(scanner.nextInt());
            }
            data.add(list);
        }

        int q = scanner.nextInt(); // Number of queries

        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt(); // list number (1-based?)
            int y = scanner.nextInt(); // element index (1-based?)

            try {
                System.out.println(data.get(x - 1).get(y - 1)); // convert to 0-based
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}





/*
✅ 1. A DSA problem with business context

Example:

“Given a list of financial transactions, find the top 3 clients who made the most transactions.”

You'll use HashMap + sorting / PriorityQueue

They may ask you to define a Transaction class — light OOP

✅ 2. Object-Oriented Thinking

You may be asked:

"How would you design a Logger utility?"

"How do you override equals() and hashCode() in Java?"

"What happens if you use an object as a key in a HashMap?"
 */