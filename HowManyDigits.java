import java.util.Scanner;
import java.lang.Math;

public class HowManyDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int inp = sc.nextInt();
            System.out.println(findDigits(inp));
        }
        sc.close();
    }

    static long findDigits(int n) { 
        if (n < 0) return 0;
        if (n <= 1) return 1; 
        
        // Use Kamenetsky formula to calculate the number of digits 
        double x = ((n * Math.log10(n / Math.E) + Math.log10(2 * Math.PI * n) / 2.0)); 
        return (long) (Math.floor(x) + 1); 
    }
}
