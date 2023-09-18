import java.util.Scanner;

public class R2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int S = sc.nextInt();
        sc.close();

        System.out.println(2*S-R);
    }
}