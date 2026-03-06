import java.util.Arrays;
/*
Input: bills = [5,5,5,10,20]
Output: true
explanation: From the first 3 customers, we collect three $5 bills in order. From the fourth customer, we collect a $10 bill
and give back a $5 bill. From the fifth customer, we give a $10 bill and a $5 bill.

Input: [5,5,10]
Output: true

Input: [10,10]
Output: false

*/
class Solution {
    // My Solution (Wrong)
    public boolean lemonadeChange(int[] bills) {

        Arrays.sort(bills);
        int count5 = 0;
        int count10 = 0;

        for (int num : bills) {

            if (num == 5) {
                count5++;

            } else if (num == 10) {
                if (count5 > 0) {
                    count5--;
                } else {
                    return false;
                }
                count10++;

            } else {
                int total_return = 15;

                if (count10 > 0) {
                    count10--;
                    total_return = 5;
                }

                while (count5 > 0 && total_return > 0) {
                    count5--;
                    total_return -= 5;

                }

                if (total_return != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
     * ❌ Main Mistake:
     * You are doing:
     * 
     * Arrays.sort(bills);
     * This is wrong because customers must be processed in the given order.
     * This is a queue simulation problem.
     * Sorting destroys the transaction order.
     *
     * 💡 Correct Greedy Idea
     *
     * Track how many:
     * $5 bills
     * $10 bills
     * 
     * You never need to track $20 bills because they are never used as change.
     * 🔎 Rules
     * If customer pays $5
     * Just collect it → count5++
     * If customer pays $10
     * Must give back $5
     * If no $5 → return false
     * Else:
     * count5--
     * count10++
     *
     * If customer pays $20
     * Need to give $15 change.
     *
     * Best strategy:
     * Prefer giving $10 + $5 (better greedy choice)
     * Otherwise give three $5 bills
     * Else → return false
     * Why prefer $10 + $5?
     * Because $5 bills are more flexible for future transactions.
     */

    public boolean lemonadeChangeOp(int[] bills) {

        int count5 = 0;
        int count10 = 0;

        for (int bill : bills) {

            if (bill == 5) {
                count5++;
            }

            else if (bill == 10) {
                if (count5 == 0)
                    return false;
                count5--;
                count10++;
            }

            else { // bill == 20

                // Prefer 10 + 5
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                }
                // Otherwise use three 5s
                else if (count5 >= 3) {
                    count5 -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // using switch case
    public boolean lemonadeChangeSwitch(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five-- <= 0)
                        return false;
                    ten++;
                    break;
                default: // 20
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
            }
        }
        return true;
    }
}