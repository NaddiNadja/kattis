import java.util.Locale;

public class AboveAverage {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int c = io.getInt();
        for (int i = 0; i<c; i++) {
            int n = io.getInt();
            int[] grades = new int[n];
            double sum = 0.0;
            for (int j = 0; j<n; j++) {
                grades[j] = io.getInt();
                sum += grades[j];
            }
            double avgrade = sum/n;
            double overav = 0.0;
            for (int j = 0; j<n; j++) if (grades[j]>avgrade) overav++;
            double percentage = overav / n * 100;
            System.out.format(Locale.US, "%.3f", percentage);
            System.out.println("%");
        }
    }
}