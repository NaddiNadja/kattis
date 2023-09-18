import java.util.Scanner;
import java.lang.Math;

public class Slatkisi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        int bills = (int) Math.pow(10, k);
        int b = bills * (c / bills);

        if (c-b < (b+bills)-c) System.out.println(b);
        else System.out.println(b+bills);
    }
}
