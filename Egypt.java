import java.util.Scanner;

public class Egypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            if (a==0 && b==0 && c==0) break;
            
            if (!first) sb.append("\n");
            else first = false;

            if (Math.pow(a,2)+Math.pow(b,2) == Math.pow(c, 2) || Math.pow(b,2)+Math.pow(c,2) == Math.pow(a, 2) || Math.pow(c,2)+Math.pow(a,2) == Math.pow(b, 2)) {
                sb.append("right");
            } else sb.append("wrong");
        }
        sc.close();
        System.out.println(sb.toString());
    }
}
