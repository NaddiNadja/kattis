public class ArmyStrength {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int t = io.getInt();
        for (int i = 0; i<t; i++) {
            int ng = io.getInt();
            int nm = io.getInt();
            int maxg = 0;
            int maxm = 0;
            for (int j = 0; j<ng; j++) {
                int x = io.getInt();
                if (maxg < x) maxg = x;
            }
            for (int j = 0; j<nm; j++) {
                int x = io.getInt();
                if (maxm < x) maxm = x;
            }

            if (maxm > maxg) sb.append("MechaGodzilla\n");
            else sb.append("Godzilla\n");
        }
        System.out.println(sb);
    }
}
