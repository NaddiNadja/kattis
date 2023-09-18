import java.math.BigInteger;
import java.util.Scanner;

public class IHateTheNumberNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i<t; i++) {
            System.out.println((8*pow9(sc.nextLong()-1)) % 1000000007);
        }
        sc.close();
    }

    static long pow9(long x) {
        BigInteger z = new BigInteger("9");
        BigInteger pow = new BigInteger("1000000007");
        BigInteger exp = new BigInteger(Long.toString(x));
        BigInteger y = z.modPow(exp, pow);
        return Long.parseLong(y.toString());
    }
}
