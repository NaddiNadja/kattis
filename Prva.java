import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Prva {

    static int R;
    static int C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        String[] in = new String[R];

        for (int i = 0; i<R; i++) {
            in[i] = sc.nextLine();
        }

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i<R; i++) {
            for (int j = 0; j<C; j++) {
                if (in[i].charAt(j) == '#') continue;
            
                if (i == 0 || i-1>=0 && in[i-1].charAt(j) == '#') {
                    String s = findVerticalWord(in, i, j);
                    if (s.length() > 1) words.add(s);
                }

                if (j == 0 || j-1>=0 && in[i].charAt(j-1) == '#') {
                    String s = findHorisontalWord(in, i, j);
                    if (s.length() > 1) words.add(s);
                }
            }
        }

        Collections.sort(words);
        for (String x : words) {
            System.out.println(x);
            break;
        }
        sc.close();
    }

    static String findVerticalWord(String[] in, int r, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<20; i++) {
            if (r+i == R) break;
            if (in[r+i].charAt(c) == '#') break;
            sb.append(in[r+i].charAt(c));
        }
        return sb.toString();
    }

    static String findHorisontalWord(String[] in, int r, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<20; i++) {
            if (c+i == C) break;
            if (in[r].charAt(c+i) == '#') break;
            sb.append(in[r].charAt(c+i));
        }
        return sb.toString();
    }
}
 /*
 
 2 4
 asd#
 ks#f

 */