import java.util.Scanner;

public class QALY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double qaly = 0;

        for (int i = 0; i<N; i++) {
            double q = Double.parseDouble(sc.next());
            double y = Double.parseDouble(sc.next());
            qaly += q*y;
        }
        
        sc.close();
        System.out.println(qaly);
    }
}
