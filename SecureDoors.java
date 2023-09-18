import java.util.HashSet;
import java.util.Scanner;

public class SecureDoors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i<n; i++) {
            String[] in = sc.nextLine().split(" ");

            if (in[0].equals("entry")) {
                if (set.contains(in[1])) {
                    System.out.println(in[1] + " entered (ANOMALY)");
                } else {
                    System.out.println(in[1] + " entered");
                    set.add(in[1]);
                }
            } else {
                if (!set.contains(in[1])) {
                    System.out.println(in[1] + " exited (ANOMALY)");
                } else {
                    System.out.println(in[1] + " exited");
                    set.remove(in[1]);
                }
            }
        }
        sc.close();
    }
}
