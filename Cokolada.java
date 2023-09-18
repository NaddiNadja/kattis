import java.util.Scanner;
import java.lang.Math;

public class Cokolada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();
        int n = (int) Math.pow(2, Math.ceil(log2(k)));
        int breaks = binarySearch(n,k);
        System.out.print(n + " " + breaks);
    }

    private static double log2(int n) { 
        return (Math.log(n) / Math.log(2));
    } 

    private static int binarySearch(int n, int k) {
        int jumps = 0;
        int lo = 0;
        int hi = n;

        if (n == k) return 0;

        while (lo<=hi) {
            jumps++;
            int mid = lo+(hi-lo)/2;
            if (mid == k) break; 

            if (mid > k) hi = mid-1;
            else lo = mid+1;
        }
        
        return jumps;
    }
}

// 1 2 3 4 5 6 7 8
// 7 = 111
// 5 = 101
// 6 = 110