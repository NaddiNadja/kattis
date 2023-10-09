public class DNA {
    static int[][] opt;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        String s = io.getWord();
        opt = new int[n][2];
        try{

            int result = solve(s, n-1, false);
            System.out.println(result);
            System.out.println((System.currentTimeMillis()-start)/1000000.0);
            io.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int solve(String s, int i, boolean flipped) {
        if (i < 0) return 0;
        if (opt[i][flipped? 0 : 1] != 0) return opt[i][flipped? 0 : 1];

        char cur = s.charAt(i);
        int result = 0;
        if (cur == 'A' && !flipped || cur == 'B' && flipped) {
            result = solve(s, i-1, flipped);
        } else {
            int fliponce = 1 + solve(s, i-1, flipped);
            int flipall = 1 + solve(s, i-1, !flipped);
            result = fliponce < flipall ? fliponce : flipall;
        }
        opt[i][flipped? 0 : 1] = result;
        return result;
    }
}