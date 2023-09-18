import java.lang.Math;
public class SevenWonders {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String in = io.getWord();
        int t = 0;
        int c = 0;
        int g = 0;
        for (int i = 0; i<in.length(); i++) {
            if (in.charAt(i) == 'T') t++;
            else if (in.charAt(i) == 'C') c++;
            else g++;
        }
        int minval = Math.min(t,c);
        minval = Math.min(minval,g);
        System.out.println(t*t+c*c+g*g+minval*7);
    }
}
