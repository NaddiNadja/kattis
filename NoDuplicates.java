import java.util.HashSet;
import java.util.Scanner;

public class NoDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        String[] input = sc.nextLine().split(" ");
        sc.close();
        for (int i = 0; i<input.length; i++) hs.add(input[i]);
        if (hs.size() == input.length) System.out.println("yes");
        else System.out.println("no");
    }
}
