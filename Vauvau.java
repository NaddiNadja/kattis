import java.util.Scanner;

public class Vauvau {
    static int a;
    static int b;
    static int c;
    static int d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();

        c = sc.nextInt();
        d = sc.nextInt();

        int p = sc.nextInt();
        int m = sc.nextInt();
        int g = sc.nextInt();

        sc.close();

        check(p);
        check(m);
        check(g);
    }

    static void check(int arrival) {
        boolean[] aggr = new boolean[] {true, true};

        for (int i = 1; i<=arrival; i++) { //scuffed
            if (i>a && ((i-1) % (a+b) == 0 || (i-a-1) % (a+b) == 0)) aggr[0] = !aggr[0]; 
            if (i>c && ((i-1) % (c+d) == 0 || (i-c-1) % (c+d) == 0)) aggr[1] = !aggr[1]; 
        }

        if      (aggr[0] && aggr[1])    System.out.println("both");
        else if (!aggr[0] && !aggr[1]) System.out.println("none");
        else    System.out.println("one");
    }
}