import java.util.Scanner;

public class Autori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split("-");
        sc.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<inp.length; i++) {
            sb.append(inp[i].charAt(0));
        }
        System.out.println(sb.toString());
    }
}
