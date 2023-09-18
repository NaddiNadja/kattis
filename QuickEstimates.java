public class QuickEstimates {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int n = io.getInt();
        for (int i = 0; i<n; i++) {
            sb.append(io.getWord().length());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
