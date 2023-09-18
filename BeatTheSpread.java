import java.util.Scanner;

public class BeatTheSpread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i<n; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            if ((s+d) % 2 != 0) {
                System.out.println("Impossible");
                continue;
            }
            int a = (s+d) / 2;
            int b = s-a;
            if (a<0 || b<0) System.out.println("Impossible");
            else System.out.println(a + " " + b);
        }
        sc.close();
    }
}

/*

5
80 30
3 1
85 32

*/