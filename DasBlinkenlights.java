import java.util.Scanner;

public class DasBlinkenlights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int s = sc.nextInt();
        int lcm = lcm(p,q);
        System.out.println((lcm<=s)? ("yes") : ("no"));
        sc.close();
    }

    private static int lcm(int p, int q) {
        int lcm = (p<q)? q : p;
        while(true) {
            if( lcm % p == 0 && lcm % q == 0 ) break;
            ++lcm;
        }
        return lcm;
    }
} 
