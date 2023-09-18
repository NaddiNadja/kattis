import java.util.Scanner;

public class ColdputerScience {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;

        for (int i = 0; i<n; i++) 
            if (sc.nextInt() < 0) 
                total++;
        
        sc.close();
        System.out.println(total);
    }
}
