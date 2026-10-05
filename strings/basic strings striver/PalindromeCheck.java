package strings.basic strings striver;

public class PalindromeCheck {
    public boolean palindromeCheck(String s) {

        int j = s.length() - 1;

        for (int i = 0; i < s.length() / 2; i++) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            j--;
        }

        return true;
    }
    // Approach 2
    // new Stringbuilder(s).reverse().toString();
    // return s.equals(str);
}
