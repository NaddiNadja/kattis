/******************************************************************************
 *  Compilation:  javac BipartiteX.java
 *  Execution:    java  Bipartite V E F
 *  Dependencies: EdgeWeightedGraph.java Edge.java
 *
 *  Given a graph, find either (i) a bipartition or (ii) an odd-length cycle.
 *  Runs in O(E + V) time.
 *
 *
 ******************************************************************************/

 //import edu.princeton.cs.algs4.*;

/**
 *  The {@code BipartiteX} class represents a data type for 
 *  determining whether an undirected graph is <em>bipartite</em> or whether
 *  it has an <em>odd-length cycle</em>.
 *  A graph is bipartite if and only if it has no odd-length cycle.
 *  The <em>isBipartite</em> operation determines whether the graph is
 *  bipartite. If so, the <em>color</em> operation determines a
 *  bipartition; if not, the <em>oddCycle</em> operation determines a
 *  cycle with an odd number of edges.
 *  <p>
 *  This implementation uses <em>breadth-first search</em> and is nonrecursive.
 *  The constructor takes &Theta;(<em>V</em> + <em>E</em>) time in
 *  in the worst case, where <em>V</em> is the number of vertices
 *  and <em>E</em> is the number of edges.
 *  Each instance method takes &Theta;(1) time.
 *  It uses &Theta;(<em>V</em>) extra space (not including the graph).
 *  See {@link Bipartite} for a recursive version that uses depth-first search.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/41graph">Section 4.1</a>   
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Harmonious2Color {
    private static final boolean WHITE = false;

    private boolean isBipartite;   // is the graph bipartite?
    private boolean[] color;       // color[v] gives vertices on one side of bipartition
    private boolean[] marked;      // marked[v] = true iff v has been visited in DFS
    private int[] edgeTo;          // edgeTo[v] = last edge on path to v

    /**
     * Determines whether an undirected graph is bipartite and finds either a
     * bipartition or an odd-length cycle.
     *
     * @param  G the graph
     */
    public Harmonious2Color(EdgeWeightedGraph G) {
        isBipartite = true;
        color  = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for (int v = 0; v < G.V() && isBipartite; v++) {
            if (!marked[v]) {
                bfs(G, v);
            }
        }
    }

    private void bfs(EdgeWeightedGraph G, int s) { 
        Queue<Integer> q = new Queue<Integer>();
        color[s] = WHITE;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (Edge e : G.adj(v)) {
                int w = e.other(v);
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    if (e.weight() == 1) color[w] = !color[v];
                    else color[w] = color[v];
                    q.enqueue(w);
                }
                else if (color[w] == color[v] && e.weight() == 1) {
                    isBipartite = false;
                    return;
                }
                else if (color[w] != color[v] && e.weight() == 0) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }

    /**
     * Returns true if the graph is bipartite.
     *
     * @return {@code true} if the graph is bipartite; {@code false} otherwise
     */
    public boolean isBipartite() {
        return isBipartite;
    }
}