import java.util.Arrays;
import java.util.Scanner;

public class BasicProgramming1 {

    static char[] letters = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++) a[i] = sc.nextInt();
        sc.close();

        switch(t) {
            case 1 : 
                System.out.println(7);
                break;
            case 2 : 
                if (a[0]>a[1]) System.out.println("Bigger");
                else if (a[0] == a[1]) System.out.println("Equal");
                else System.out.println("Smaller");
                break;
            case 3 :
                int[] arr = new int[] {a[0], a[1], a[2]};
                Arrays.sort(arr);
                System.out.println(arr[1]);
                break;
            case 4 :
                long sum1 = 0;
                for (int i = 0; i<n; i++) sum1 += a[i];
                System.out.println(sum1);
                break;
            case 5 :
                long sum2 = 0;
                for (int i = 0; i<n; i++) if (a[i] % 2 == 0) sum2 += a[i];
                System.out.println(sum2);
                break;
            case 6 :
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i<n; i++) sb.append(letters[a[i] % 26]);
                System.out.println(sb.toString());
                break;
            case 7 :
                int k = 0;
                boolean[] visited = new boolean[n];
                while (true) {
                    if (k>n-1) {
                        System.out.println("Out");
                        break;
                    } else if (k == n-1) {
                        System.out.println("Done");
                        break;
                    } else {
                        if (visited[k]) {
                            System.out.println("Cyclic");
                            break;
                        }
                        visited[k] = true;
                        k = a[k];
                    }
                }    
                break;
        }
    }
}
