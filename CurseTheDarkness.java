import java.lang.Math;

public class CurseTheDarkness {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int m = io.getInt();
        for (int i = 0; i<m; i++) {
            double x = Double.parseDouble(io.getWord());
            double y = Double.parseDouble(io.getWord());
            int n = io.getInt();
            boolean light = false;
            for (int j = 0; j<n; j++) {
                double x1 = Double.parseDouble(io.getWord());
                double y1 = Double.parseDouble(io.getWord());
                if (Math.sqrt(Math.pow(Math.abs(x-x1),2) + Math.pow(Math.abs(y-y1),2)) <= 8) light = true;
            }
            sb.append(light? "light a candle\n" : "curse the darkness\n");
        }
        System.out.println(sb);
    }
}
