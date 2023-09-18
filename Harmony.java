//import edu.princeton.cs.algs4.*;

public class Harmony {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int m = io.getInt();

        EdgeWeightedGraph g = new EdgeWeightedGraph(n);
        for (int i = 0; i<m; i++) {
            g.addEdge(new Edge(io.getInt(), io.getInt(), io.getInt()));
        }
        
        Harmonious2Color h2c = new Harmonious2Color(g);
        if (!h2c.isBipartite()) System.out.println(0);
        else System.out.println(1);
    }
}
