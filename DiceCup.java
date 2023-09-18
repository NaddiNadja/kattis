import java.util.Scanner;
import java.lang.Math;

public class DiceCup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<=(Math.abs(n-m)+1); i++) {
            if (i>1) sb.append("\n");
            if (n>m) sb.append(m+i);
            else sb.append(n+i);
        }

        System.out.println(sb.toString());
    }
}