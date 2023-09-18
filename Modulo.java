import java.util.Scanner;
import java.util.HashSet;

public class Modulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> modulo = new HashSet<>();

        for (int i = 0; i<10; i++) {
            int x = sc.nextInt();
            modulo.add(x % 42);
        }
        sc.close();
        System.out.println(modulo.size());
    }
}