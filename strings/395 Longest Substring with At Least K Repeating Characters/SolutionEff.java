class SolutionEff {

    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private int solve(String s, int start, int end, int k) {

        // Step 1: Count frequency of every character
        int[] freq = new int[26];

        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Step 2: Find a character that appears fewer than k times
        for (int i = start; i < end; i++) {

            char ch = s.charAt(i);

            if (freq[ch - 'a'] < k) {

                // Step 3: This character cannot be part
                // of any valid substring.
                //
                // So split the problem around it.

                int left = solve(s, start, i, k);
                int right = solve(s, i + 1, end, k);

                // Step 4: Take the better side
                return Math.max(left, right);
            }
        }

        // Step 5: Every character appears at least k times
        // Therefore the entire substring is valid.
        return end - start;
    }

    public static void main(String[] args) {
        SolutionEff solution = new SolutionEff();
        String s = "aaabb";           // example input string
        int k = 3;                    // required minimum frequency per character in substring
        // call efficient implementation and print the result (expected 3 for "aaa")
        System.out.println("Efficient: " + solution.longestSubstring(s, k));
    }
}