import java.util.Scanner;

public class GrassSeedInc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double C = Double.parseDouble(sc.next()); //cost of seed to sow one square metre of lawn
        int L = sc.nextInt(); //number of lawns to sow
        double total = 0;

        for (int i = 0; i<L; i++) {
            double w = Double.parseDouble(sc.next());
            double l = Double.parseDouble(sc.next());
            total += w*l*C;
        }
        sc.close();
        System.out.println(total);
    }
}