//To find the number of sub arays that sum upto negative.

public class javaSubarray {
    //My approach
    /*
        int count = 0;
        int sum = 0;

        for(int num: arr){
            sum += num;

            if (num < 0){
                count++;
            }

            if(sum < 0){
                count++;
            }
            while(current_index < index before this ){
                subtract values until its less than 0;
            }
     */

    // Correct approach
     // Check all subarrays
         int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum < 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
}
