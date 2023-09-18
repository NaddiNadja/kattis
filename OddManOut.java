import java.util.HashSet;
import java.util.Scanner;

public class OddManOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<n; i++) {
            HashSet<Integer> in = new HashSet<>();
            int g = sc.nextInt();
            for (int j = 0; j<g; j++) {
                int cur = sc.nextInt();
                if (in.contains(cur)) in.remove(cur);
                else in.add(cur);
            }
            sb.append("Case #");
            sb.append(i+1);
            sb.append(": ");
            sb.append(in.iterator().next());
            if (i!=n-1) sb.append("\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }
}

