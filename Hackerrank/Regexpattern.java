
//https://www.hackerrank.com/challenges/java-regex/problem?isFullScreen=true
//This is failing whnen ther's trailing 0s for eg 0000.12.134.44
//As per one of the testcase it should pass
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regexpattern {
    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String ip = sc.nextLine();

            String ipPattern = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})$";

            if (Pattern.matches(ipPattern, ip)) {
                System.out.println(true);

            } else {
                System.out.println(false);
            }

        }

        sc.close();

    }
}

//This ol worked perfectly
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String ip = sc.nextLine();
            if (isValidIP(ip)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }

        sc.close();
    }

    private static boolean isValidIP(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;

        for (String part : parts) {
            // Each octet must be 1-3 digits
            if (!part.matches("\\d{1,3}")) return false;

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }