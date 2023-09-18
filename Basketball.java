import java.util.Scanner;

public class Basketball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        sc.close();

        int a = 0;
        int b = 0;

        for (int i = 0; i<in.length(); i+=2) {
            if (in.charAt(i) == 'A') {
                a += Character.getNumericValue(in.charAt(i+1));
            } else {
                b += Character.getNumericValue(in.charAt(i+1));
            }
        }

        if (a>b) System.out.println("A");
        else System.out.println("B");
    }
}
