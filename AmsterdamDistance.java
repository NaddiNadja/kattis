import java.util.Scanner;
import java.lang.Math;

public class AmsterdamDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        double r = Double.parseDouble(sc.next());
        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();
        sc.close();

        EdgeWeightedGraph g = new EdgeWeightedGraph(n*(m+1)+1);
        for (int i = 0; i<m+1; i++) {
            int cur = 0;
            int next = i*n+1;
            for (int j = 0; j<n; j++) {
                g.addEdge(new Edge(cur, next, r/n));
                if (i<m) g.addEdge(new Edge(next, next+n, 2 * r/n * (j+1) * Math.PI / (2*m)));
                cur = next;
                next++;;                
            }
        }

        DijkstraUndirectedSP dijkstra = new DijkstraUndirectedSP(g, (ay!=0 ? (ax*n+ay) : 0));
        System.out.println(dijkstra.distTo(by!=0 ? (bx*n+by) : 0));

    }
}
