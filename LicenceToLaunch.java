public class LicenceToLaunch {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int minimum = io.getInt();
        int mindays = 0;
        for (int i = 1; i<n; i++) {
            int x = io.getInt();
            if (minimum > x) {
                minimum = x;
                mindays = i;
            }
        }
        System.out.println(mindays);
    }
}
