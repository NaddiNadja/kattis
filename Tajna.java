import java.util.Scanner;
import java.lang.Math;
public class Tajna {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(encode(sc.nextLine()));
        sc.close();
    }

    static String encode(String s) {
        int rows = findRows(s);
        int cols = s.length()/rows;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                sb.append(s.charAt(i+j*rows));
            }
        }
        return sb.toString();
    }

    static int findRows(String s) {
        int l = s.length();
        int r = 0;
        for (int i = (int) Math.sqrt(l); i>0; i--) {
            if (l % i == 0) {
                r = i;
                break;
            }
        }
        return r;
    }
}
