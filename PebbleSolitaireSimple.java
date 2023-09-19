import java.util.Scanner;

public class PebbleSolitaireSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<n; i++) {
            String s = sc.nextLine();
            sb.append(play(s));
            sb.append("\n");
        }

        sc.close();
        System.out.println(sb.toString());
    }

    static int play(String s) {
        char[] input1 = new char[s.length()];
        char[] input2 = new char[s.length()];    // string to character array
        for (int j = 0; j < s.length(); j++) {  // fill in char-array and count pebbles
            input1[j] = s.charAt(j);
            input2[j] = s.charAt(j);
        }
        // System.out.println("before left: " + Arrays.toString(input1));
        int left = moveleft(input1);
        // System.out.println("before right: " + Arrays.toString(input2));
        int right = moveright(input2);
        if (left<right) return left;
        else return right;

    }

    static int moveleft(char[] input) {
        char[] temp = new char[input.length];
        char[] temp1 = new char[input.length];
        int totpeb = 0;
        for (int j = 0; j < input.length; j++) { 
            if (input[j] == 'o') totpeb++;
            temp[j] = input[j];
            temp1[j] = input[j];
        } 

        for (int i = temp.length-1; i>1; i--) {
            if (temp[i] == 'o' && temp[i-1] == 'o' && temp[i-2] == '-') {
                // System.out.println("from: " + Arrays.toString(temp));
                temp[i] = '-';      temp1[i] = '-';
                temp[i-1] = '-';    temp1[i-1] = '-';
                temp[i-2] = 'o';    temp1[i-2] = 'o';
                totpeb--;

                // System.out.println("to:   " + Arrays.toString(temp));
                int left = moveleft(temp);
                int right = moveright(temp1);
                if (left<right) totpeb = left;
                else totpeb = right;
                break;
            }
        }
        return totpeb;  
    }

    static int moveright(char[] input) {
        char[] temp = new char[input.length];
        char[] temp1 = new char[input.length];
        int totpeb = 0;
        for (int j = 0; j < input.length; j++) { 
            if (input[j] == 'o') totpeb++;
            temp[j] = input[j];
            temp1[j] = input[j];
        } 

        for (int i = 0; i<input.length-2; i++) {
            if (temp[i] == 'o' && temp[i+1] == 'o' && temp[i+2] == '-') {
                // System.out.println("from: " + Arrays.toString(temp));
                temp[i] = '-';      temp1[i] = '-';
                temp[i+1] = '-';    temp1[i+1] = '-';
                temp[i+2] = 'o';    temp1[i+2] = 'o';
                totpeb--;
                
                // System.out.println("to:   " + Arrays.toString(temp));
                int left = moveleft(temp);
                int right = moveright(temp1);
                if (left<right) totpeb = left;
                else totpeb = right;
                break;
            }
        }
        return totpeb;  
    }

    /* 
    static int moveR(char[] input) {
        int pebrem = 0;
        for (int i = 0; i<input.length; i++) {
            if (i < input.length-3 && input[i] == 'o' && input[i+1] == 'o' && input[i+2] == '-') {
                input[i] = '-';
                input[i+1] = '-';
                input[i+2] = 'o';
                pebrem++;
                pebrem = pebrem + moveR(input);
            } else if (i > 2 && input[i] == 'o' && input[i-1] == 'o' && input[i-2] == '-') {
                input[i] = '-';
                input[i-1] = '-';
                input[i-2] = 'o';
                pebrem++;
                pebrem = pebrem + moveleft(input);
            }
        }
        return pebrem;  
    }

    static int moveL(char[] input) {
        int pebrem = 0;

        for (int i = input.length-1; i>=0; i--) {
            if (i > 2 && input[i] == 'o' && input[i-1] == 'o' && input[i-2] == '-') {
                input[i] = '-';
                input[i-1] = '-';
                input[i-2] = 'o';
                pebrem++;
                pebrem = pebrem + moveL(input);
            } else if (i < input.length-3 && input[i] == 'o' && input[i+1] == 'o' && input[i+2] == '-') {
                input[i] = '-';
                input[i+1] = '-';
                input[i+2] = 'o';
                pebrem++;
                pebrem = pebrem + moveright(input);
            }
        }
        return pebrem;  
    }
    */
}

/*

1
---oo-------

1
-o--o-oo----

1
-o----ooo---

1
oooooooooooo

1
oooooooooo-o
123456789012

1
oooooo-ooooo

*/
