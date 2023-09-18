public class Parking {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int t = io.getInt();
        for (int i = 0; i<t; i++) {
            int n = io.getInt();
            int max = 0;
            int min = 100;
            for (int j = 0; j<n; j++) {
                int x = io.getInt();
                if (max < x) max = x;
                if (min > x) min = x;
            }
            sb.append((max-min)*2);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
