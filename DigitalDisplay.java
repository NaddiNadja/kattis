import java.util.Scanner;

public class DigitalDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("end")) {
                sb.append(s);
                break;
            }
            sb.append(display(s));
            sb.append("\n");
            sb.append("\n");
            sb.append("\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }

    static StringBuilder display(String s) {
        char[][] arr = new char[7][29];
        insert(Character.getNumericValue(s.charAt(0)), 1, arr);
        insert(Character.getNumericValue(s.charAt(1)), 2, arr);
        insert(Character.getNumericValue(s.charAt(3)), 3, arr);
        insert(Character.getNumericValue(s.charAt(4)), 4, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<7; i++) {
            if (i!=0) sb.append("\n");
            for (int j = 0; j<29; j++) {
                if (arr[i][j] != '\0') sb.append(arr[i][j]);
                else sb.append(" ");
            }
        }
        return sb;
    }

    static char[][] insert(int num, int pos, char[][] arr) {
        if (pos == 1) pos = 0;
        else if (pos == 2) pos = 7;
        else if (pos == 3) pos = 17;
        else pos = 24;

        if (num == 0 || num == 4 || num == 5 ||num == 6 || num == 8 || num == 9) {
            arr[0][pos] = '+';
            arr[1][pos] = '|';
            arr[2][pos] = '|';
            arr[3][pos] = '+';
        }
        
        if (num == 0 || num == 2 ||num == 6 || num == 8) {
            arr[3][pos] = '+';
            arr[4][pos] = '|';
            arr[5][pos] = '|';
            arr[6][pos] = '+';
        }

        if (num == 0 || num == 1 || num == 2 || num == 3 || num == 4 || num == 7 || num == 8 || num == 9) {
            arr[0][pos+4] = '+';
            arr[1][pos+4] = '|';
            arr[2][pos+4] = '|';
            arr[3][pos+4] = '+';
        }
        
        if (num == 0 || num == 1 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7 || num == 8 || num == 9) {
            arr[3][pos+4] = '+';
            arr[4][pos+4] = '|';
            arr[5][pos+4] = '|';
            arr[6][pos+4] = '+';
        }

        if (num == 0 || num == 2 || num == 3 || num == 5 || num == 6 || num == 7 || num == 8 || num == 9) {
            arr[0][pos] = '+';
            arr[0][pos+1] = '-';
            arr[0][pos+2] = '-';
            arr[0][pos+3] = '-';
            arr[0][pos+4] = '+';
        }

        if (num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 8 || num == 9) {
            arr[3][pos] = '+';
            arr[3][pos+1] = '-';
            arr[3][pos+2] = '-';
            arr[3][pos+3] = '-';
            arr[3][pos+4] = '+';
        }

        if (num == 0 || num == 2 || num == 3 || num == 5 || num == 6 || num == 8 || num == 9) {
            arr[6][pos] = '+';
            arr[6][pos+1] = '-';
            arr[6][pos+2] = '-';
            arr[6][pos+3] = '-';
            arr[6][pos+4] = '+';
        }

        arr[2][14] = 'o';
        arr[4][14] = 'o';

        return arr;
    }
}


/*

0 1 2 3 4 . . 7 8 9 10 11 . . . . . 17 18 19 20 21 . . 24 25 26 27 28
1
2
3
4
5
6

*/