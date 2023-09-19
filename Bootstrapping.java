import java.util.*;
public class Bootstrapping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        float upperBound = 0;
        float lowerBound = 2;
        while (upperBound == 0) {
            if (Math.pow(n, 1/lowerBound) > lowerBound) lowerBound ++;
            else upperBound = lowerBound;
        }

        if (Math.pow(n, 1/upperBound) == upperBound) {
            System.out.println(upperBound);
            return;
        }

        float dif = 1f;

        while (true) {
            if (Math.pow(n, 1/lowerBound) > lowerBound) lowerBound += dif;
            else lowerBound -= dif;
            if (check(lowerBound, n)) break;
            dif /= 2;
        }
        System.out.println(lowerBound);
        
    }

    private static boolean check(float lowerBound, int total) {
        return Math.abs(Math.pow(lowerBound, lowerBound)-total) <= 0.000001;
    }
}
