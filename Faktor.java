import java.util.Scanner;

public class Faktor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int I = sc.nextInt();
        sc.close();

        System.out.println(A * (I-1) + 1);
    }
}
