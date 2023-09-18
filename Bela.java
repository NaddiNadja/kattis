import java.util.Scanner;

public class Bela {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char B = sc.nextLine().charAt(1);
        int sum = 0;

        for (int i = 0; i<4*n; i++) {
            String in = sc.nextLine();
            if (in.charAt(1) == B) sum += getPoints(in.charAt(0), true);
            else sum += getPoints(in.charAt(0), false);
        }
        sc.close();
        System.out.println(sum);
    }

    public static int getPoints(char c, boolean dom) {
        char[] numb = new char[] {'A', 'K', 'Q', 'J', 'T', '9', '8', '7'};
        int[] valdom = new int[] {11, 4, 3, 20, 10, 14, 0, 0};
        int[] valndom = new int[] {11, 4, 3, 2, 10, 0, 0, 0};
        if (dom) {
            for (int i = 0; i<8; i++) {
                if (c == numb[i]) return valdom[i];
            }
        } else {
            for (int i = 0; i<8; i++) {
                if (c == numb[i]) return valndom[i];
            }
        }
        return 0;
    }
}
