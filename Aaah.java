import java.util.Scanner;

public class Aaah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jon = sc.nextLine();
        String doc = sc.nextLine();
        sc.close();

        if (jon.length()<doc.length()) System.out.println("no");
        else System.out.println("go");
    }
}
