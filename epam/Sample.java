package epam;

public class Sample {

    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 0, 3, 4, 5 };

        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        while (index < arr.length) {
            arr[index] = 0;
        }
        System.out.println(arr);
    }

}
