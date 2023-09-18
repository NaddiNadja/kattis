import java.util.Scanner;

public class WalrusWeights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i<n; i++) weights[i] = sc.nextInt();
        int lift = 0;
        
        sc.close();
        System.out.println(lift);
    }
}
