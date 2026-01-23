import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*

List<Character>[] buckets = new List[s.length() + 1];

I have worked with the normal
List<Character> list = new List<>();
this is new to me explain me this in a simple manner how it works

Think of it like this:
List<Character> = one bucket

List<Character>[] = many buckets arranged in a row
✔ It's NOT one list
✔ It's an array where each element is a list

📦 Visual explanation
index:   0      1      2      3      4      5
value:  null   null   null   null   null   null

buckets[1] = ['a', 'b']
buckets[2] = ['x']
buckets[5] = ['z', 'y']


buckets =
[
  null,
  [a, b],
  [x],
  null,
  null,
  [z, y]
]

So if a character appears 3 times:
buckets[3].add(character);

*/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Buckets: index = frequency, value = list of chars

        // Step 1 — Create empty array of lists
        List<Character>[] buckets = new List[s.length() + 1];

        for (char c : freq.keySet()) {
            int f = freq.get(c);

        // Step 2 — Initialize lists when needed
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }

        // Step 3 — Add characters to that list
            buckets[f].add(c);
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null)
                continue;
            for (char c : buckets[i]) {
                result.append(String.valueOf(c).repeat(i));
            }
        }

        return result.toString();
    }


    //using max heap
    public String frequencySortHeap(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Max heap sorting by frequency
        PriorityQueue<Character> maxHeap =
            new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        maxHeap.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();

            // THis is same in both aproaches.
            sb.append(String.valueOf(c).repeat(freq.get(c)));
        }

        return sb.toString();
    }


    // Hardcoded test harness with sample inputs
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Sample test cases
        String input1 = "tree"; // expected: "eert" or "eetr" (e appears 2x, t,r 1x each)
        String input2 = "cccaaa"; // expected: "cccaaa" or "aaaccc" (both c,a appear 3x)
        String input3 = "Aabb"; // expected: "bbAa" (b appears 2x, A,a 1x each)

        //System.out.println("Input: \"" + input1 + "\" -> Output: \"" + solver.frequencySort(input1) + "\"");
        //System.out.println("Input: \"" + input2 + "\" -> Output: \"" + solver.frequencySort(input2) + "\"");
        System.out.println("Input: \"" + input3 + "\" -> Output: \"" + solver.frequencySortHeap(input3) + "\"");
    }
}

/*
The main confusion in here is
PriorityQueue<Character> maxHeap =
            new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

After this part I can see all the characters of map {A,a,b}with their values inside comparator -> args1 but the queue is empty 



and queue gets filled with the same chars in descending order after this line
maxHeap.addAll(freq.keySet());

Explain this thing

This confusion comes from how and when a comparator is executed.
Once you understand this, heaps will feel obvious instead of magical.

Creating a PriorityQueue with a comparator only initializes an empty heap and attaches a rule for how elements should be compared; it does not add any elements or 
perform sorting. At that moment, the heap is empty and the comparator is just waiting to be used. The comparator’s parameters (a and b) are placeholders, not real 
values, and they only receive actual characters when the heap needs to compare elements. The reason the debugger shows characters like {A, a, b} is because 
the lambda captures the freq map reference and the debugger previews its contents—this does not mean the comparator has executed or that the queue contains data. 

The comparator only runs when elements are added or removed, which is why the queue actually gets populated and ordered after calling maxHeap.addAll(freq.keySet()).


*/