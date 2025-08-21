
/*
class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);

        for (int num : asteroids) {
            int top = stack.pop();

            if ((top > 0 && num < 0) || (top < 0 && num > 0)) {

                if (Math.abs(top) > Math.abs(num)) {
                    continue;
                } else {
                    stack.pop();
                    stack.push(num);
                }
            } else {
                stack.push(num);
            }
        }
        i dont know how to convert stack to int[] and return it .
        int size = stack.size();
        int[] result = new int[size];

        // Copy stack to avoid modifying the original
        Stack<Integer> temp = (Stack<Integer>) stack.clone();

        // Fill array from end to start to maintain order
        for (int i = size - 1; i >= 0; i--) {
            result[i] = temp.pop();
        }

        return result;
    }
}
 */


/*
Also, I missed this key insight
which lead to me putting 1 extra condition.
  */


  import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int num : asteroids) {
            boolean destroyed = false;

            // Handle collisions while the top of the stack is a right-moving asteroid (positive)
            // and the current one is a left-moving asteroid (negative)
            while (!stack.isEmpty() && stack.peek() > 0 && num < 0) {
                int top = stack.peek();

                if (Math.abs(top) < Math.abs(num)) {
                    // Top asteroid is smaller → it explodes
                    stack.pop();
                    // Continue to check for more collisions
                } else if (Math.abs(top) == Math.abs(num)) {
                    // Both asteroids are equal → both explode
                    stack.pop();
                    destroyed = true; // current asteroid is destroyed
                    break;
                } else {
                    // Top asteroid is larger → current one is destroyed
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                // If no collision occurred (or it survived), push it to the stack
                stack.push(num);
            }
        }

        // Convert stack to array (in correct order)
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] asteroids = {5, 10, -5};
        int[] result = solution.asteroidCollision(asteroids);
        for (int asteroid : result) {
            System.out.print(asteroid + " ");
        }
    }
}
