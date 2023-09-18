import java.util.Scanner;

public class TheGrandAdventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i<n; i++) {
            String a = sc.nextLine();
            Bag bag = new Bag();
            boolean adventure = true;
            for (int j = 0; j<a.length(); j++) {
                char c = a.charAt(j);
                
                if (c == '.') continue;
                
                if (c == '$' || c == '|' || c == '*') {
                    bag.push(c);
                } else {
                    char item = bag.pop();
                    if (c == 't') {
                        if (item != '|') adventure = false;
                    } else if (c == 'j') {
                        if (item != '*') adventure = false;
                    } else if (c == 'b') {
                        if (item != '$') adventure = false;
                    }
                }
            }
            if (bag.getSize() != 0) adventure = false;
            System.out.println(adventure? "YES" : "NO");
        }
        sc.close();
    }

    private static class Bag {
        private char[] bag;
        private int size;

        public Bag() {
            bag = new char[1000];
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public void push(char c) {
            bag[size] = c;
            size++;
        }

        public char pop() {
            if (size == 0) return '0';
            size--;
            return bag[size];
        }

    }
}
