import java.lang.Math;

public class Mia {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        while (io.hasMoreTokens()) {
            int s0 = io.getInt();
            int s1 = io.getInt();
            int r0 = io.getInt();
            int r1 = io.getInt();
            if (s0+s1+r0+r1 == 0) break;
            int x = winningPlayer(s0,s1,r0,r1);
            if (x == 1) sb.append("Player 1 wins.\n");
            else if (x == 2) sb.append("Player 2 wins.\n");
            else sb.append("Tie.\n");
        }
        System.out.println(sb);
    }

    private static int winningPlayer(int s0, int s1, int r0, int r1) {
        int max1 = Math.max(s0,s1);
        int min1 = Math.min(s0,s1);
        int max2 = Math.max(r0,r1);
        int min2 = Math.min(r0,r1);
        
        int tier1 = tier(max1,min1);
        int tier2 = tier(max2,min2);

        if (tier1<tier2) return 1;
        else if (tier1>tier2) return 2;
        else {
            if (max1*10+min1 > max2*10+min2) return 1;
            else if (max1*10+min1 < max2*10+min2) return 2;
            else return 0;
        }
    }

    private static int tier(int max, int min) {
        if (min == 1 && max == 2) return 0;
        else if (min == max) return 1;
        else return 2;
    }
}
