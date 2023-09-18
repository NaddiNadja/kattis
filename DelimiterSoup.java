import java.util.Scanner;

public class DelimiterSoup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Stack<Character> stack = new Stack<>();
        int length = Integer.parseInt(sc.nextLine());; //number of symbols in string
        String s = sc.nextLine();

        boolean correct = true;
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (!stack.isEmpty()){
                    if (c == ']' && stack.peek() == '[') stack.pop(); 
                    else if (c == ')' && stack.peek() == '(') stack.pop();
                    else if (c == '}' && stack.peek() == '{') stack.pop();
                    else correct = false;
                } 
                else correct = false;
            } 
            if (!correct) {
                System.out.println(c + " " + i);
                break;
            }
        }
        sc.close();
        if (correct) System.out.println("ok so far");
    }
}