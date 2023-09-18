import java.util.Scanner;

public class Digitproduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.close();

        while (x>9) {
            int x1 = x % 10;
            int x2 = (x-x1) / 10 % 10;
            int x3 = 1;
            if (x>99) x3 = (((x-x1)/10) - x2 / 10 % 10) /10;
            
            if (x1 == 0) x1 = 1;
            if (x2 == 0) x2 = 1;
            if (x3 == 0) x3 = 1;

            x = x1*x2*x3;
        }

        System.out.println(x);
    }
}
