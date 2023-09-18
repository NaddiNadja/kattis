import java.util.Scanner;

public class GreedilyIncreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int x = sc.nextInt();
        sb.append(x);
        int sum = 0;

        for (int i = 0; i<n-1; i++) {
            int y = sc.nextInt();
            if (y>x) {
                sb.append(" ");
                sb.append(y);
                sum++;
                x = y;
            }
        }

        sc.close();
        System.out.println(sum+1);
        System.out.println(sb.toString());
    }
}