import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;

public class Costume{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            if(hm.containsKey(s)){
                int freq = hm.get(s);
                freq++;
                hm.put(s, freq);
            }
            else{
                hm.put(s, 1);
            }
        }

        int lowFreq = Integer.MAX_VALUE;

        ArrayList<String> lowestFreq = new ArrayList<String>();

        for(Entry<String, Integer> val : hm.entrySet()){
            if(val.getValue() == lowFreq){
                lowestFreq.add(val.getKey());
            }
            else if(val.getValue() < lowFreq){
                lowestFreq.clear();
                lowestFreq.add(val.getKey());
                lowFreq = val.getValue();
            }
        }

        Collections.sort(lowestFreq);
        StringBuilder out = new StringBuilder();
        for(String s : lowestFreq){
            out.append(s);
            out.append("\n");
        }

        System.out.print(out);
        sc.close();
    }
}