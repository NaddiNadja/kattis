import java.util.Scanner;

public class SpeedLimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n<0) break;
            int[] s = new int[n];
            int[] t = new int[n];

            for (int i = 0; i<n; i++) {
                s[i] = sc.nextInt();
                t[i] = sc.nextInt();
            }

            for (int i = n-1; i>0; i--) {
                t[i] = t[i]-t[i-1];
            }
            int miles = 0;
            for (int i = 0; i<n; i++) {
                miles += t[i] * s[i];
            }
            System.out.println(miles + " miles");
        }
        sc.close();
    }
}
