import java.util.Scanner;

public class TheAmazingHumanCannonball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i<n; i++) {
            double v = Double.parseDouble(sc.next());
            double o = Double.parseDouble(sc.next());
            double x = Double.parseDouble(sc.next());
            double h1 = Double.parseDouble(sc.next());
            double h2 = Double.parseDouble(sc.next());
            double g = 9.81;
            double t = x / (v*Math.cos(o/(180/Math.PI)));

            double y = v*t*Math.sin(o/(180/Math.PI)) - 0.5*g*Math.pow(t,2);
            if (h1+1 < y && y < h2-1) System.out.println("Safe");
            else System.out.println("Not Safe");
        }
        sc.close();
    }
}