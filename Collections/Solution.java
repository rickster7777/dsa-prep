class Solution {

    public static String reverString(String s){


            String[] str = s.trim().split("\\s+");

            int len = str.length;
            // Approach 1
            String[] result = new String[len];
            int j = 0;


            for(int i = len - 1; i >= 0; i--){
                result[j] = str[i];
                j++;
            }

            return String.join(" ", result);

            // Approach 2
            StringBuilder sb = new StringBuilder();

            for(int i = len - 1; i >= 0; i--){
                sb.append(str[i] + " ");
            }

            return sb.toString();
        }

    public static void main(String[] args){

        String s = "hello world";

        System.out.println(Solution.reverString(s));

        String s1 = " the sky is blue ";

        System.out.println(Solution.reverString(s1));

        String s2 = "a good example";
        System.out.println(Solution.reverString(s2));

    }
}