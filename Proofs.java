import java.util.HashSet;
import java.util.Scanner;

public class Proofs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        HashSet<String> conc = new HashSet<>();

        for (int i = 0; i<n; i++) {
            String input = sc.nextLine();
            String[] inp;
            if (input.charAt(0) != '-') inp = input.split(" -> ");
            else inp = input.split("-> ");

            if (inp[0].equals("")) {
                conc.add(inp[1]);
                continue;
            }
            
            String[] asmp = inp[0].split(" ");
            
            for (int j = 0; j<asmp.length; j++) {
                if (!conc.contains(asmp[j])) {
                    System.out.println(i+1);
                    sc.close();
                    return;
                }
            }
            conc.add(inp[1]);
        }

        sc.close();
        System.out.println("correct");
    }
}
