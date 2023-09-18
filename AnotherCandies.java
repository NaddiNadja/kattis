import java.util.Scanner;

public class AnotherCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<t; i++) {
            int n = sc.nextInt();
            long candies = 0;
            for (int j = 0; j<n; j++) candies += (sc.nextLong() % n); 
            sb.append(candies % n == 0 ? "YES\n" : "NO\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }
}