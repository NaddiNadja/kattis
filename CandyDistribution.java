import java.util.Scanner;

public class CandyDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<t; i++) {
            int K = sc.nextInt();
            int C = sc.nextInt();

            for (int a = 1; a<10; a++) {
                if ((a*C - 1) % K == 0) {
                    sb.append(a);
                    break;
                }
            }
            if (i!=t-1) sb.append("\n");
            // boolean possible = true;
            // if (C % K == 0) possible = false;
            // int res = -1;
            // int i = 0;
            // while (res<0 && possible) {
            //     if ((C * i - 1) % K == 0) res = i;
            //     i++;
            // }
            // if (possible) out.append(res);
            // else out.append("Impossible");
            // if (i!=t-1) out.append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}