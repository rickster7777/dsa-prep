import java.util.Arrays;

class Solution {
    /**
     * Calculates the maximum score you can get by playing tokens.
     * You can play tokens face up (lose power, gain score) or face down (lose score, gain power).
     * Uses a two-pointer approach after sorting the tokens.
     *
     * @param tokens array of token values
     * @param power initial power
     * @return maximum score achievable
     */
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens); // Sort tokens to use smallest and largest efficiently

        int start = 0; // Pointer to the smallest token
        int end = tokens.length - 1; // Pointer to the largest token
        int score = 0; // Current score
        int maxScore = 0; // Track the maximum score achieved

        // Step through tokens with two pointers
        while(start <= end) {
            // If enough power, play the smallest token face up
            if(power >= tokens[start]){
                power -= tokens[start];
                score++;
                maxScore = Math.max(maxScore, score);
                start++;
            } 
            // If not enough power but have score, play the largest token face down
            else if (score >= 1){
                power += tokens[end];
                score--;
                end--;
            }
            // If neither move is possible, break
            else{
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        int power = 150;

        Solution.bagOfTokensScore(tokens, power);
    }
}