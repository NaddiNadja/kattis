package Unfinished;

public class WeakVertices {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();

        while (io.hasMoreTokens()) {
            int n = Integer.parseInt(io.getWord());
            if (n == -1) break;
            int[][] map = new int[n][n];
            
            for (int r = 0; r<n; r++) {
                for (int c = 0; c<n; c++) {
                    map[r][c] = io.getInt();
                }
            }
            for (int r = 0; r<n; r++) {
                boolean strong = true;
                for (int c = 0; c<r; c++) {
                }
            }
        }
        io.close();
    }

}
