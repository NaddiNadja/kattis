import java.util.Arrays;
import java.util.Scanner;

public class PokerHand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        sc.close();
        int[] amount = new int[14];
        
        for (int i = 0; i<5; i++) {
            char c = in.charAt(3*i);
            int rank;
            if (c == 'A') rank = 1;
            else if (c == 'T') rank = 10;
            else if (c == 'J') rank = 11;
            else if (c == 'Q') rank = 12;
            else if (c == 'K') rank = 13;
            else rank = Character.getNumericValue(c);
            amount[rank]++;
        }
        Arrays.sort(amount);
        System.out.println(amount[13]);
    }
}
