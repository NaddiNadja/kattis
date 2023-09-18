import java.util.Scanner; 
public class DetailedDifferences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numtests = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<numtests; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            compare(s1,s2);
        }
        sc.close();
    }

    private static void compare(String s1, String s2) {
        int n;
        System.out.println(s1);
        System.out.println(s2);
        for(n=0;n<s1.length();n++) {
            if (s1.charAt(n)==s2.charAt(n)) {
                System.out.print(".");
            }
            else{
                System.out.print("*"); 
            }
        }

        System.out.println("");
        System.out.println("");

    }
}
