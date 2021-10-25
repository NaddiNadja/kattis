import java.util.Arrays;
import java.util.Scanner;

public class Birds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();
        int[] birdpos = new int[n];

        for (int i = 0; i<n; i++) {
            birdpos[i] = sc.nextInt();
        }
        
        sc.close();
        Arrays.sort(birdpos);
        int extrabirds;

        if (l<12) {
            System.out.println(0);
            return;
        }

        if (n==0) extrabirds = (l-12)/d + 1;

        else {
            extrabirds = (birdpos[0]-6)/d + (l-6-birdpos[n-1])/d;

            for (int i = 0; i<n-1; i++) {
                int room = birdpos[i+1]-birdpos[i]; 
                // lad os sige, at i sidder på 6 og i+1 sidder på 12. room = 6, og d = 3. Så kan der være 1 fugl på plads 9.
                extrabirds += room/d -1;
                // 6 / 3 = 2 .... 
            }
        }

        System.out.println(extrabirds);
    }
}
