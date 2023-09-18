import java.util.Scanner;

public class Anewalphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<s.length(); i++) {
            sb.append(dict.get(s.charAt(i)));
        }
        System.out.println(sb.toString());
    }


    static class dict {
        static String[][] sa = {
            {"a", "A", "@"},
            {"b", "B", "8"},
            {"c", "C", "("},
            {"d", "D", "|)"},
            {"e", "E", "3"},
            {"f", "F", "#"},
            {"g", "G", "6"},
            {"h", "H", "[-]"},
            {"i", "I", "|"},
            {"j", "J", "_|"},
            {"k", "K", "|<"},
            {"l", "L", "1"},
            {"m", "M", "[]\\/[]"},
            {"n", "N", "[]\\[]"},
            {"o", "O", "0"},
            {"p", "P", "|D"},
            {"q", "Q", "(,)"},
            {"r", "R", "|Z"},
            {"s", "S", "$"},
            {"t", "T", "']['"},
            {"u", "U", "|_|"},
            {"v", "V", "\\/"},
            {"w", "W", "\\/\\/"},
            {"x", "X", "}{"},
            {"y", "Y", "`/"},
            {"z", "Z", "2"}
        };

        static String get(char c) {
            String s = Character.toString(c);
            for (int i = 0; i<sa.length; i++) {
                if (sa[i][0].equals(s) || sa[i][1].equals(s)) return sa[i][2];
            }
            return s;
        }
    }
}
