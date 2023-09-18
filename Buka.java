import java.math.BigInteger;

public class Buka {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        BigInteger a = new BigInteger(io.getWord());
        char op = io.getWord().charAt(0);
        BigInteger b = new BigInteger(io.getWord());
        System.out.println((op == '+')? a.add(b) : a.multiply(b));
    }
}
