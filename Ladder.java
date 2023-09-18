import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int v = sc.nextInt();
        sc.close();

        double result = h/sin(v);
        int res = (int) result;

        if (result > res) System.out.println(res+1);
        else System.out.println(res);
    }

    static double sin(int v) {
        return Math.sin(v/(180/Math.PI));
    }
}
