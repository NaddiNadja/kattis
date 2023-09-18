import java.util.Scanner;

public class SumOfTheOthers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            System.out.println(sum(input)/2);
        }
        sc.close();
    }

    static int sum(String[] arr) {
        int s = 0;
        for (int i = 0; i<arr.length; i++) {
            s += Integer.parseInt(arr[i]);
        }
        return s;
    }
}
