public class Sol1 {
    
    public String reverseWordss(String input){
        char[] chars = input.toCharArray();

        System.out.println(chars);
        int start = 0;
        int end = chars.length - 1;

        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end]= temp;
            start++;
            end--;
        }

        return new String(chars);


    }
    public static void main(String[] args) {
        Sol1 sol = new Sol1();
        String input = "Let's take LeetCode contest";
        String output = sol.reverseWordss(input);
        System.out.println(output); // Output: "tsetnoc edoCteeL ekat s'teL"
    }
}
