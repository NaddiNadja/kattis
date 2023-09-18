import java.util.Scanner;

public class MissingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];

        for (int i= 0; i<n; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        int curpos = 0;
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        boolean error = false;

        for (int i = 1; i<=input[n-1]; i++) {
            if (i == input[curpos]) {
                curpos++;
                continue;
            }
            error = true;
            if (first != true) {
                sb.append("\n");
            }
            sb.append(i);
            first = false;
        }

        if (error == true) System.out.println(sb.toString());
        else System.out.println("good job");
    }
}
