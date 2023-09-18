public class BreakingBranches {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int N = io.getInt();
        if (N % 2 == 0) System.out.println("Alice\n1");
        else System.out.println("Bob");
    }
}