class Solution {
    public void reverseString(List<Character> s) {
        //your code goes here
        // instead of set i was using put but it was giving me error so i changed it to set and it worked
        //put is used for maps and set is used for lists
        int n = s.size();

        int start = 0;
        int end = n - 1;

        while (start < end) {

            Character temp = s.get(start);

            s.set(start, s.get(end));
            s.set(end, temp);

            start++;
            end--;
    }
    }
}

/*
Follow-ups

1. How would you implement this solution for a char[] instead of a List?

The logic stays exactly the same. The only difference is how you access and modify elements.

public void reverseString(char[] s) {

    int start = 0;
    int end = s.length - 1;

    while (start < end) {

        char temp = s[start];

        s[start] = s[end];
        s[end] = temp;

        start++;
        end--;
    }
}

2. Why is the loop condition start < end rather than start <= end?


3. What changes if the input is an immutable String?

4. How would the recursive version compare in terms of space complexity?

5.
Does using List introduce any performance considerations compared with char[]?
*/