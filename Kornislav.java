import java.util.Arrays;
import java.util.Scanner;

public class Kornislav {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] in = new int[4];
        for (int i = 0; i<4; i++) in[i] = sc.nextInt();
        sc.close();
        Arrays.sort(in);
        System.out.println(in[0]*in[2]);
    }
}
