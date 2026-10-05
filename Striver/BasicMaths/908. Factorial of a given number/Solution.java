class Solution {
    static int factorial(int N){
        // code here
        if(N==0 || N==1) return 1;
        return N*factorial(N-1);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(N) due to recursion stack

    // Iterative approach
    static int factorialIterative(int N){
        int result = 1;
        for(int i=2; i<=N; i++){
            result *= i;
        }
        return result;
    }
}