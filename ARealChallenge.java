import java.util.Scanner;
import java.lang.Math;

public class ARealChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = Long.parseLong(sc.nextLine());
        sc.close();
        double res = Math.sqrt(a)*4;
        System.out.println(res);
    }
}
