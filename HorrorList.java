import java.util.Scanner;

public class HorrorList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int L = sc.nextInt();

        EdgeWeightedGraph g = new EdgeWeightedGraph(N);
        int x = sc.nextInt();
        for (int i = 1; i<H; i++) {
            int y = sc.nextInt();
            g.addEdge(new Edge(x,y,0));
            x = y;
        }

        for (int i = 0; i<L; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.addEdge(new Edge(a,b,1));
        }

        DijkstraUndirectedSP dijk = new DijkstraUndirectedSP(g, x);

        double bestdist = 0;
        int best = 0;

        for (int i = 0; i<N; i++) {
            if (dijk.distTo(i) > bestdist) {
                bestdist = dijk.distTo(i);
                best = i;
            }
        }

        System.out.println(best);
        sc.close();
    }
}
