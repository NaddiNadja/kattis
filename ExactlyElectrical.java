import java.util.Scanner;
import java.lang.Math;

public class ExactlyElectrical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int t = sc.nextInt();
        sc.close();
        int d = Math.abs(x1-x2)+Math.abs(y1-y2);
        if (d > t || (t-d) % 2 != 0) System.out.println("N");
        else System.out.println("Y");
    }
}
