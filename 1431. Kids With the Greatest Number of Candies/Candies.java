import java.util.ArrayList;
import java.util.List;

public class Candies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Find the maximum number of candies
        int maxCandies = candies[0];
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        // Prepare the result list
        List<Boolean> result = new ArrayList<>();

        // Check each kid and determine if they can have the greatest number of candies
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;

        System.out.println(kidsWithCandies(candies, extraCandies));
    }
}