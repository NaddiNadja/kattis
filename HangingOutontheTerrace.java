import java.util.Scanner;

public class HangingOutontheTerrace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int x = sc.nextInt();

        int cur = 0;
        int ill = 0;

        for (int i = 0; i<x; i++) {
            String action = sc.next();
            int p = sc.nextInt();
            if (action.equals("enter")) {
                cur += p;
                if (cur>L) {
                    ill++;
                    cur -= p;
                }
            } else {
                cur -= p;
            }
        }
        sc.close();
        System.out.println(ill);
    }
}
