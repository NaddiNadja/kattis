import java.util.Scanner;

public class HonourThyParent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String y = sc.next();
        String p = sc.next();
        sc.close();

        if (y.charAt(y.length()-1) == 'e') System.out.println(y + "x" + p);
        else if (isVowel(y.charAt(y.length()-1))) System.out.println(y.substring(0, y.length()-1) + "ex" + p);
        else if (y.substring(y.length()-2, y.length()).equals("ex")) System.out.println(y+p);
        else System.out.println(y+"ex"+p);
    }

    static boolean isVowel(char c) {
        switch (c) {
            case 'a' : return true;
            case 'e' : return true;
            case 'i' : return true;
            case 'o' : return true;
            case 'u' : return true;
            default : return false;
        }
             
    }
}
