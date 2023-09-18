import java.util.Arrays;
import java.util.Scanner;

public class Cetiri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] in = new int[] {sc.nextInt(),sc.nextInt(),sc.nextInt()};
        sc.close();
        Arrays.sort(in);
        int dif1 = Math.abs(in[1]-in[0]);
        int dif2 = Math.abs(in[2]-in[1]);

        if (dif1 == dif2) {
            System.out.println(dif1+in[2]);
        } else if (dif1 == 2*dif2) {
            System.out.println(in[0]+dif2);
        } else if (dif2 == 2*dif1) {
            System.out.println(in[1]+dif1);
        }
    }
}
