
//My brute force sol 
// issues: i was unable to add 0 on non warmmer days.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int i = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < temperatures.length) {

            int j = i + 1;
            int count = 0;
            while (j < temperatures.length) {
                if (temperatures[i] < temperatures[j]) {
                    count++;
                    result.add(count);
                    break;
                }
                j++;
                count++;
                if (j == temperatures.length - 1) {
                    result.add(0);
                }
            }
            i++;
        }
        int[] finalResult = result.stream().mapToInt(k -> k).toArray();
        return finalResult;
    }

    public int[] dailyTemperaturesFixed(int[] temperatures) {
        int n = temperatures.length;

        //Removed unnecessary use of ArrayList — just use an array directly for better performance.
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                j++;
            }
            if (j < n) {
                result[i] = j - i;
            } else {
                // Ensured 0 is added when no warmer temperature is found.
                result[i] = 0; // no warmer day found
            }
        }

        return result;
    }

     public int[] dailyTemperaturesMono(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {
            // Check if current temp is greater than temp at index on top of stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // days to wait
            }
            stack.push(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] temperatures = { 30, 40, 50, 60 };

        int[] result = sol.dailyTemperatures(temperatures);
        System.out.println("Result: " + Arrays.toString(result)); // Output: [-1, 3, -1]
    }
}

// Fixed mono stack approach