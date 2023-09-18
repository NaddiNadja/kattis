import java.util.Scanner;

public class HeartRate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<N; i++) {
            int b = sc.nextInt();
            double p = Double.parseDouble(sc.next());

            if (i>0) sb.append("\n");
            double x = 60*b/p;
            double y = 60/p;
            sb.append(x-y);
            sb.append(" ");
            sb.append(x);
            sb.append(" ");
            sb.append(x+y);
        }

        sc.close();
        System.out.println(sb.toString());
    }
}
