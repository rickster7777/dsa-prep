package Striver.Pattern;

public class Patterns1 {

    public void eleven(){

        /*
        1
        0 1
        1 0 1
        0 1 0 1
        1 0 1 0 1
        */

        for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println("");
        }
    }

        public void twelve(){

            /*
            1        1
            12      21
            123    321
            1234  4321
            1234554321
            */

            int n = 5;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    System.out.print(j);
                }
                for(int j=1;j<=2*(n-i);j++){
                    System.out.print(" ");
                }
                for(int j=i;j>=1;j--){
                    System.out.print(j);
                }
                System.out.println("");
            }
        }


        public void thirteen() {

            System.out.println("thirteen Pattern: ");
            /*
             *
             * 1
             * 2 3
             * 4 5 6
             * 7 8 9 10
             * 11 12 13 14 15
             */
            int count = 1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(count + " ");
                    count++;
                }
                System.out.println("");
            }
        }


        public void fourteen(){
            /*
            A
            AB
            ABC
            ABCD
            ABCDE
            */

            for(int i=0;i<5;i++){
                for(int j=0;j<=i;j++){
                    System.out.print((char)(j+65));
                }
                System.out.println("");
            }
        }


        public void fifteen(){

            /*
            ABCDE
            ABCD
            ABC
            AB
            A
            */

            int n = 5;
            for(int i=0;i<n;i++){
                for(int j=0;j<n-i;j++){
                    System.out.print((char)(j+65));
                }
                System.out.println("");
            }
        }


        public void sixteen(){

            /*
            A
            BB
            CCC
            DDDD
            EEEEE */

            int n = 5;
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    System.out.print((char)(i+65));
                }
                System.out.println("");
            }
        }


        public void seventeen(){
            /*
                A
               ABA
              ABCBA
             ABCDCBA
            ABCDEDCBA
            */
            // ABC pyramid
            int n =5;

            for(int i=0;i<n;i++){
                //
                for(int j=0;j<n-i-1;j++){
                    System.out.print(" ");
                }

                // Increasing part
                for(int j=0;j<=i;j++){
                    System.out.print((char)(j+65));
                }

                // Decreasing part
                for(int j=i-1;j>=0;j--){
                    System.out.print((char)(j+65));
                }

                // New line
                System.out.println("");
            }
        }


        public void eighteen(){

            /*
            E
            DE
            CDE
            BCDE
            ABCDE
            */

            int n = 5;
            // Decreasing part
            for(int i=0;i<n;i++){
                // Increasing part
                for(int j=n-i-1;j<n;j++){
                    // Print characters by converting ASCII value to char
                    System.out.print((char)(j+65));
                }
                System.out.println("");
            }
        }


        public void nineteen(){

            // diamond inside square pattern
            /*
            **********
            ****  ****
            ***    ***
            **      **
            *        *
            *        *
            **      **
            ***    ***
            ****  ****
            **********
            */

            int n = 5;
            // Upper half of the hollow diamond
            for (int i = 1; i <= n; i++) {

                // Print stars
                for (int j = 1; j <= n - i + 1; j++) {
                    System.out.print("*");
                }

                // Print spaces
                for (int j = 1; j <= 2 * (i - 1); j++) {
                    System.out.print(" ");
                }

                // Print stars
                for (int j = 1; j <= n - i + 1; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }

        public void twenty(){

            // This looks like a horizontal hourglass pattern
            /*
            *        *
            **      **
            ***    ***
            ****  ****
            **********
            ****  ****
            ***    ***
            **      **
            *        *
            */

            int n = 5;
            // Upper half of the hollow diamond
            for (int i = 1; i <= n; i++) {

                // Print stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                // Print spaces
                for (int j = 1; j <= 2 * (n - i); j++) {
                    System.out.print(" ");
                }

                // Print stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }

        public void twentyOne(){

            // Hollow square pattern
            /*
            *****
            *   *
            *   *
            *   *
            *****
            */

            int n = 5;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == 1 || i == n || j == 1 || j == n) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

        public void twentyTwo(){

            /*
            5 5 5 5 5 5 5 5 5
            5 4 4 4 4 4 4 4 5
            5 4 3 3 3 3 3 4 5
            5 4 3 2 2 2 3 4 5
            5 4 3 2 1 2 3 4 5
            5 4 3 2 2 2 3 4 5
            5 4 3 3 3 3 3 4 5
            5 4 4 4 4 4 4 4 5
            5 5 5 5 5 5 5 5 5             */
        /*
        explanation: For a given n, the pattern is a square of size (2*n - 1) x (2*n - 1). The value at each position in the square is determined by the minimum distance from the edges of the square. The outermost layer has the value n, the next layer has the value n-1, and so on, until the center of the square which has the value 1. This creates a concentric pattern of decreasing numbers towards the center.
        1. The outermost layer (the border of the square) is filled with the number n.
        2. The next layer inside the border is filled with the number n-1.
        3. This continues until the innermost layer, which is filled with the number 1.
        4. The pattern is symmetric both horizontally and vertically, creating a square with concentric layers of numbers.
        5. The size of the square is (2*n - 1) x (2*n - 1), which means for n=5, the square is 9x9.
        6. The value at each position (i, j) in the square can be calculated by finding the minimum distance from the edges of the square and subtracting that from n.
        7. Specifically, for a position (i, j), the value is determined by:
           - top = i
           - left = j
           - right = (2*n - 2) - j
           - bottom = (2*n - 2) - i
           - min_distance = min(top, left, right, bottom)
           - value_at_position = n - min_distance
        */
        int n = 5;

        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                int top = i;
                int left = j;
                int right = (2 * n - 2) - j;
                int bottom = (2 * n - 2) - i;
                int min = Math.min(Math.min(top, bottom), Math.min(left, right));
                System.out.print((n - min) + " ");
            }
            System.out.println();
        }
    }
        public static void main(String[] args) {

            Patterns1 patterns1 = new Patterns1();
            patterns1.eleven();
            patterns1.twelve();
            patterns1.thirteen();
            patterns1.fourteen();
            patterns1.fifteen();
            patterns1.sixteen();
            patterns1.seventeen();
            patterns1.eighteen();
            patterns1.nineteen();
            patterns1.twenty();
            patterns1.twentyOne();
            patterns1.twentyTwo();
        }
}
