import java.util.Scanner;

public class Balance {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String w = io.getWord();

        int length = w.length();
        boolean balanced = true;
        if (length % 2 != 0) balanced = false;

        MyStack<Character> stack = new MyStack<>();

        int i = 0;
        while (i < length && balanced) {
            char c = w.charAt(i);
            switch (c) {
                case '(' :
                case '[' :
                    stack.push(c);
                    break;
                case ')' :
                    if (stack.isEmpty()) balanced = false;
                    else if (stack.pop() != '(') balanced = false;
                    break;
                case ']' :
                    if (stack.isEmpty()) balanced = false;
                    else if (stack.pop() != '[') balanced = false;
                    break;
            }
            i++;
        }

        if (!stack.isEmpty()) balanced = false;

        if (balanced) System.out.println(1);
        else System.out.println(0);
    }
}