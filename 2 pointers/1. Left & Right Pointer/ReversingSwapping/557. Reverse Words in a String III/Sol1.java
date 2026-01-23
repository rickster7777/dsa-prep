public class Sol1 {

    public String reverseWordss(String input){
        char[] chars = input.toCharArray();

        //Expected: [Let's, take, LeetCode, contest]
        //Reality:  ['L','e','t',''','s',' ','t','a','k','e',' ','L','e','e','t','C','o','d','e',' ','c','o','n','t','e','s','t']

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
