import java.lang.Math;

public class Sibice {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int w = io.getInt();
        int h = io.getInt();
        double diagonal = Math.sqrt(w*w + h*h);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            int match = io.getInt();
            sb.append(match <= diagonal? "DA\n" : "NE\n");
        }
        System.out.println(sb);
        io.close();
    }
}