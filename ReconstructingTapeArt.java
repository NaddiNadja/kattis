public class ReconstructingTapeArt {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();

        MyStack<Integer> colours = new MyStack<>();
        MyStack<Integer> stack = new MyStack<>();
        boolean[] visited = new boolean[n+1];
        int[] input = new int[n];
        int[] firstSeen = new int[n+1];
        int[] lastSeen = new int[n+1];

        for (int i = 0; i<n; i++) input[i] = io.getInt();

        boolean top = false;

        try {
            for (int i = 0; i<n; i++) {
                int x = input[i];
                if (!visited[x]) {
                    visited[x] = true;
                    top = true;
                    firstSeen[x] = i+1;
                    lastSeen[x] = i+1;
                    colours.push(x);
                    if (i<n-1) {
                        if (x != input[i+1] && visited[input[i+1]]) {
                            if (colours.pop() != x) throw new Exception();
                            stack.push(x);
                            top = false;
                        }
                    } else {
                        if (colours.pop() != x) throw new Exception();
                        stack.push(x);
                        top = false;
                    }
                } else {
                    if (i<n-1) {
                        if (x == input[i+1]) continue;
                        else if (!visited[input[i+1]]) {
                            if (top) {
                                lastSeen[x] = i+1;
                                if (colours.pop() != x) throw new Exception();
                                stack.push(x);
                            } else {
                                lastSeen[x] = i+1;
                                continue;
                            }
                        } else {
                            lastSeen[x] = i+1;
                            if (colours.pop() != x) throw new Exception();
                            stack.push(x);
                            top = false;
                        }
                    } else {
                        lastSeen[x] = i+1;
                        if (colours.pop() != x) throw new Exception();
                        stack.push(x);
                    }
                }
            }
            int coloursize = colours.getSize();
            for (int i = 0; i<coloursize; i++) stack.push(colours.pop());

            int size = stack.getSize();

            StringBuilder sb = new StringBuilder();
            sb.append(size);
            for (int i = 0; i<size; i++) {
                int x = stack.pop();
                sb.append("\n").append(firstSeen[x]).append(" ").append(lastSeen[x]).append(" ").append(x);
            }
            System.out.println(sb);
        } catch(Exception e) {
            System.out.println("IMPOSSIBLE");
        }
    }
}