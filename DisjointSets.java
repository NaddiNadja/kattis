import java.util.*;

public class DisjointSets {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int m = io.getInt();

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<m; i++) {
            int op = io.getInt();
            int s = io.getInt();
            int t = io.getInt();

            switch (op) {
                case 0 : // query
                    sb.append(uf.find(s)==uf.find(t) || s == t? "1\n" : "0\n");
                    break;
                case 1 : // union
                    if (uf.find(s) != uf.find(t) && s != t) uf.union(s,t);
                    break;
                case 2 : // move
                    if (uf.find(s) != uf.find(t) && s != t) uf = move(uf,n,s,t);
                    break;
            }
        }
        System.out.print(sb);
    }

    private static WeightedQuickUnionUF move(WeightedQuickUnionUF uf, int n, int s, int t) {
        HashMap<Integer,ArrayList<Integer>> oldSets = findSets(uf, n);
        WeightedQuickUnionUF newUF = new WeightedQuickUnionUF(n);
        Set<Integer> oldRoots = oldSets.keySet();
        for (Integer i : oldRoots) {
            ArrayList<Integer> children = oldSets.get(i);

            int newroot = i;
            int x = 0;
            while (newroot==s && x<children.size()) {
                newroot = children.get(x);
                x++;
            }

            for (Integer j : children) {
                if (j != s && j != newroot) newUF.union(newroot,j);
            }
        }
        newUF.union(s,t);
        return newUF;
    }

    private static HashMap<Integer,ArrayList<Integer>> findSets(WeightedQuickUnionUF uf, int n) {
        HashMap<Integer, ArrayList<Integer>> roots = new HashMap<>();
        for (int i = 0; i<n; i++) {
            int root = uf.find(i);
            if (!roots.containsKey(root)) roots.put(root,new ArrayList<>());
            roots.get(root).add(i);
        }
        return roots;
    }
}