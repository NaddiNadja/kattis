import java.util.Scanner;

public class KInversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int slength = s.length();
        int[] bpos = new int[slength];
        int bnum = 0;

        int[] invs = new int[slength-1];

        for (int i = 0; i<slength; i++) {
            if (s.charAt(i) == 'A') {
                for (int j = 0; j<bnum; j++) {
                    invs[i-bpos[j]-1]++;
                }
            } else {
                bpos[bnum] = i;
                bnum++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<invs.length; i++) {
            sb.append(invs[i]);
            sb.append("\n");
        }

        System.out.print(sb);
        sc.close();
    }
}
