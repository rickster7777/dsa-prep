public class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;

        int n = points.length;

        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                for (int k = j + 1; k < n; k++) {
                    int[] p3 = points[k];
                    double area = triangleArea(p1, p2, p3);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private double triangleArea(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs(
            a[0] * (b[1] - c[1]) +
            b[0] * (c[1] - a[1]) +
            c[0] * (a[1] - b[1])
        );
    }
}
