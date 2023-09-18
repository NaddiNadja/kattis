import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int tasks = 0;
        int sum = 0;
        for (int i = 0; i<n; i++) {
            sum+=sc.nextInt();
            if (sum > t) break;
            tasks++;
        }
        sc.close();
        System.out.println(tasks);
    }
}