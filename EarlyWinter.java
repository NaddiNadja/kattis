import java.util.Scanner;

public class EarlyWinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dm = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i<n; i++) d[i] = sc.nextInt();
        sc.close();
        boolean found = false;
        int years = 0;
        for (int i = 0; i<n; i++) {
            if (d[i] <= dm) {
                found = true;
                years = i;
                break;
            }
        }
        if (found) System.out.println("It hadn't snowed this early in " + years + " years!");
        else System.out.println("It had never snowed this early!");
    }
}
