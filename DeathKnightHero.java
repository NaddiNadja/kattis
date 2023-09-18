import java.util.Scanner;

public class DeathKnightHero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int wins = 0;
        for (int i = 0; i<n; i++) {
            String s = sc.next();
            boolean win = true;
            for (int j = 0; j<s.length()-1; j++) {
                if (s.charAt(j) == 'C' && s.charAt(j+1) == 'D') {
                    win = false;
                    break;
                }
            }
            if (win) wins++;
        }
        System.out.println(wins);
        sc.close();
    }
}
