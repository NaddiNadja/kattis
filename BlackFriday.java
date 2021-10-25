import java.util.Arrays;
import java.util.Scanner;

public class BlackFriday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] list = new Pair[n];
        for (int i = 0; i<n; i++) {
            list[i] = new Pair(i+1, sc.nextInt());
        }
        sc.close();
        Arrays.sort(list);
        int i = 0;
        boolean found = false;
        while (!found) {
            if (n == 1) {
                System.out.println(list[i].linenumber);
                found = true;
            } else if (i == 0) { 
                if (list[i].dicethrow != list[i+1].dicethrow) {
                    System.out.println(list[i].linenumber);
                    found = true;
                }
            } else if (i == n-1) { 
                if (list[i].dicethrow != list[i-1].dicethrow) {
                    System.out.println(list[i].linenumber);
                    found = true; 
                }
            } else if (list[i].dicethrow != list[i-1].dicethrow && list[i].dicethrow != list[i+1].dicethrow) {
                System.out.println(list[i].linenumber);
                found = true;
            }  
            i++;
            if (i == n) break;
        }

        if (!found) System.out.println("none");
        
    }
    static class Pair implements Comparable<Pair> {
        int linenumber;
        int dicethrow;

        public Pair(int linenumber, int dicethrow) {
            this.linenumber = linenumber;
            this.dicethrow = dicethrow;
        }

        public int compareTo(Pair that) {
            return that.dicethrow-this.dicethrow;
        }
    }
}
