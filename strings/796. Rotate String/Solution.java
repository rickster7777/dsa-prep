/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.

*/
class Solution {
    public static boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) return false;

        String doubleS = s + s;

        if(doubleS.indexOf(goal)  >= 0) return true;

        return false;

        /*
        Instead of above two lines
        This can also be used

        return doubleS.contains(goal);
        */
    }

    public static void main(String[] args) {

        String s1 = "abcde", goal1 = "cdeab";
        String s2 = "abcde", goal2 = "abced";


        System.out.println(Solution.rotateString(s1, goal1));

        System.out.println(Solution.rotateString(s2, goal2));
    }
}