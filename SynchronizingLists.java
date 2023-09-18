import java.util.Arrays;
import java.util.Comparator;

public class SynchronizingLists {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        while (io.hasMoreTokens()) {
            int n = io.getInt();
            if (n == 0) break;
            Node[] a = new Node[n];
            Node[] b = new Node[n];
            for (int i = 0; i<n; i++) a[i] = new Node(io.getInt(), i);
            for (int i = 0; i<n; i++) b[i] = new Node(io.getInt(), i);

            Arrays.sort(a, new valComp());
            Arrays.sort(b, new valComp());

            for (int i = 0; i<n; i++) {
                a[i].pair = b[i];
                b[i].pair = a[i];
            }

            Arrays.sort(a, new posComp());
            for (int i = 0; i<n; i++) {
                sb.append(a[i].pair.value);
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static class Node {
        Node pair;
        int value;
        int position;

        public Node(int val, int pos) {
            value = val;
            position = pos;
        }
    }

    private static class valComp implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.value < b.value) return -1;
            else if (a.value > b.value) return 1;
            else return 0;
        }
    }

    private static class posComp implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.position < b.position) return -1;
            else if (a.position > b.position) return 1;
            else return 0;
        }
    }
}
