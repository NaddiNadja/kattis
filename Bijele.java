public class Bijele {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);

        //read pieces
        int kings = io.getInt();
        int queens = io.getInt();
        int rooks = io.getInt();
        int bishops = io.getInt();
        int knights = io.getInt();
        int pawns = io.getInt();

        //calculate missing amount
        StringBuilder sb = new StringBuilder();
        sb.append(-kings+1); sb.append(" ");
        sb.append(-queens+1); sb.append(" ");
        sb.append(-rooks+2); sb.append(" ");
        sb.append(-bishops+2); sb.append(" ");
        sb.append(-knights+2); sb.append(" ");
        sb.append(-pawns+8);

        System.out.println(sb.toString());
    }
}

/* 
Sample Input
0 1 2 2 2 7
2 1 2 1 2 1
*/