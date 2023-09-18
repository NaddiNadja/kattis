import java.util.Scanner;

public class Howl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()-2) {
            sb.append("AW");
        }
        sb.append("HOO");
        System.out.println(sb.toString());
    }
}