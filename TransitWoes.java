import java.util.Scanner;

public class TransitWoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int n = sc.nextInt(); 
        int[] d = new int[n+1];
        for (int i = 0; i<=n; i++) d[i] = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i<n; i++) b[i] = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i<n; i++) c[i] = sc.nextInt();
        sc.close();

        int curtime = s;
        boolean ontime = true;

        for (int i = 0; i < n; i++) {
            curtime += d[i];                        //   Vi går hen til transit
            if (curtime % c[i] != 0)                //   Hvis transit ikke er ankommet,
                curtime += c[i]-(curtime % c[i]);   //   så venter vi på transit
            curtime += b[i];                        //   Vi tager transit
            if (i == n-1)                           //   Hvis vi har taget sidste transit,
                curtime += d[n];                    //   så går vi til skole

            if (curtime > t) {                      //   Break, hvis vi er for sent på den
                ontime = false;
                break;
            }
        }

        if (ontime) System.out.println("yes");
        else System.out.println("no");
    }
}
