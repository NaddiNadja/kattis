import java.util.Scanner;

public class Tornbygge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int towers = 1;
        int cur = sc.nextInt();

        for (int i = 0; i<N-1; i++) {
            int next = sc.nextInt();
            if (next>cur) towers++;
            cur = next;
        }
        
        sc.close();
        System.out.println(towers);
    }
}

/* 
Sample inputs:

10
4 3 3 2 1 2 2 1 1 3

5
2 2 2 2 2
*/