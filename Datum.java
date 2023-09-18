import java.util.Scanner;

public class Datum {
    static int[] days = new int[] {0,31,59,90,120,151,181,212,243,273,304,334};
    static String[] weekdays = new String[] {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        System.out.println(getWeekday(d+getDays(m)));
    }

    static int getDays(int months) {
        return days[months-1];
    }

    static String getWeekday(int totaldays) {
        return weekdays[totaldays % 7];
    }
}
