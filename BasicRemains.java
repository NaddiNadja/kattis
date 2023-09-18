import java.math.BigInteger;

public class BasicRemains {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        while (io.hasMoreTokens()) {
            int base = io.getInt();
            if (base == 0) break;

            BigInteger p = new BigInteger(io.getWord(),base);
            BigInteger m = new BigInteger(io.getWord(),base);
            sb.append(p.mod(m).toString(base));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
