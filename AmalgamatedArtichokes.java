import java.util.Scanner;
import java.lang.Math;

public class AmalgamatedArtichokes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        double[] price = new double[n];
        for (int k = 1; k<n+1; k++) price[k-1] = p*(Math.sin(a*k+b)+Math.cos(c*k+d)+2);

        double curhi = price[0];
        double curlo = price[0];
        double maxdec = 0;

        for (int i = 1; i<n; i++) {
            if (price[i] < curlo || curlo<0 && price[i]<=curhi) {
                curlo = price[i];
                if (curhi-curlo > maxdec) maxdec = curhi-curlo;
            } else if (price[i] > curhi) {
                curhi = price[i];
                curlo = -1;
            }
        }
        System.out.println(maxdec);
    }
}
