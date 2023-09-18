import java.util.Scanner;

public class Dodecaphony {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] notes = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
                        // 0   1    2   3    4   5   6    7   8    9   10   11

        int l = sc.nextInt();

        int[] mel1 = new int[l];
        int[] mel2 = new int[l];

        for (int i = 0; i<l; i++) {
            String a = sc.next();
            int j;
            for (j = 0; j<notes.length; j++) {
                if (a.equals(notes[j])) break;
            }
            mel1[i] = j; 
        }
        for (int i = 0; i<l; i++) {
            String a = sc.next();
            int j;
            for (j = 0; j<notes.length; j++) {
                if (a.equals(notes[j])) break;
            }
            mel2[i] = j; 
        }

        sc.close();

        boolean transposition = false;
        for (int i = 0; i<l-1; i++) {
            int a = mel1[i] - mel1[i+1]; if (a<0) a=a+12;
            int b = mel2[i] - mel2[i+1]; if (b<0) b=b+12;
            if (a == b) transposition = true;
            else { 
                transposition = false; 
                break;
            }
        }

        boolean inversion = false;
        if (mel1[0]==mel2[0]) for (int i = 1; i<l; i++) {
            int a = mel1[0] - mel1[i]; if (a<0) a=a+12;
            int b = mel2[i] - mel2[0]; if (b<0) b=b+12;
            if (a == b) inversion = true;
            else { 
                inversion = false; 
                break;
            }
        }

        boolean retrograde = false;
        for (int i = 0; i<l; i++) {
            if (mel1[i] == mel2[l-i-1]) retrograde = true;
            else { 
                retrograde = false; 
                break;
            }
        }

        if (transposition) System.out.println("Transposition");
        if (inversion) System.out.println("Inversion");
        if (retrograde) System.out.println("Retrograde");
        if (!transposition && !inversion && !retrograde) System.out.println("Nonsense");


    }
}

/* Sample input

3
C E G
D F# A

7
C C G G A A G
C C F F D# D# F

7
A B C D E F G
G F E D C B A

5
C D E F G
C C C C C

*/