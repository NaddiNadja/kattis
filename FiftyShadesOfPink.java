public class FiftyShadesOfPink {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int sum = 0;
        for (int i = 0; i<n; i++) {
            String s = io.getWord().toLowerCase();
            if (s.contains("rose") || s.contains("pink")) sum++;
        } 
        if (sum>0) System.out.println(sum);
        else System.out.println("I must watch Star Wars with my daughter");
    }
}
