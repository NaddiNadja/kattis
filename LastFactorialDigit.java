import java.util.Scanner;

public class LastFactorialDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<N; i++) {
            int a = sc.nextInt();
            int af = factorial(a) % 10;
            sb.append(af); 
            if (i == N-1) break;
            sb.append("\n");
        }

        sc.close();
        System.out.println(sb.toString());    
    }

    static int factorial(int i) {
        int fact = i;
        while (i>1) {
            i--;
            fact = fact*i;
        }
        return fact;
    }
}