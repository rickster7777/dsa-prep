public class substringComparison {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        java.util.List<String> list = new java.util.ArrayList<>();

        list.add(s.substring(0, k));

        for (int i = k; i < s.length(); i++) {
            String str = s.substring(i - (k - 1), i + 1);
            list.add(str);
        }

        java.util.Collections.sort(list);

        smallest = list.get(0);
        largest = list.get(list.size() - 1);

        return smallest + "\n" + largest;
    }

    // Better approach using compareTo

    public static String getSmallestAndLargestBetter(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        // iterate through all substrings of length k
        for (int i = 1; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);

            if (sub.compareTo(smallest) < 0) {
                smallest = sub;
            }
            if (sub.compareTo(largest) > 0) {
                largest = sub;
            }
        }

        return smallest + "\n" + largest;
    }
}

/*
 * 🔍 What Your Current Code Does
 * 
 * Generates all substrings of length k
 * 
 * Adds them to a List
 * 
 * Sorts the list lexicographically
 * 
 * Takes the first and last elements
 * 
 * ✅ It works
 * ❌ But sorting all substrings is O(n log n) in both time and memory.
 */