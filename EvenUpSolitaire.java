public class EvenUpSolitaire {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i<n; i++) {
            int x = io.getInt();
            if (stack.isEmpty()) {
                stack.push(x);
            } else {
                int y = stack.peek();
                if (y % 2 == x % 2) stack.pop();
                else stack.push(x);
            }
        }
        System.out.println(stack.getSize());
    }
}