import java.util.Scanner;

public class CardTrick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i<n; i++) {
            int a = sc.nextInt();
            show(a);
        }
        sc.close();
    }

    private static void show(int a) {
        switch(a) {
            case 1:  System.out.println("1");
                break;
            case 2:  System.out.println("2 1");
                break;
            case 3:  System.out.println("3 1 2");
                break;
            case 4:  System.out.println("2 1 4 3");
                break;
            case 5:  System.out.println("3 1 4 5 2");
                break;
            case 6:  System.out.println("4 1 6 3 2 5");
                break;
            case 7:  System.out.println("5 1 3 4 2 6 7");
                break;
            case 8:  System.out.println("3 1 7 5 2 6 8 4");
                break;
            case 9:  System.out.println("7 1 8 6 2 9 4 5 3");
                break;
            case 10: System.out.println("9 1 8 5 2 4 7 6 3 10");
                break;
            case 11: System.out.println("5 1 6 4 2 10 11 7 3 8 9");
                break;
            case 12: System.out.println("7 1 4 9 2 11 10 8 3 6 5 12");
                break;
            case 13: System.out.println("4 1 13 11 2 10 6 7 3 5 12 9 8");
                break;
        }
    }
}
