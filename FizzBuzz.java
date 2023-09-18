import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int N = sc.nextInt();
        sc.close();

        for (int i = 1; i<=N; i++) {
            if (i % X == 0) System.out.print("Fizz");
            if (i % Y == 0) System.out.print("Buzz");
            if (i % X != 0 && i % Y != 0) System.out.print(i);
            System.out.println();
        }
    }
}
