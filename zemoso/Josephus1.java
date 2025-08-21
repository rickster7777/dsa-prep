/*
The Josephus Problem is a classic theoretical problem related to a group of people standing in a circle waiting to be eliminated. 
Every k-th person is eliminated in the circle until only one survives.

🧠 Problem Statement

Given:
n people in a circle (numbered from 1 to n)
A step size k — every k-th person is eliminated
Goal: Find the position (1-based) of the person who survives.
 */


public class Josephus1 {
    public static int findSurvivor(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (findSurvivor(n - 1, k) + k - 1) % n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 7; // Number of people
        int k = 3; // Step size
        int survivor = findSurvivor(n, k);
        System.out.println("The survivor is at position: " + survivor);
    }
}