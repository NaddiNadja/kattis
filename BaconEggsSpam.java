import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.util.Iterator;

public class BaconEggsSpam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()) {
            Hashtable<String, ArrayList<String>> items = new Hashtable<>();
            ArrayList<String> itms = new ArrayList<>();
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;

            for (int i = 0; i<n; i++) {
                String[] inp = sc.nextLine().split(" ");
                for (int j = 1; j<inp.length; j++) {
                    if (!items.containsKey(inp[j])) items.put(inp[j], new ArrayList<String>());
                    items.get(inp[j]).add(inp[0]);
                    if (!itms.contains(inp[j])) itms.add(inp[j]);
                }
            }
            Collections.sort(itms);
            for (String key : itms) {
                sb.append(key + " ");
                ArrayList<String> heyo = items.get(key);
                Collections.sort(heyo);
                Iterator<String> it = heyo.iterator();

                while (it.hasNext()) {
                    sb.append(it.next() + " ");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n");
            }
            sb.append("\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }
}
