public class MoscowDream {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int a = io.getInt();
        int b = io.getInt();
        int c = io.getInt();
        int n = io.getInt();
        System.out.println((n>=3 && n<=a+b+c && a!=0 && b!=0 && c!=0)? "YES" : "NO");
    }
}
