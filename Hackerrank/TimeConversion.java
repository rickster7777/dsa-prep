public class TimeConversion {
    public static String timeConversion(String s) {
        // Write your code here
        if (s.contains("PM")) {
            String sTime = s.split(":")[0];
            int time = Integer.parseInt(sTime);
            if (time != 12) { // PM hours except 12 PM
                time += 12;
            }
            s = s.replace(sTime, String.format("%02d", time)).replace("PM", "");
        }

        if (s.contains("AM")) {
            String sTime = s.split(":")[0];
            int time = Integer.parseInt(sTime);
            if (time == 12) { // 12 AM -> 00
                time = 0;
            }
            s = s.replace(sTime, String.format("%02d", time)).replace("AM", "");
        }

        return s;
    }
}
