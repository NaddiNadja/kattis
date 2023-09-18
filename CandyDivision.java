import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Math;

public class CandyDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        sc.close();
        ArrayList<Long> divisors = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (long i = 1; i<=Math.sqrt(N); i++) {
            if (N % i == 0) {
                long a = i-1;
                long b = N/i - 1;
                divisors.add(a);
                if (N/i != i) divisors.add(b);
            }
        }

        Collections.sort(divisors);
        Iterator<Long> it = divisors.iterator();

        for (int i = 0; i<divisors.size(); i++) {
            sb.append(it.next());
            if (i != divisors.size()-1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}