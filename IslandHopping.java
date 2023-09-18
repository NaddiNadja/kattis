import java.util.Scanner;
import java.lang.Math;

public class IslandHopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            Pair[] coord = new Pair[m];
            for (int j = 0; j<m; j++) coord[j] = new Pair(sc.nextLine().split(" "));

            EdgeWeightedGraph g = new EdgeWeightedGraph(m);
            for (int j = 0; j<m-1; j++) {
                for (int k = j+1; k<m; k++) {
                    double difx = Math.abs(coord[j].x - coord[k].x);
                    double dify = Math.abs(coord[j].y - coord[k].y);
                    double edgeweight = Math.sqrt(Math.pow(difx,2) + Math.pow(dify,2));
                    g.addEdge(new Edge(j,k,edgeweight));
                }
            }

            PrimMST mst = new PrimMST(g);
            System.out.println(mst.weight());
        }
        sc.close();
    }

    static class Pair {
        double x;
        double y;

        public Pair(String[] arr) {
            this.x = Double.parseDouble(arr[0]);
            this.y = Double.parseDouble(arr[1]);
        }
    }
}
