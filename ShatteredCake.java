public class ShatteredCake {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int w = io.getInt();
        int n = io.getInt();
        int area = 0;
        for (int i = 0; i<n; i++) {
            area += (io.getInt() * io.getInt());
        }
        System.out.println(area/w);
    }
}
