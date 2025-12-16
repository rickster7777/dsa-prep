import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character ,Integer> sfreq = new HashMap<>();


        for(char c: s.toCharArray()){

            if(!sfreq.containsKey(c)){
                sfreq.put(c, 1);
            } else {
                sfreq.put(c, sfreq.get(c) + 1);
            }

        }

        for(char c: t.toCharArray()) {

            if(!sfreq.containsKey(c)){
                return false;
            }

            sfreq.put(c, sfreq.get(c) - 1);

            if(sfreq.get(c) == 0){
                sfreq.remove(c);
            }
        }

        if (sfreq.isEmpty()) return true; 
        
        return false;
    }

    // Hardcoded test harness with sample inputs
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Sample test cases
        String s1 = "anagram", t1 = "nagaram";        // expected: true
        String s2 = "rat", t2 = "car";                // expected: false
        String s3 = "listen", t3 = "silent";          // expected: true
        String s4 = "a", t4 = "a";                    // expected: true
        String s5 = "ab", t5 = "ba";                  // expected: true

        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\" -> Output: " + solver.isAnagram(s1, t1));
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\" -> Output: " + solver.isAnagram(s2, t2));
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\" -> Output: " + solver.isAnagram(s3, t3));
        System.out.println("Input: s = \"" + s4 + "\", t = \"" + t4 + "\" -> Output: " + solver.isAnagram(s4, t4));
        System.out.println("Input: s = \"" + s5 + "\", t = \"" + t5 + "\" -> Output: " + solver.isAnagram(s5, t5));
    }
}