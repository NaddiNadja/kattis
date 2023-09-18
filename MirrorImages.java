import java.util.Scanner;

public class MirrorImages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int a = 1; a<=T; a++) {

            int R = sc.nextInt();
            int C = sc.nextInt();

            char[][] map = new char[R][C];

            for (int b = 0; b<R; b++) {
                String s = sc.next();
                for (int c = 0; c<C; c++) {
                    map[b][c] = s.charAt(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            sb.append("Test "+a);

            for (int b = R-1; b>=0; b--) {
                sb.append("\n");
                for (int c = C-1; c>=0; c--) {
                    sb.append(map[b][c]);
                }
            }

            if (a != T-1) sb.append("\n");
            System.out.println(sb.toString());
        }
        sc.close();
    }    
}
