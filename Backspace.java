import java.util.Scanner;

public class Backspace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sc.close();

        for (int i = 0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (c == '<') sb.deleteCharAt(sb.length()-1);
            else sb.append(c);
        }

        System.out.print(sb);
    }
}