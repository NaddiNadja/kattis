import java.util.Scanner;

public class HelpAPhDCandidateOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<n; i++) {
            String[] in = sc.nextLine().split("\\+");
            if (in[0].charAt(0) == 'P') {
                System.out.println("skipped");
                continue;
            } 
            
            System.out.println(Integer.parseInt(in[0]) + Integer.parseInt(in[1]));
        }
        sc.close();
    }
}
