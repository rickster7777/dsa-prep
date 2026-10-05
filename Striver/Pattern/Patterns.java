public class Patterns {

    public void first() {

        System.out.println("First Pattern: ");
        /*
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public void second() {

        System.out.println("Second Pattern: ");
        /*
         *

         *
         * *
         * * *
         * * * *
         * * * * *

         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");

            }
            System.out.println("");
        }
    }

    public void third() {

        System.out.println("Third Pattern: ");
        /*
         * 
         * 1
         * 1 2
         * 1 2 3
         * 1 2 3 4
         * 1 2 3 4 5
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1 + " ");
            }
            System.out.println("");
        }
    }

    public void fourth() {

        System.out.println("fourth Pattern: ");
        /*
         * 
         * 1
         * 2 2
         * 3 3 3
         * 4 4 4 4
         * 5 5 5 5 5
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println("");
        }
    }

    public void fifth() {

        System.out.println("fifth Pattern: ");
        /*
         * 
         * * * * *
         * * * *
         * * *
         * *
         * 
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public void sixth() {

        System.out.println("sixth Pattern: ");
        /*
         * 
         * 1 2 3 4 5
         * 1 2 3 4
         * 1 2 3
         * 1 2
         * 1
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(j + 1 + " ");
            }
            System.out.println("");
        }
    }

    public void seventh(){

        //Pyramid Pattern
        System.out.println("seventh Pattern: ");

        int n = 5;
        for (int i = 1; i <= n; i++) {
            
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    public void eighth(){

        //Reverse Pyramid Pattern
        System.out.println("eighth Pattern: ");
        int n = 5;
        for (int i = n; i >= 1; i--) {

            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    public void ninth(){

        //Diamond Pattern
        System.out.println("ninth Pattern: ");
        int n = 5;

        // Upper half of the diamond
        for (int i = 1; i <= n; i++) {

            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Lower half of the diamond
        for (int i = n - 1; i >= 1; i--) {

            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }


    public void tenth(){

        //Hollow Diamond Pattern
        System.out.println("tenth Pattern: ");
        int n = 5;

        // Upper half of the hollow diamond
        for (int i = 1; i <= n; i++) {

            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print stars and spaces
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        // Lower half of the hollow diamond
        for (int i = n - 1; i >= 1; i--) {

            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print stars and spaces
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }


    // public void seventh() {

    //     System.out.println("seventh Pattern: ");
    //     /*
    //     *
    //     ***
    //     *****
    //     *********
    //     ***********
    //     */
    //     for (int i = 0; i < 5; i++) {
    //         int count = 2 * i + 1;
    //         for (int j = 0; j < 5; j++) {
    //             if (j == 2) {
    //                 System.out.print("* ".repeat(count));
    //             }
    //         }
    //         System.out.println("");
    //     }


    //     //2nd approach
    //     int n = 5;
    //     for (int i = 1; i <= n; i++) {

    //         // Print stars
    //         for (int j = 1; j <= (2 * i - 1); j++) {
    //             System.out.print("* ");
    //         }

    //         System.out.println();
    //     }
    // }

    public static void main(String[] args) {
        Patterns patterns = new Patterns();
        // patterns.first();
        // patterns.second();
        // patterns.third();
        // patterns.fourth();
        // patterns.fifth();
        // patterns.sixth();
        patterns.tenth();
    }
}
