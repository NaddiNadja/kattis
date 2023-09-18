import java.util.Scanner;

public class AlienNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<t; i++) {
            String[] input = sc.nextLine().split(" ");

            char[] from = new char[input[1].length()];
            for (int j = 0; j<from.length; j++) from[j] = input[1].charAt(j);
            char[] to = new char[input[2].length()];
            for (int j = 0; j<to.length; j++) to[j] = input[2].charAt(j);
            String res = convert(input[0], from, to);

            sb.append("Case #");
            sb.append(i+1);
            sb.append(": ");
            sb.append(res);
            if (i<t-1) sb.append("\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }

    static String convert(String s, char[] from, char[] to) {
        int pow = 0;
        int base10 = 0;
        for (int i = s.length()-1; i>=0; i--) {
            base10 += (int) getIndex(s.charAt(i), from) * Math.pow(from.length, pow);
            pow++;
        }

        StringBuilder sb = new StringBuilder();
        while (base10 > 0) {
            int y = base10 % to.length;
            base10 = base10 / to.length;
            sb.append(to[y]);
        }

        return reverse(sb.toString());
    }

    static int getIndex(char c, char[] arr) {
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == c) return i;
        }
        return -1;
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i>-1; i--) sb.append(s.charAt(i));
        return sb.toString();
    }
}
