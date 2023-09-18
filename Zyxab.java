import java.util.*;

public class Zyxab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<String> contenders = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            HashSet<Character> letters = new HashSet<>();
            String input = sc.nextLine();
            if (input.length() < 5) continue;

            for (char c : input.toCharArray()) letters.add(c);  
            if (letters.size() < input.length()) continue;

            contenders.add(input);
        }
        
        contenders.sort(new lengthComp());

        if (contenders.size() == 0) System.out.println("neibb!");
        else System.out.println(contenders.get(0));
        sc.close();
    }

    private static class lengthComp implements Comparator<String> {
        public int compare(String a, String b) {
            if (a.length()-b.length() == 0) return b.compareTo(a);
            else return a.length()-b.length();
        }
    }
}
