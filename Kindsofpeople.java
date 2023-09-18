// package Unfinished;

public class Kindsofpeople {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int R = io.getInt(); // number of input lines
        int C = io.getInt(); // number of chars on lines

        String[] map = new String[R];
        for (int i = 0; i<R; i++) {
            map[i] = io.getWord();
        }

        // Create graph and add edges between all connected 1s and between all connected 0s
        EdgeWeightedGraph g = new EdgeWeightedGraph(R*C);

        for (int i = 0; i<R; i++) {
            for (int j = 0; j<C; j++) {
                int curpos = j+i*C;
                if (chartoint(map[i].charAt(j)) == 1) {
                    if (j<C-1) if (chartoint(map[i].charAt(j+1)) == 1) g.addEdge(new Edge(curpos, curpos+1, 1));
                    if (i<R-1) if (chartoint(map[i+1].charAt(j)) == 1) g.addEdge(new Edge(curpos, curpos+C, 1));
                } else 
                if (chartoint(map[i].charAt(j)) == 0) {
                    if (j<C-1) if (chartoint(map[i].charAt(j+1)) == 0) g.addEdge(new Edge(curpos, curpos+1, 1));
                    if (i<R-1) if (chartoint(map[i+1].charAt(j)) == 0) g.addEdge(new Edge(curpos, curpos+C, 1));
                }
            }
        }

        int n = io.getInt();
        for (int i = 0; i<n; i++) {
            int r1 = io.getInt()-1;
            int c1 = io.getInt()-1;
            int pos1 = C*r1+c1;
            int r2 = io.getInt()-1;
            int c2 = io.getInt()-1;
            int pos2 = C*r2+c2;
            DijkstraUndirectedSP dijkstra = new DijkstraUndirectedSP(g, pos1);
            if (!dijkstra.hasPathTo(pos2)) sb.append("neither");
            else if (chartoint(map[r1].charAt(c1))==0) sb.append("binary");
            else sb.append("decimal");
            sb.append("\n"); 
        }

        System.out.println(sb);

    }

    static int chartoint(char x){
        return Character.getNumericValue(x);
    }
}

/* 

10 20
11111111111111111111
11000000000000000101
11111111111111110000
11111111111111110000
11000000000000000111
00011111111111111111
00111111111111111111
10000000000000001111
11111111111111111111
11111111111111111111
3
2 3 8 16
8 1 7 3
1 1 10 20

1 4
1100
2
1 1 1 4
1 1 1 1

*/