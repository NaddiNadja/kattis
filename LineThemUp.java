public class LineThemUp {
    public static void main(String[] args) {
        
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        String res = "";
        String a = io.getWord();
        String b;

        for (int i = 0; i<N-1; i++) {
            b = io.getWord();
            String newres = "";
            if (a.compareTo(b)<0) newres = "INCREASING";
            else newres = "DECREASING";
            if (res.isEmpty() || newres.compareTo(res) == 0) res = newres;
            else {
                res = "NEITHER";
                break;
            }
            a = b;
        }
        
        io.print(res);
        io.close();

    }
}