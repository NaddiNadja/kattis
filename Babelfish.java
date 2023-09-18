import java.util.HashMap;
import java.util.Scanner;

public class Babelfish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dict = new HashMap<>();
        String[] in = sc.nextLine().split(" ");
        while (in.length>1) {
            dict.put(in[1], in[0]);
            in = sc.nextLine().split(" ");
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while (sc.hasNext()) {
            if (!first) sb.append("\n");
            else first = false;
            String s = sc.nextLine();
            if (!dict.containsKey(s)) sb.append("eh");
            else sb.append(dict.get(s));
        }
        sc.close();
        System.out.println(sb.toString());

    }
}