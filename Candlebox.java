public class Candlebox {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int D = io.getInt();
        int R = io.getInt();
        int T = io.getInt();

        int ageT = 0;

        for (int y = 3; y<1000; y++) {
            int Rs = (y+D)*((y+D)+1)/2 - 6;
            int Ts = (y*(y+1))/2 - 3;
            if (R - Rs == Ts - T) {
                ageT = y;
                break;
            }
        }

        System.out.println(R - ((ageT+D)*((ageT+D)+1)/2 - 6));
    }
}

/*

2
26
8


y^2 + (D+1)y


(2*total + 32 - D - D^2)/2


Rs = (y+D)((y+D)+1)/2 - 10
Ts = y(y+1)/2 - 6

R - (y+D)((y+D)+1)/2 - 10 = y(y+1)/2 - 6 - T

R - Rs = hvad vi leder efter
x




*/
