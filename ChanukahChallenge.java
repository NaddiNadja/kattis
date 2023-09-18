import java.util.Scanner;

public class ChanukahChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();

        for (int i = 0; i<P; i++) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int sum = 0;
            for (int j = 1; j<=N; j++) {
                sum += j+1;
            }  
            System.out.println(K + " " + sum);
        }
        sc.close();
    }
}
