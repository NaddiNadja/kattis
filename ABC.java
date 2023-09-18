import java.util.Arrays;
import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[3];
        input[0] = sc.nextInt();
        input[1] = sc.nextInt();
        input[2] = sc.nextInt();
        Arrays.sort(input);
        sc.nextLine();
        String s = sc.nextLine();
        sc.close();

        for (int i = 0; i<3; i++) {
            if (i != 0) System.out.print(" ");
            if (s.charAt(i) == 'A') System.out.print(input[0]);
            else if (s.charAt(i) == 'B') System.out.print(input[1]);
            else System.out.print(input[2]);
        }
        System.out.println();
    }
}
