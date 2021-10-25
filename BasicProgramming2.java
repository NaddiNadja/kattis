import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BasicProgramming2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] a = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i<n; i++) {
            a[i] = sc.nextInt();
            set.add(a[i]);
        }
        sc.close();

        boolean found = false;

        switch(t) {
            case 1 :
                Arrays.sort(a);
                int[] pos = new int[7778];
                boolean[] exi = new boolean[7778];
                for (int i = 0; i<n; i++) {
                    if (a[i] > 7777) break;
                    pos[a[i]] = i;
                    exi[a[i]] = true;
                }
                for (int i = 0; i<n; i++) {
                    if (a[i] > 7777) break;
                    int dif = 7777-a[i];
                    if (pos[dif] != i && exi[dif]) found = true;
                }
                if (found) System.out.println("Yes");
                else System.out.println("No");
                break;
            case 2 : 
                if (a.length==set.size()) System.out.println("Unique");
                else System.out.println("Contains duplicate");
                break;
            case 3 :
                Arrays.sort(a);
                for (int i = 0; i<n/2; i++) {
                    if (a[i] == a[i+n/2]) {
                        System.out.println(a[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println(-1);
                break;
            case 4 :
                Arrays.sort(a);
                if (n % 2 == 0) {
                    System.out.println(a[n/2-1] + " " + a[n/2]);
                } else {
                    System.out.println(a[n/2]);
                }
                break;
            case 5 :
                StringBuilder sb = new StringBuilder();
                Arrays.sort(a);
                boolean print = false;
                for (int i = 0; i<n; i++) {
                    if (a[i]>99) print = true;
                    if (a[i]>999) print = false;
                    if (print) sb.append(a[i] + " ");
                }
                sb.delete(sb.length()-1,sb.length());
                System.out.println(sb);
                break;
        }
    }
}
