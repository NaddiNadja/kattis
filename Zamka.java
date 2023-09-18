import java.util.Scanner;

public class Zamka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int D = sc.nextInt();
        int X = sc.nextInt();
        sc.close();

        int N = 0;
        int M = 0;

        for (int i = L; i<=D; i++) {
            if(tværsum(i) == X) {
                N = i;
                break;
            }
        }
        for (int i = D; i>=L; i--) {
            if(tværsum(i) == X) {
                M = i;
                break;
            }
        }

        System.out.println(N);
        System.out.println(M);
    }

    static int tværsum(int i) {
        int sum = 0;
        while(i>0) {
            sum = sum + i%10;
            i = (i - (i%10))/10;
        }
        return sum;
    }
}
    