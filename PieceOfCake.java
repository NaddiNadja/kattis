import java.util.Scanner;

public class PieceOfCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int v = sc.nextInt();
        sc.close();

        int l = 0;
        int b = 0;
        if (h*2<n) l = n-h;
        else l = h;
        if (v*2<n) b = n-v;
        else b = v;

        System.out.println(l*b*4);
    }
}