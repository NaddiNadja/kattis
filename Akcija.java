import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Akcija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] in = new int[n];
        for (int i = 0; i<n; i++) in[i] = sc.nextInt();
        sc.close();
        Arrays.sort(in);
        int minprice = 0;
        for (int i = 0; i<n; i++) {
            int index = Math.abs(i-n) - 1;
            if ((i+1) % 3 != 0) minprice += in[index];
        }
        System.out.println(minprice);
    }
}
