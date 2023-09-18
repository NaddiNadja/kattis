public class Architecture {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int r = io.getInt();
        int c = io.getInt();
        int maxr = 0;
        for (int i = 0; i<r; i++) {
            int x = io.getInt();
            if (x>maxr) maxr = x;
        }
        int maxc = 0;
        for (int i = 0; i<c; i++) {
            int x = io.getInt();
            if (x>maxc) maxc = x;
        }
        System.out.println((maxc==maxr)? "possible": "impossible");
    }
}
