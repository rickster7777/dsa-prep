import java.util.*;

/*
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        List<String> innerList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            innerList.clear();
            innerList = new ArrayList<>();	
            local variables referenced from a lambda expression must be final or effectively final(errors(1): 10:81-10:82)
            i can't be used directly like strs[i].
            final int target = i; // ✅ now copy is effectively final

            boolean found = list.stream().anyMatch(group -> group.contains(strs[target]));

            if (found)
                continue;

            innerList.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    innerList.add(strs[j]);
                }
            }

            list.add(innerList);
        }
        return list;
    }

    private static boolean isAnagram(String s1, String s2) {
        Convert to char arrays, sort them, and compare
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(sol.groupAnagrams(strs));
    }
}
*/
/*
Above sol gave TLE
GPT approach
💡 Efficient Solution (Recommended for Interviews):

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(sol.groupAnagrams(strs));
    }
}

*/
//0 ms solution
// ✅ Code: Frequency-Based Hashing

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            // Build a key from frequency array
            StringBuilder sb = new StringBuilder();
            for (int count : freq) {
                sb.append(count).append('#');  // delimiter to avoid ambiguity
            }
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}


