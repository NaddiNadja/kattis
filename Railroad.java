public class Railroad {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        io.getInt();
        int y = io.getInt();
        System.out.println(y % 2 == 0? "possible" : "impossible");
    }
}
