import java.util.Arrays;
import java.util.Scanner;

public class IcpcTeamSelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int datasets = sc.nextInt();
        for (int rounds = 0; rounds<datasets; rounds++) {
            int s = 0;
            int n = sc.nextInt();
            int[] input = new int[3*n];
            for (int i = 0; i<3*n; i++) input[i] = sc.nextInt();
            Arrays.sort(input);
            int pos = 3*n-2;
            for (int i = 0; i<n; i++) {
                s += input[pos];
                pos -= 2;
            }
            System.out.println(s);
        }
        sc.close();
    }
}
