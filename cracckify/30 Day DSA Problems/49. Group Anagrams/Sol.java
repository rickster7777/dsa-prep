import java.util.*;

class Sol {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Holds the final result of grouped anagrams
        List<List<String>> result = new ArrayList<>();

        // Map from sorted string key to list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Return a lazily-initialized list using AbstractList
        return new AbstractList<List<String>>() {

            boolean init = false; // flag to ensure init runs only once

            // Called when result.size() is needed
            public int size() {
                init(); // lazy initialize
                return result.size();
            }

            // Called when result.get(i) is needed
            public List<String> get(int i) {
                init(); // lazy initialize
                return result.get(i);
            }

            // Initialization logic (runs only once)
            public void init() {
                if (init) return; // prevent multiple initializations

                for (String s : strs) {
                    // Sort the characters of the string
                    char[] key = s.toCharArray();
                    Arrays.sort(key);

                    // Use sorted string as key
                    map.computeIfAbsent(new String(key), k -> {
                        List<String> list = new ArrayList<>();
                        result.add(list); // keep insertion order in result
                        return list;
                    }).add(s);
                }

                init = true; // mark as initialized
            }
        };
    }
}