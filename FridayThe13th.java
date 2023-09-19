import java.util.Scanner;

public class FridayThe13th {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i<t; i++) {
            sc.nextInt(); // d
            int m = sc.nextInt();
            int[] days = new int[m];
            boolean[] over13 = new boolean[m];
            for (int j = 0; j<m; j++) {
                days[j] = sc.nextInt();
                if (days[j] >= 13) over13[j] = true;
            }

            int pos = 0;
            int fr13 = 0;

            for (int j = 0; j<m; j++) {
                if (!over13[j]) {
                    pos += days[j];
                } else {
                    pos += 13;
                    if ((pos+1) % 7 ==0) fr13++;
                    pos += days[j]-13;
                }
            }
            System.out.println(fr13);
        }
        sc.close();
    }
}
