import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int boats = 0;

        while(start <= end){
            int weight = people[start] + people[end];

            if (weight <= limit){
                boats++;
                start++;
                end--;
            } else if(weight > limit){
                boats++;
                end--;
            }
        }
        return boats;
    }
}
/*
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each
boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.
Example 1:
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)


| Aspect              | Value                        |
| ------------------- | ---------------------------- |
| Time Complexity     | `O(n log n)` (best possible) |
| Space Complexity    | `O(1)`                       |
| Approach            | Greedy + Two Pointer         |
| Can it be improved? | Not significantly, no.       |

 */