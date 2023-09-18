import java.util.Scanner;

public class LeftBeehind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0) break;
            else if (x+y == 13) System.out.println("Never speak again.");
            else if (x == y) System.out.println("Undecided.");
            else if (x > y) System.out.println("To the convention.");
            else System.out.println("Left beehind.");
        }
        sc.close();
    }
}