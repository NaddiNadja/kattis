import java.util.Scanner;

public class SimonSays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i<n; i++) {
            String s = sc.nextLine();
            if (s.length()>=10) if (s.substring(0,10).equals("Simon says")) System.out.println(s.substring(10));
        }
        sc.close();
    }
}
