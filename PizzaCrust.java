import java.util.Scanner;
import java.lang.Math;

public class PizzaCrust {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.close();

        double areaR = Math.PI * R * R;
        double areaC = Math.PI * (R-C) * (R-C);
        double prcnt = 0;
        if (areaC != 0) prcnt = (areaC / areaR) * 100;
        System.out.println(prcnt);
    }
}
