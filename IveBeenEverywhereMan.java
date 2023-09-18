import java.util.HashSet;
import java.util.Scanner;

public class IveBeenEverywhereMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            HashSet<String> cities = new HashSet<>();
            
            for (int j = 0; j<n; j++) {
                cities.add(sc.nextLine());
            }

            sb.append(cities.size());
            if (i != t-1) sb.append("\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }
}

