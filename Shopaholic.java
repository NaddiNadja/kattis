import java.util.Arrays;

public class Shopaholic {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();

        int[] input = new int[n];
        for (int i=0; i<n; i++) input[i] = io.getInt();
        Arrays.sort(input);

        long sum = 0;
        for (int i=n-3; i>=0; i-=3) sum += input[i];
        System.out.println(sum);
    }
}