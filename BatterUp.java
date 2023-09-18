import java.util.Scanner;

public class BatterUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0.0;
        int amount = 0;
        for (int i = 0; i<n; i++) {
            int x = sc.nextInt();
            if (x>=0) {
                sum += x;
                amount++;
            }
        }
        sc.close();
        System.out.println(sum/amount);
    }
}
