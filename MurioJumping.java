import java.util.Scanner;

public class MurioJumping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int H = sc.nextInt();
        int F = sc.nextInt();
        boolean winnable = true;
        int[] lowestAir = new int[R+1];
        String[] input = new String[R];
        sc.nextLine(); // færdiggør tallinjen, så jeg kan læse input

        for (int i = 0; i < R; i++) {
            input[i] = sc.nextLine();
            boolean groundfound = false;
            for (int j = 0; j < C; j++) {
                if (!groundfound && input[i].charAt(j) == '.') {
                    groundfound = true;
                    lowestAir[i+1] = j;
                    break;
                } 
            }
        }

        sc.close();

        for (int i = 0; i<R-1; i++) {
            int dif = lowestAir[i+1]-lowestAir[i];
            if (dif > 0 && dif > H) {
                winnable = false;
                System.out.println(i+1); // +1 fordi jeg skal printe den næste række.
                break;
            } else if (dif < 0 && dif < -F) {
                winnable = false;
                System.out.println(i+1); // +1 fordi jeg skal printe den næste række.
                break;
            }
        }

        if (winnable) System.out.println("Wahoo!");
    }
}
