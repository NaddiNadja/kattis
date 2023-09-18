import java.lang.Math;

public class EncodedMessage {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            sb.append(decode(io.getWord()));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static String decode(String s) {
        int size = (int) Math.sqrt(s.length());
        StringBuilder sb = new StringBuilder();
        for (int i = size-1; i>=0; i--) {
            for (int j = i; j<s.length(); j+=size) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}
