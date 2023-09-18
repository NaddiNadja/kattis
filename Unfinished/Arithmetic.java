package Unfinished;
import java.util.HashMap;

public class Arithmetic {
    public static void main(String[] args) {
        HashMap<Character, String> toBinary = new HashMap<>();
        HashMap<String, Character> toHexa = new HashMap<>();

        toBinary.put('0', "000"); toBinary.put('1', "001"); toBinary.put('2', "010"); toBinary.put('3', "011"); 
        toBinary.put('4', "100"); toBinary.put('5', "101"); toBinary.put('6', "110"); toBinary.put('7', "111"); 
        toHexa.put("0000", '0'); toHexa.put("0001", '1'); toHexa.put("0010", '2'); toHexa.put("0011", '3');
        toHexa.put("0100", '4'); toHexa.put("0101", '5'); toHexa.put("0110", '6'); toHexa.put("0111", '7');
        toHexa.put("1000", '8'); toHexa.put("1001", '9'); toHexa.put("1010", 'A'); toHexa.put("1011", 'B');
        toHexa.put("1100", 'C'); toHexa.put("1101", 'D'); toHexa.put("1110", 'E'); toHexa.put("1111", 'F');

        Kattio io = new Kattio(System.in);
        String s = io.getWord();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length(); i++) sb.append(toBinary.get(s.charAt(i)));
        s = sb.toString();
        sb = new StringBuilder();
        for (int i = s.length(); i>0; i-=4) {
            String sub = i>3? s.substring(i-4,i) : s.substring(0,i);
            char c;
            if (i > 3) c = toHexa.get(sub);
            else if (i == 3) c = toHexa.get("0"+sub);
            else if (i == 2) c = toHexa.get("00"+sub);
            else c = toHexa.get("000"+sub);
            
            sb.append(c);
        }
        System.out.println(sb.reverse());
    }
}
