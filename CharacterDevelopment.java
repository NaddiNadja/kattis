import java.util.Scanner;
import java.lang.Math;

public class CharacterDevelopment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n == 0 || n == 1) System.out.println(0);
        else System.out.println((int) Math.pow(2,n)-(n+1));
    }
}
