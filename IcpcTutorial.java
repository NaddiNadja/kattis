import java.util.Scanner;
import java.lang.Math;

public class IcpcTutorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();
        sc.close();

        boolean tle = false;

        switch (t) {
            case 1 : // O(n!)
                if (factorial(n, m) > m) tle = true;
                break;

            case 2 : // O(2^n)
                if (Math.pow(2,n) > m) tle = true;
                break;

            case 3 : // O(n^4)
                if (Math.pow(n,4) > m) tle = true;
                break;

            case 4 : // O(n^3)
                if (Math.pow(n,3) > m) tle = true;
                break;

            case 5 : // O(n^2)
                if (Math.pow(n,2) > m) tle = true;
                break;

            case 6 : // O(n log n)
                if (n * log2(n) > m) tle = true;
                break;

            case 7 : // O(n)
                if (n > m) tle = true;
                break;
        }

        if (tle) System.out.println("TLE");
        else System.out.println("AC");
    }

    // modified factorial for runtime purposes
    // no need to keep calculating the factorial if it exceeds the limit
    private static long factorial(int i, int limit) {
        int fact = i;
        while (i>1) {
            i--;
            fact = fact*i;
            if (fact>limit) return limit+1;
        }
        return fact;
    }

    private static double log2(int n) { 
        return (Math.log(n) / Math.log(2));
    }
}
