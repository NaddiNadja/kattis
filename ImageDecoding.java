import java.util.Scanner;

public class ImageDecoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean firstimg = true;
        boolean error = false;
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;

            if (firstimg) firstimg = false;
            else System.out.println();

            error = false;
            int sum = 0;
            boolean first = true;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i<n; i++) {
                String[] in = sc.nextLine().split(" ");
                boolean point = true;
                if (in[0].charAt(0) == '#') point = false;
                int tempsum = 0;
                for (int j = 1; j<in.length; j++) {
                    int amount = Integer.parseInt(in[j]);
                    tempsum += amount;
                    for (int k = 0; k<amount; k++) {
                        if (point) sb.append('.');
                        else sb.append('#');
                    }
                    point = !point;
                }

                if (first) first = false;
                else if (sum != tempsum) error = true;
                sum = tempsum;

                sb.append("\n");
            }
            System.out.print(sb.toString());
            if (error) System.out.println("Error decoding image");
        }
        sc.close();
    }
}