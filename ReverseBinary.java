import java.util.Scanner;

public class ReverseBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(Integer.parseInt(reverse(Integer.toBinaryString(n)), 2));
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
