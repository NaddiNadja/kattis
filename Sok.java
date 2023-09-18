import java.util.Scanner;

public class Sok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double i = sc.nextInt();
        double j = sc.nextInt();
        double k = sc.nextInt();
        sc.close();

        double orange = a / i;
        double apple = b / j;
        double pineapple = c / k;
        double drinks = 0;

        if (orange < apple && orange < pineapple) drinks = orange;
        else if (apple < pineapple) drinks = apple;
        else drinks = pineapple;

        System.out.println((a-drinks*i)+ " " + (b-drinks*j) + " " +(c-drinks*k));
    }
}
