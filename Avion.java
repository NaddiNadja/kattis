import java.util.Scanner;

public class Avion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean gotaway = true;
        boolean firstfound = false;
        for (int i = 0; i<5; i++) {
            String s = sc.nextLine();
            if (s.contains("FBI")) {
                if (firstfound) sb.append(" ");
                else firstfound = true;
                gotaway = false;
                sb.append(i+1);
            }
        }
        sc.close();
        if (gotaway) System.out.println("HE GOT AWAY!");
        else System.out.println(sb.toString());
    }
}
