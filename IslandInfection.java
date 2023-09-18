import java.util.Scanner;

public class IslandInfection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        String[] input = new String[R];
        sc.nextLine();

        int pos2 = 0;
        int pos3 = 0;

        for (int i = 0; i < R; i++) {
            input[i] = sc.nextLine();
            for (int j = 0; j < C; j++) {
                if (chartoint(input[i].charAt(j)) == 2) {
                    pos2 = j+i*C;
                } else if (chartoint(input[i].charAt(j)) == 3) {
                    pos3 = j+i*C;
                }
            }
        }

        Graph g = new Graph(R*C);

        for (int i = 0; i<R; i++) {
            for (int j = 0; j<C; j++) {
                int curpos = j+i*C;
                if (chartoint(input[i].charAt(j)) == 1 || chartoint(input[i].charAt(j)) == 2 || chartoint(input[i].charAt(j)) == 3) {
                    if (j<C-1) 
                        if (chartoint(input[i].charAt(j+1)) == 1 || chartoint(input[i].charAt(j+1)) == 2 || chartoint(input[i].charAt(j+1)) == 3) 
                            g.addEdge(curpos, curpos+1);
                    if (i<R-1) 
                        if (chartoint(input[i+1].charAt(j)) == 1 || chartoint(input[i+1].charAt(j)) == 2 || chartoint(input[i+1].charAt(j)) == 3) 
                            g.addEdge(curpos, curpos+C);
                }
            }
        }

        DepthFirstPaths dfs = new DepthFirstPaths(g, pos2);
        if (dfs.hasPathTo(pos3)) System.out.println(1);
        else System.out.println(0);
        sc.close();

    }

    static int chartoint(char x){
        return Character.getNumericValue(x);
    }
}

/*
4 6
111001  
112000
011103
101111

2 2
02
30

1 2
23

*/