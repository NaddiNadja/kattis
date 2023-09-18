import java.util.Arrays;

public class PlantingTrees {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int[] t = new int[n];
        for (int i = 0; i<n; i++) t[i] = io.getInt();
        
        Arrays.sort(t);
        int days = 2;
        int party = 0;
        for (int i = n-1; i>=0; i--) {
            if (party < days+t[i]) party = days+t[i];
            days++;
        }
        System.out.println(party);
    }
}