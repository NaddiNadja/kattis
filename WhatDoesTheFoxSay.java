import java.util.*;

public class WhatDoesTheFoxSay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i<T; i++) {
            String[] sounds = sc.nextLine().split(" ");
            while (sc.hasNext()) {
                String[] inp = sc.nextLine().split(" ");
                if (inp[0].equals("what")) break;
                
                for (int j = 0; j<sounds.length; j++) {
                    if (sounds[j]!=null) if (sounds[j].equals(inp[2])) sounds[j] = null;
                }
            }

            boolean first = true;
            for (int j = 0; j<sounds.length; j++) {
                if (sounds[j]!=null){
                    if (first) first = false;
                    else sb.append(" ");
                    sb.append(sounds[j]);
                }
            }

            sb.append("\n");
            // if (sc.hasNext()) sc.nextLine();
        }
        System.out.print(sb);
        sc.close();
    }
}
