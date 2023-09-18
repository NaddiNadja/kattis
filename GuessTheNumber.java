import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 1000;
        
        for (int i = 0; i<10; i++) {

            int guess = (high-low)/2+low;
            System.out.println(guess);
            String ans = scanner.next();
            
            if (ans.compareTo("lower")==0) high = guess-1;
            else if (ans.compareTo("higher")==0) low = guess+1;
            else break;

        }
        scanner.close();
    }
}