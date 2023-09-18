import java.util.Scanner;

public class Print3d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        double m = Math.ceil(log2(N));
        int l = (int) (m + 1);
        System.out.println(l);
    }

    public static double log2(int N) { 
        double result = Math.log(N) / Math.log(2); 
        return result; 
    } 
}
