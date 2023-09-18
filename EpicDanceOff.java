import java.util.Scanner;

public class EpicDanceOff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        String[] in = new String[n];

        for (int i = 0; i<n; i++) in[i] = sc.nextLine();
        sc.close();
        
        int sum = 1;
        
        for (int i = 0; i<m; i++) {
            boolean move = true;
            for (int j = 0; j<n; j++) if (in[j].charAt(i) != '_') move = false;
            if (move) sum++;
        }

        System.out.println(sum);

    }
}