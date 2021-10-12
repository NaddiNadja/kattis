public class UnionFind {
    public static void main (String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder output = new StringBuilder();

        int N = io.getInt();
        int Q = io.getInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

        for (int i=0; i<Q; i++) {
            char op = io.getWord().charAt(0);
            int a = io.getInt();
            int b = io.getInt();

            if (op == '=') {
                if (uf.find(a)!=uf.find(b)) uf.union(a, b);
            } else if (op == '?') {
                if (output.length()>0) output.append("\n");
                if (uf.find(a)==uf.find(b)) output.append("yes");
                else output.append("no");
            }
        }
        
        System.out.print(output);
    }

}