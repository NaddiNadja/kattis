import java.util.Scanner;

public class Kemija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (c == 'a' || c == 'e' ||c == 'i' || c == 'o' || c == 'u') i+=2;
        }
        sc.close();
        System.out.println(sb);
    }
}
