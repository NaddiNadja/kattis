import java.util.Scanner;

public class BabyBites {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] in = sc.nextLine().split(" ");
        sc.close();
        boolean makessense = true;
        for(int i = 0; i<n; i++) {
            if (!in[i].equals("mumble") && Integer.parseInt(in[i]) != i+1) makessense = false;
        }
        if (makessense) System.out.println("makes sense");
        else System.out.println("something is fishy");
    }
}
