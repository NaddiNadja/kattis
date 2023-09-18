import java.util.Scanner;
import java.lang.Math;

public class JobExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        
        for (int i = 0; i<n; i++) {
            int x = sc.nextInt();
            if (x<0) sum+=x;
        }

        sc.close();
        System.out.println(Math.abs(sum));
    }
}