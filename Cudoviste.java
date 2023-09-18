import java.util.Scanner;

public class Cudoviste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        String[] map = new String[R];

        for (int i = 0; i<R; i++) {
            map[i] = sc.next();
        }

        sc.close();

        int[] cars = new int[5];

        for (int i = 0; i<(R-1); i++) {
            for (int j = 0; j<(C-1); j++) {
                int crush = 0;

                if (map[i].charAt(j) == '#') continue;
                else if (map[i].charAt(j) == 'X') crush++;
                
                if (map[i].charAt(j+1) == '#') continue;
                else if (map[i].charAt(j+1) == 'X') crush++;

                if (map[i+1].charAt(j) == '#') continue;
                else if (map[i+1].charAt(j) == 'X') crush++;

                if (map[i+1].charAt(j+1) == '#') continue;
                else if (map[i+1].charAt(j+1) == 'X') crush++;

                cars[crush]++;
            }
        }

        System.out.println(cars[0]);
        System.out.println(cars[1]);
        System.out.println(cars[2]);
        System.out.println(cars[3]);
        System.out.println(cars[4]);

    }
}

/* Sample input

4 4
#..#
..X.
..X.
#XX#

4 4
....
....
....
....

4 5
..XX.
.#XX.
..#..
.....

*/
