import java.util.Scanner;

public class Tripletexting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        int i = s.length() / 3;

        String s1 = s.substring(0, i);
        String s2 = s.substring(i, 2*i);
        String s3 = s.substring(2*i);

        if (s1.equals(s2) || s1.equals(s3)) System.out.println(s1);
        else System.out.println(s2);
    }
}
