import java.util.Scanner;

public class Trik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        boolean[] pos = new boolean[] {true, false, false};

        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'A') pos = swapA(pos);
            else if (c == 'B') pos = swapB(pos);
            else pos = swapC(pos);

        }

        if (pos[0]) System.out.println(1);
        else if (pos[1]) System.out.println(2);
        else System.out.println(3);
    }

    static boolean[] swapA(boolean[] a) {
        boolean temp = a[0];
        a[0] = a[1];
        a[1] = temp;
        return a;
    }

    static boolean[] swapB(boolean[] a) {
        boolean temp = a[1];
        a[1] = a[2];
        a[2] = temp;
        return a; 
    }

    static boolean[] swapC(boolean[] a) {
        boolean temp = a[0];
        a[0] = a[2];
        a[2] = temp;
        return a;
    }
}
