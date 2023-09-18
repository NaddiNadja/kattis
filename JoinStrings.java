public class JoinStrings {
    static int n;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        n = io.getInt();
        String[] words = new String[n];
        for (int i = 0; i<n; i++) words[i] = io.getWord();

        if (n == 1) {
            System.out.println(words[0]);
            return;
        }

        NList[] arr = new NList[n];
        int last = 0;

        for (int i = 0; i<n-1; i++) {
            int a = io.getInt()-1;
            int b = io.getInt()-1;

            if (arr[a] == null) {
                NList nlist = new NList(new Node(a));
                arr[a] = nlist;
                if (arr[b] == null) nlist.insert(new Node(b));
                else nlist.insert(arr[b].start);
            } else {
                if (arr[b] == null) arr[a].insert(new Node(b));
                else arr[a].insert(arr[b].start);
            }

            if (i == n-2) last = a;
        }

        int[] array = arr[last].toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<array.length; i++) {
            sb.append(words[array[i]]);
        }     
        System.out.println(sb.toString());  
    }

    static class Node {
        Node next;
        int value;
        NList nlist;

        public Node(int value) {
            this.value = value;
        }
    }

    static class NList {
        Node start;
        Node last;

        public NList(Node start) {
            this.start = start;
            this.last = start;
            start.nlist = this;
        }

        public void insert(Node n) {
            if (n.nlist == null) {
                last.next = n;
                last = n;
                n.nlist = this;
            } else {
                last.next = n.nlist.start;
                last = n.nlist.last;
                n.nlist = this;
            }
        }

        public int[] toArray() {
            int[] array = new int[n];
            Node cur = start;
            for (int i = 0; i<n; i++) {
                array[i] = cur.value;
                cur = cur.next;
            }
            return array;
        }
    }
}