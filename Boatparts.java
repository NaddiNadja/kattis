import java.util.HashSet;
import java.util.Set;

public class Boatparts {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int P = io.getInt(); // number of parts
        int N = io.getInt(); // number of lines
        Set<String> set = new HashSet<>();

        boolean paradox = false;
        int i;
        for (i = 0; i<N; i++) {
            set.add(io.getWord());
            if (set.size()==P) {
                paradox = true;
                i++;
                break;
            }
        }

        if (paradox==true) System.out.println(i);
        else System.out.println("paradox avoided");
    }
}

/* 
Sample input:

3 3
right_oar
left_oar
hull

3 5
left_oar
right_oar
left_oar
hull
right_oar

4 5
motor
hull
left_oar
hull
motor

*/