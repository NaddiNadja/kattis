import java.util.Scanner;

public class AlphabetSpam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        double total = s.length();
        double ws = 0;
        double lc = 0;
        double uc = 0;
        double sy = 0;


        for (int i = 0; i<total; i++) {
            if (s.charAt(i) == '_') ws++;
            else if (Character.isLowerCase(s.charAt(i))) lc++;
            else if (Character.isUpperCase(s.charAt(i))) uc++;
            else sy++;
        }

        System.out.println(ws/total);
        System.out.println(lc/total);
        System.out.println(uc/total);
        System.out.println(sy/total);
    }
}
