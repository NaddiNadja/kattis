import java.util.Scanner;
import java.lang.Math;

public class ADifferentProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while (sc.hasNext()) {
            if (!first) sb.append("\n");
            else first = false;
            sb.append(Math.abs(sc.nextLong() - sc.nextLong()));
        }
        sc.close();
        System.out.println(sb.toString());
    }
}
