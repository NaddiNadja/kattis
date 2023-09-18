import java.util.ArrayList;
import java.util.Scanner;

public class ImThinkingOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;
            int low = 1;
            int high = -1;
            ArrayList<Integer> divisors = new ArrayList<>();
            
            for (int i = 0; i<n; i++) {
                String[] input = sc.nextLine().split(" ");
                if (input[0].equals("less")) {
                    if (Integer.parseInt(input[2]) - 1 < high || high == -1)
                        high = Integer.parseInt(input[2]) - 1;
                } else if (input[0].equals("greater")) {
                    if (Integer.parseInt(input[2]) + 1 > low)
                        low = Integer.parseInt(input[2]) + 1;
                } else {
                    divisors.add(Integer.parseInt(input[2]));
                }
            }

            if (high < 0) System.out.println("infinite");
            else {
                StringBuilder sb = new StringBuilder();
                boolean first = true;
                for (int i = low; i<=high; i++) {
                    boolean print = true;
                    for (Integer div : divisors) {
                        if (i % div != 0) print = false;
                    }
                    if (print) {
                        if (first) first = false;
                        else sb.append(" ");
                        sb.append(i);
                    }
                }
                if (sb.length() == 0) System.out.println("none");
                else System.out.println(sb.toString());
            }
        }
        sc.close();
    }
}