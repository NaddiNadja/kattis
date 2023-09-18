import java.util.Scanner;
import java.math.BigInteger;

public class CheckingForCorrectness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        long result = 0; 

        // for (int i = 0; i<1; i++) {
        while (sc.hasNext()) {
            long a = sc.nextLong();
            char c = sc.next().charAt(0);
            long b = sc.nextLong();

            BigInteger A = new BigInteger(Long.toString(a));
            BigInteger B = new BigInteger(Long.toString(b));
            BigInteger mod = new BigInteger("10000");

            if (c == '+') {
                BigInteger add = A.add(B);
                add = add.mod(mod);
                result = Long.parseLong(add.toString());
            }
            else if (c == '*') {
                BigInteger mult = A.multiply(B);
                mult = mult.mod(mod);
                result = Long.parseLong(mult.toString());
            }
            else {
                BigInteger pow = A.modPow(B, mod);
                result = Long.parseLong(pow.toString());
            }
            
            sb.append(result); 
            sb.append("\n");
        }

        sc.close();
        System.out.println(sb.toString());
    }
}
