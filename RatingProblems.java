public class RatingProblems {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();

        int n = io.getInt();
        int k = io.getInt();

        double minimum = (n-k)*-3;
        double maximum = (n-k)*3;

        for (int i = 0; i<k; i++) {
            int r = io.getInt();
            minimum += r;
            maximum += r;
        }

        sb.append(minimum/n).append(" ").append(maximum/n);
        System.out.println(sb);
        io.close();
    }
}
