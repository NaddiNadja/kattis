import java.lang.Math;

public class AlmostPerfect {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        while (io.hasMoreTokens()) {
            int x = io.getInt();

            int sum = 1;
            for (int i = 2; i<=Math.sqrt(x); i++) {
                if (x % i == 0) {
                    sum += i;
                    if (i*i != x) sum += x/i;
                }
            }

            if (sum == x) sb.append(x + " perfect\n");
            else if (Math.abs(sum-x) < 3) sb.append(x + " almost perfect\n");
            else sb.append(x + " not perfect\n");
        }
        System.out.println(sb);
    }
}
