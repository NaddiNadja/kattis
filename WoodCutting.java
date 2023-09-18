import java.util.Scanner;

// IKKE RIGTIG: Forstår ikke helt opgaven.

public class WoodCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i<t; i++) {
            int n = sc.nextInt();
            int[] wait = new int[n];
            for (int j = 0; j<n; j++) {
                int w = sc.nextInt();
                int woodsum = 0;
                for (int k = 0; k<w; k++) woodsum+=sc.nextInt();
                wait[j] = woodsum;
            }
            double waitsum = 0;
            for (int j = 0; j<n; j++) waitsum += wait[j];
            System.out.println(waitsum/n);
        }
        sc.close();
    }
}
