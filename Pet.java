public class Pet {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int winner = 0;
        int points = 0;
        for (int i = 1; i<=5; i++) {
            int sum = io.getInt() + io.getInt() + io.getInt() + io.getInt();
            if (sum > points) {
                points = sum;
                winner = i;
            }
        }
        System.out.println(winner + " " + points);
    }
}
