import java.util.ArrayList;
import java.util.Scanner;

public class ChartingProgress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while (sc.hasNext()) {
            if (first) first = false;
            else sb.append("\n");
            ArrayList<String> input = new ArrayList<>();
            int width = 0;
            while (sc.hasNext()) {
                String s = sc.nextLine();
                if (s.length() == 0) break;
                width = s.length();
                input.add(s);
            }
            for (String string : input) {
                sb.append(transform(string, width));
                sb.append("\n");
                width-=stars(string);
            }
        }

        System.out.println(sb.toString());
        sc.close();
    }

    static int stars(String s) {
        int count = 0;
        for (int i = 0; i<s.length(); i++) if (s.charAt(i) == '*') count++;
        return count;
    }

    static String transform(String s, int start) {
        StringBuilder sb = new StringBuilder();
        int strs = stars(s);

        if (strs == 0) return s;

        for (int i = 0; i<start-strs; i++) sb.append(".");
        for (int i = 0; i<strs; i++) sb.append("*");
        for (int i = start; i<s.length(); i++) sb.append(".");

        return sb.toString();
    }
}