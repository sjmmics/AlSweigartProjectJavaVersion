package project;

import java.util.Scanner;

public class BirthdayParodox implements Project {
    CommonFunc cmfc = new CommonFunc();
    private static final int[] DAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public void run() {
        int cnt = getValidcnt();

    }
    public void introduction() {

    }

    public int getValidcnt() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("How many birthdays shall I generate? (Max 100)");
            String ans = in.nextLine();
            if (cmfc.isNumberic(ans)) {
                int ansInt = Integer.parseInt(ans);
                if (0 <= ansInt && ansInt <= 365) {
                    return ansInt;
                }
            }
        }
    }

    public static String transMonthandDay(int day365) {
        int month;
        for (month = 0; month < 12; month++) {
            if (day365 > DAY_OF_MONTH[month]) {
                day365 -= DAY_OF_MONTH[month];
            } else {
                break;
            }
        }
        return MONTHS[month] + " " + day365;
    }

}