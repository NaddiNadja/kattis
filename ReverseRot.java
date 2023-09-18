import java.util.Scanner;
import java.lang.Math;

public class ReverseRot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        while(true){
            int n = sc.nextInt();
            if (n == 0) break;
            String s = reverse(sc.next());

            if (first) first = false;
            else sb.append("\n");

            for (int i = 0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (c == '_') sb.append(rotate(26,n));
                else if (c == '.') sb.append(rotate(27,n));
                else sb.append(rotate(c,n));
            }
        }
        sc.close();
        System.out.println(sb.toString());
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length(); i++) {
            sb.append(s.charAt(Math.abs(i-s.length())-1));
        }
        return sb.toString();
    }

    static char[] alphabet = new char[] {'A','B','C','D','E',
                             'F','G','H','I','J','K','L','M',
                             'N','O','P','Q','R','S','T','U',
                             'V','W','X','Y','Z','_','.'};

    static char rotate(char c, int n) {
        int x = Character.getNumericValue(c) - 10;
        return alphabet[(x+n) % 28];
    }

    static char rotate(int c, int n) {
        return alphabet[(c+n) % 28];
    }


}
