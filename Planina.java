import java.util.Scanner;

public class Planina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int pps = 2; //points per side
        for (int i = 0; i<N; i++) pps = 2*pps - 1;
        System.out.println(pps*pps);
    }    
}