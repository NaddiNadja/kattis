import java.util.Scanner;

public class WordsForNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            for (int i = 0; i<s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    StringBuilder t = new StringBuilder();
                    t.append(s.charAt(i));
                    if (i != s.length()-1 && Character.isDigit(s.charAt(i+1))) t.append(s.charAt(i+1));
                    String u = t.toString();
                    if (i == 0) {
                        sb.append(toUppercase(getNumber(Integer.parseInt(u))));
                    } else sb.append(getNumber(Integer.parseInt(u)));
                    if (i != s.length()-1 && Character.isDigit(s.charAt(i+1))) i++;
                } else {
                    sb.append(s.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        sc.close();
    }

    static String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine",
                               "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen", "nineteen",
                               "twenty" ,"","","","","","","","","",
                               "thirty" ,"","","","","","","","","",
                               "forty"  ,"","","","","","","","","",
                               "fifty"  ,"","","","","","","","","",
                               "sixty"  ,"","","","","","","","","",
                               "seventy","","","","","","","","","",
                               "eighty" ,"","","","","","","","","",
                               "ninety"};

    static String getNumber(int i) {
        if (i<=20) return numbers[i];
        else if (i % 10 == 0) return numbers[i];
        else {
            int a = i % 10;
            return numbers[i-a] + "-" + numbers[a];
        }
    }

    static String toUppercase(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((int) s.charAt(0))-32));
        sb.append(s.substring(1));
        return sb.toString();
    }
}
