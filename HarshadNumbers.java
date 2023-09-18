import java.util.Scanner;

public class HarshadNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.close();
        long cursum = digitSum(n);
        boolean found = false;
        while (!found) {
            if (n % cursum == 0) found = true;
            else {
                n++;
                cursum = digitSum(n);
            }
        }
        System.out.println(n);
    }

    private static long digitSum(long i) {
        long sum = 0;
        while(i>0) {
            sum = sum + i%10;
            i = (i - (i%10))/10;
        }
        return sum;
    }
}
