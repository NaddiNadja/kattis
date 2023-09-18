import java.util.ArrayList;
import java.util.Scanner;

public class NineKnights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = new String[5];
        for (int i = 0; i<5; i++) in[i] = sc.nextLine();
        sc.close();

        ArrayList<Pair> knights = new ArrayList<>();
        boolean valid = true;

        for (int i = 0; i<5; i++) {
            for (int j = 0; j<5; j++) {
                if (in[i].charAt(j) == 'k') knights.add(new Pair(j,i));
            }
        }

        if (knights.size() != 9) valid = false;
        else {
            for (int i = 0; i<9; i++) {
                for (int j = i+1; j<9; j++) {
                    if ( knights.get(i).x == knights.get(j).x-1 && knights.get(i).y == knights.get(j).y-2 ||
                         knights.get(i).x == knights.get(j).x-1 && knights.get(i).y == knights.get(j).y+2 ||
                         knights.get(i).x == knights.get(j).x-2 && knights.get(i).y == knights.get(j).y-1 ||
                         knights.get(i).x == knights.get(j).x-2 && knights.get(i).y == knights.get(j).y+1 ||
                         knights.get(i).x == knights.get(j).x+1 && knights.get(i).y == knights.get(j).y-2 ||
                         knights.get(i).x == knights.get(j).x+1 && knights.get(i).y == knights.get(j).y+2 ||
                         knights.get(i).x == knights.get(j).x+2 && knights.get(i).y == knights.get(j).y-1 ||
                         knights.get(i).x == knights.get(j).x+2 && knights.get(i).y == knights.get(j).y+1)
                            valid = false;
                }
            }
        }

        if (valid) System.out.println("valid");
        else System.out.println("invalid");
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair that) {
            return that.x-this.x;
        }
    }
}

