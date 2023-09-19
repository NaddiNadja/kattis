import java.util.Scanner;

public class ToiletSeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int a = 0;
        int b = 0;
        int c = 0;
        boolean up = false;
    
        if (s.charAt(0) == 'U') up = true;

        for (int i = 1; i<s.length(); i++) {
            if (s.charAt(i) == 'U' && !up) a++;
            if (s.charAt(i) == 'D' && up) a+=2;
            if (s.charAt(i) != s.charAt(i-1)) c++;
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
    }
}
