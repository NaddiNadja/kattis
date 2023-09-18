import java.util.Scanner;

public class NastyHacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<n; i++) {
            int r = sc.nextInt(); //revenue without
            int e = sc.nextInt(); //revenue with
            int c = sc.nextInt(); //cost
            if (e-c > r) sb.append("advertise");
            else if (e-c == r) sb.append("does not matter");
            else sb.append("do not advertise");
            if (i==n-1) break;
            sb.append("\n");
        }

        sc.close();
        System.out.println(sb.toString());
    }
}
