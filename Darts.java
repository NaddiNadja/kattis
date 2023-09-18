import java.lang.Math;

public class Darts {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int t = io.getInt();

        for (int a = 0; a<t; a++) {
            int n = io.getInt();
            int points = 0;
            for (int i = 0; i<n; i++) {
                int x = Math.abs(io.getInt());
                int y = Math.abs(io.getInt());
                double length = Math.sqrt(x*x + y*y);
                points += getScore(length);
            }
            System.out.println(points);
        }
    }

    static int getScore(double d) {
        if (d<=20) return 10;
        if (d<=40) return 9;
        if (d<=60) return 8;
        if (d<=80) return 7;
        if (d<=100) return 6;
        if (d<=120) return 5;
        if (d<=140) return 4;
        if (d<=160) return 3;
        if (d<=180) return 2;
        if (d<=200) return 1;
        return 0;
    }
}
