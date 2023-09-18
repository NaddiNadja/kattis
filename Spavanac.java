import java.util.Scanner;

public class Spavanac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();
        
        int total = H*60 + M;
        total = total - 45;
        if (total < 0) total = 24*60 + total;
        
        H = total / 60;
        M = total % 60;

        System.out.println(H + " " + M);

    }
}