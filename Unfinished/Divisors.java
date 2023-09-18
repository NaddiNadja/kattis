package Unfinished;
import java.math.BigInteger;

public class Divisors {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        while (io.hasMoreTokens()) {
            int n = io.getInt();
            int k = io.getInt();
            int divs;
            if (n == 0 || k == 0 || n == k) divs = 1;
            else {
                BigInteger N = new BigInteger(Integer.toString(n));
                BigInteger K = new BigInteger(Integer.toString(k));
                BigInteger fact2 = factorial2(N,N.subtract(K)).divide(factorial2(K, new BigInteger("1")));
                divs = numberOfDivisors2(fact2);
            }
            sb.append(divs+"\n");
        }
        System.out.println(sb);
    }

    private static BigInteger factorial2(BigInteger i, BigInteger j) {
        BigInteger fact = new BigInteger(i.toString());
        i = i.subtract(new BigInteger("1"));
        while (i.compareTo(j) > 0) {
            fact = fact.multiply(i);
            i = i.subtract(new BigInteger("1"));
        }
        return fact;
    }

    private static int numberOfDivisors2(BigInteger x) {
        int sum = 0;
        
        BigInteger i = new BigInteger("1");
        BigInteger ZERO = new BigInteger("0");
        // while (i.compareTo(x.sqrt())<=0) {
        //     if (x.mod(i).equals(ZERO)){
        //         sum++;
        //         if (!i.multiply(i).equals(x)) sum++;
        //     }
        //     i= i.add(new BigInteger("1"));
        // }
        return sum;
    }

    // har brug for bigintegers
    // private static long factorial(int i, int j) {
    //     long fact = i;
    //     i--;
    //     while (i>j) {
    //         fact = fact*i;
    //         i--;
    //     }
    //     return fact;
    // }

    // private static int numberOfDivisors(long x) {
    //     int sum = 0;
    //     for (int i = 1; i<Math.sqrt(x); i++) {
    //         if (x % i == 0) {
    //             sum++;
    //             if (i*i != x) sum++;
    //         }
    //     }
    //     return sum;
    // }
}
