// class Solution {
//     public int[][] flipAndInvertImage(int[][] image) {

//         int n = image.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; i++) {
//                 image[i[image[j]] = 
//             }
//         }
//     }
// }

/*
 * I was using two loops in this 
 * maybe more than that later on .
 * points i was missing here was of
 * bit manipulation can be used 
 */


class Solution {

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while (left <= right) {
                // Flip and invert in one step
                int tempLeft = image[i][left] ^ 1; // XOR to invert
                int tempRight = image[i][right] ^ 1;

                // Swap them
                image[i][left] = tempRight;
                image[i][right] = tempLeft;

                left++;
                right--;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] image = {
            {1, 1, 0},
            {1, 0, 1},
            {0, 0, 0}
        };

        sol.flipAndInvertImage(image);
    }
}
