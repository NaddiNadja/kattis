import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StackingCups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        ArrayList<Cup> cups = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            String s = sc.nextLine();
            String[] inp = s.split(" ");
            if (!Character.isDigit(s.charAt(0))) {
                cups.add(new Cup(inp[0], Double.parseDouble(inp[1])));
            } else {
                cups.add(new Cup(inp[1], Double.parseDouble(inp[0])/2));
            }
        }

        sc.close();

        Collections.sort(cups);
        for (Cup cup : cups) {
            System.out.println(cup.getColour());
        }
    }
}