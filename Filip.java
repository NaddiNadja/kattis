import java.util.Scanner;

public class Filip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        sc.close();

        int a = Integer.parseInt(reverse(A));
        int b = Integer.parseInt(reverse(B));

        if (a>b) System.out.println(a);
        else System.out.println(b);
        
    }

    static String reverse(String s) {
        String temp = "";
        for (int i = 2; i>=0; i--) {
            temp = temp + s.charAt(i);
        }
        return temp;
    }
}
