import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class EightQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = new String[8];
        for (int i = 0; i<8; i++) in[i] = sc.nextLine();
        sc.close();

        ArrayList<Pair> queens = new ArrayList<>();
        boolean valid = true;

        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                if (in[i].charAt(j) == '*') queens.add(new Pair(j,i));
            }
        }

        if (queens.size() != 8) valid = false;
        else {
            for (int i = 0; i<8; i++) {
                for (int j = i+1; j<8; j++) {
                    if ( queens.get(i).x == queens.get(j).x ||
                         queens.get(i).y == queens.get(j).y ||
                         Math.abs(queens.get(i).x - queens.get(j).x) == Math.abs(queens.get(i).y - queens.get(j).y))
                            valid = false;
                }
            }
        }

        if (valid) System.out.println("valid");
        else System.out.println("invalid");
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

