import java.util.Scanner;

public class InvertedDeck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] in = new int[n];
        for (int i = 0; i<n; i++) in[i] = sc.nextInt();
        sc.close();

        boolean possible = true;

        int begin = -1;
        boolean beginfound = false;
        int end = -1;
        boolean endfound = false;

        int pos = 0;

        while(!beginfound) {
            if (in[pos]>in[pos+1]) {
                begin = pos;
                for (int i = pos; i>=0; i--) {
                    if (in[i] == in[i-1]) begin = i;
                    else break;
                }
                beginfound = true;
            }
            pos++;
        }
        while(!endfound) {
            if (in[pos]<in[pos+1]) {
                end = pos;
                endfound = true;
            }
            pos++;
        }
        while (pos<in.length-1) {
            if (in[pos]>in[pos+1]) possible = false;
            pos++;
        }

        if (possible) System.out.println((begin+1) + " " + (end+1));
        else System.out.println("impossible");
    }
}
