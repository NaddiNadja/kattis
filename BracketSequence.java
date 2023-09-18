public class BracketSequence {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        MyStack<Long> stack = new MyStack<>();
        boolean addition = true;
        stack.push((long) 0);

        for (int i = 0; i<n; i++) {
            String s = io.getWord();
            if (s.charAt(0) == '(') {
                if (addition) stack.push((long) 1);
                else stack.push((long) 0);
                addition = !addition;
            } else if (s.charAt(0) == ')') {
                long x = stack.pop();
                long y = stack.pop();
                if (!addition) stack.push((x+y) % 1000000007);
                else stack.push((x*y) % 1000000007);
                addition = !addition;
            } else {
                long x = stack.pop();
                long y = Long.parseLong(s);
                if (addition) stack.push((x+y) % 1000000007);
                else stack.push((x*y) % 1000000007);
            }
        }
        
        System.out.println(stack.pop());
    }
}
