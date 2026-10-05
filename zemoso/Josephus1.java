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

    //Iterative function to find the position of the survivor
    public static int josephus(int n, int k) {
        int survivor = 0; // Base case: when there's only one person, they are the survivor

        // Loop through each number of people from 2 to n
        for (int i = 2; i <= n; i++) {
            // Update the position of the survivor based on the current number of people
            survivor = (survivor + k) % i;
        }

        // Convert from 0-based index to 1-based index
        return survivor + 1;
    }
    //Recursive function to find the position of the survivor
    //n: number of people, k: step size
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