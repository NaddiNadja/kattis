import java.util.Scanner;
import java.lang.Math;

public class SoftPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        sc.close();

        boolean accept = false;
        if (Math.abs(s.length()-p.length())<2) {
            if (s.equals(p)) accept = true;
            else if (reverse(s).equals(p)) accept = true;
            else if (s.substring(0,s.length()-1).equals(p) && Character.isDigit(s.charAt(s.length()-1))) accept = true;
            else if (s.substring(1,s.length()).equals(p) && Character.isDigit(s.charAt(0))) accept = true;
        }

        if (accept) System.out.println("Yes");
        else System.out.println("No");
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else sb.append(c);
        }
        return sb.toString();
    }
}