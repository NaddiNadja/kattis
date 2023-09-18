import java.util.Scanner;

public class MarsWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        boolean yes = false;

        if (year == 2018) yes = true;
        else {
            int dif = year-2018;
            int months = 9+(dif-1)*12;
            for (int i = 0; i<12; i++) {
                if ((months+i) % 26 == 0) {
                    yes = true;
                    break;
                }
            }
        }
        sc.close();
        if (yes) System.out.println("yes");
        else System.out.println("no");
    }
}
