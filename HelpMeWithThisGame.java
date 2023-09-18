import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HelpMeWithThisGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Piece> white = new ArrayList<>();
        ArrayList<Piece> black = new ArrayList<>();

        for (int i = 0; i<8; i++) {
            sc.nextLine();
            String input = sc.nextLine();
            for (int j = 2; j<32; j+=4) {
                char cur = input.charAt(j);
                if (cur == '.' || cur == ':') continue;
                Piece x = new Piece(cur, i, j);
                if (x.getColour()) white.add(x);
                else black.add(x);
            }
        }

        sc.close();

        Collections.sort(white, new SortPieces());
        Collections.sort(black, new SortPieces());

        StringBuilder sb = new StringBuilder();
        sb.append("White: ");
        while (white.iterator().hasNext()) {
            Piece p = white.iterator().next();
            if (p.getPiece() != 'P') sb.append(p.getPiece());
            sb.append(p.getColumn());
            sb.append(p.getRow());
            sb.append(',');
        }
        sb.append("\n Black: ");
        while (black.iterator().hasNext()) {
            Piece p = black.iterator().next();
            if (p.getPiece() != 'P') sb.append(p.getPiece());
            sb.append(p.getColumn());
            sb.append(p.getRow());
            sb.append(',');
        }

        System.out.println(sb.toString());

    }

    static class SortPieces implements Comparator<Piece> {
        public int compare(Piece a, Piece b) {
            if (a.val == b.val) {
                if (a.getColour()) {
                    if (a.row==b.row) {
                        return Character.valueOf(a.column).compareTo(b.column);
                    } else {
                        return a.row-b.row;
                    }
                } else {
                    if (a.row==b.row) {
                        return Character.valueOf(a.column).compareTo(b.column);
                    } else {
                        return b.row-a.row;
                    }
                }
            }
            else return a.val-b.val;
        }
    }
}
