import java.util.Scanner;

public class Chokolade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int i = scanner.nextInt();
        for (int k=0; k<n-1; k++){
            int j = scanner.nextInt();
            if (j>i) count++;
            i=j;
        }
        System.out.println(count);
        scanner.close();
    }
}