package BitManipulation;

//Check if a number is odd or not without %

public class EveneOdd {
    public static void main(String[] args) {
        int n = 5;


        /*
        Approach 1: The least significant bit (LSB) determines odd/even:
        1 → odd
        0 → even

        | Number | Binary | n & 1 | Result |
        | ------ | ------ | ----- | ------ |
        | 5      | 101    | 1     | Odd    |
        | 8      | 1000   | 0     | Even   |
        */

        if ((n & 1) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }

        // Second approach Using Division and Multiplication
        boolean check = (n / 2) * 2 != n;
        System.out.println(check);
    }
}
