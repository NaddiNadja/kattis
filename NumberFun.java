public class NumberFun {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int n = io.getInt();
        for (int i = 0; i<n; i++) {
            double a = (double) io.getInt();
            int b = io.getInt();
            int c = io.getInt();
            if (a+b==c || a-b==c || b-a==c || a*b==c || a/b==c || b/a==c) 
                sb.append("Possible\n");
            else sb.append("Impossible\n");
        }
        System.out.print(sb);
    }
}