import java.util.Scanner;

public class Pot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = 0;

        for (int i = 0; i<N; i++) {
            int x = sc.nextInt();
            int pot = x % 10;
            x = (x - (x % 10)) / 10;
            X = X + (int) Math.pow(x, pot);
        }

        sc.close();

        System.out.println(X);
    }
}
