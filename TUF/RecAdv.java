
public class RecAdv {

    public static void main(String[] args) {
        int[] arr = new int[10];

        int[] nums = { 3,3, 2, 1 };

        for (int num : nums) {
            arr[num]++;
        }


        for (int i = arr.length - 1; i >=0; i--) {
            if(arr[i] > 0){
                System.out.println(i - 1);
                break;
            }
        }
    }

}
