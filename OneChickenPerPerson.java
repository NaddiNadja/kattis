import java.util.Scanner;
import java.lang.Math;

public class OneChickenPerPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String p = (Math.abs(n-m) == 1)? " piece" : " pieces" ;
        System.out.println((n<m)? ("Dr. Chaz will have " + (m-n) + p + " of chicken left over!") : ("Dr. Chaz needs " + (n-m) + " more" + p + " of chicken!"));
        sc.close();
    }
}
