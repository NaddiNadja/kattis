import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

public class Incognito{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            HashMap<String, Integer> hm = new HashMap<String, Integer>();

            for(int j = 0; j < n; j++){
                String name = sc.next(); //unused
                String category = sc.nextLine();

                if(hm.containsKey(category)){
                    int freq = hm.get(category);
                    freq++;
                    hm.put(category, freq);
                }
                else{
                    hm.put(category, 1);
                }
            }

            int combs = 1;
            for(Entry<String, Integer> val : hm.entrySet()){
               combs = combs * (val.getValue() + 1);
            }
            //wearing nothing is not a valid disguise
            combs--;

            out.append(combs);
            out.append("\n");
        }
        System.out.print(out);
        sc.close();
    }
}