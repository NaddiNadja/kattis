import java.util.Scanner;

public class CarouselRides {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (n>0 && m>0) {
            boolean found = false;
            double bestvala = -1;
            double bestvalb = 0;
            for (int i = 0; i<n; i++) {
                double a = sc.nextInt();
                double b = sc.nextInt();
                if (a>m) continue;
                else {
                    if (bestvala==-1 || (bestvalb/bestvala == b/a && b>bestvalb) || bestvalb/bestvala > b/a) {
                        bestvala = a;
                        bestvalb = b;
                        found = true;
                    }
                }
            }

            if (found) {
                sb.append("Buy ");
                sb.append((int) bestvala);
                sb.append(" tickets for $");
                sb.append((int) bestvalb);
            } else sb.append("No suitable tickets offered");

            n = sc.nextInt();
            m = sc.nextInt();
            if (n>0 && m>0) sb.append("\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }
}
