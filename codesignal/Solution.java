/*


Question 2: String Pattern Matching
You are given two strings: pattern and source. The first string pattern contains only the symbols 0 and 1, and the second string source contains only lowercase English letters.

Your task is to calculate the number of substrings of source that match pattern. 

We’ll say that a substring source[l..r] matches pattern if the following three conditions are met:
– The pattern and substring are equal in length.
– Where there is a 0 in the pattern, there is a vowel in the substring. 
– Where there is a 1 in the pattern, there is a consonant in the substring. 

Vowels are ‘a‘, ‘e‘, ‘i‘, ‘o‘, ‘u‘, and ‘y‘. All other letters are consonants.

Example

For pattern = "010" and source = "amazing", the output should be solution(pattern, source) = 2.
– “010” matches source[0..2] = "ama". The pattern specifies “vowel, consonant, vowel”. “ama” matches this pattern: 0 matches a, 1 matches m, and 0 matches a. 
– “010” doesn’t match source[1..3] = "maz" 
– “010” matches source[2..4] = "azi" 
– “010” doesn’t match source[3..5] = "zin" 
– “010” doesn’t match source[4..6] = "ing"

So, there are 2 matches. For a visual demonstration, see the example video. 

For pattern = "100" and source = "codesignal", the output should be solution(pattern, source) = 0.
– There are no double vowels in the string "codesignal", so it’s not possible for any of its substrings to match this pattern.

Guaranteed constraints:
1 ≤ source.length ≤ 103
1 ≤ pattern.length ≤ 103
 Q2 string patten matching

pattern = "010";
source = "amazing";

char[] chars = source.toCharArray();
Map<Character, Character> map = new LinkedHashMap<>();

for(int i = 0; i < chars.length; i++){
	
if(isVowel(chars[i])){
	
map.put(chars[i], '0');
} map.put(chars[i], '1');

int point = 0;

for(character c: map.values()){
if(c == pattern.charAt(point){
	pointer++;
}
}
}
 */



public class Solution {

    public static int solution(String pattern, String source) {
        int count = 0;
        int pLen = pattern.length();
        int sLen = source.length();

        for (int i = 0; i <= sLen - pLen; i++) {
            String sub = source.substring(i, i + pLen);
            if (matchesPattern(sub, pattern)) {
                count++;
            }
        }

        return count;
    }

    private static boolean matchesPattern(String sub, String pattern) {


        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            char p = pattern.charAt(i);
            if (p == '0' && !isVowel(c)) return false;
            if (p == '1' && isVowel(c)) return false;
        }
        /*
        That means every character in sub matches the expected type (vowel or consonant) as dictated by pattern
         */
        return true;
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return "aeiouy".indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("010", "amazing")); // Output: 2
        System.out.println(solution("100", "codesignal")); // Output: 0
    }
}
