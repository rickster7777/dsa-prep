import java.util.*;

class Solution {
    public int minimizedStringLength(String s) {

        Set<Character> charSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        return charSet.size();
    }

    public int minimizedStringLengthOptimized(String s) {

    // Bcz if we observe, at the end only unique characters remain after deletion
    /*    int n = s.length();
        Set<Character> set = new HashSet<>();

        for(char c: s.toCharArray()){
            set.add(c);
        }
        return set.size();  */

    // Using array
        int arr[] = new int[26];

        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            arr[c -'a']++;
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(arr[i] > 0){
                count++;
            }
        }
        return count;
    }
}