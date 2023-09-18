import java.util.Scanner;
import java.lang.Math;

public class SantaKlas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int v = sc.nextInt();

        if (v<=180) System.out.println("safe");
        else if (v == 270) System.out.println(h);
        else {
            if (v<270) v = 270-v;
            else v = v-270;
            System.out.println((int) Math.floor(h/Math.cos(v /(180/Math.PI))));
        }
        sc.close();
    }
}
