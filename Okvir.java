import java.util.Scanner;

public class Okvir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int U = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        int D = sc.nextInt();
        sc.nextLine();

        String[] input = new String[m];
        for (int i = 0; i<m; i++) {
            input[i] = sc.nextLine();
        }
        sc.close();

        boolean hash = true;
        boolean evenline = true;
        boolean firstline = true;


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<U; i++) {
            if (!firstline) sb.append("\n");
            else firstline = false;

            for (int j = 0; j<n+L+R; j++) {
                if (hash) {
                    sb.append('#');
                    hash = false;
                } else {
                    sb.append('.');
                    hash = true;
                }
            }
            if (evenline) {
                hash = false;
                evenline = false;
            } else {
                hash = true;
                evenline = true; 
            }
        }

        for (int i = 0; i<m; i++) {
            if (!firstline) sb.append("\n");
            else firstline = false;

            for (int j = 0; j<L; j++) {
                if (hash) {
                    sb.append('#');
                    hash = false;
                } else {
                    sb.append('.');
                    hash = true;
                }
            }

            if (n%2 != 0 && hash) hash = false;
            else if (n%2 != 0 && !hash) hash = true;

            sb.append(input[i]);
            
            for (int j = 0; j<R; j++) {
                if (hash) {
                    sb.append('#');
                    hash = false;
                } else {
                    sb.append('.');
                    hash = true;
                }
            }
            if (evenline) {
                hash = false;
                evenline = false;
            } else {
                hash = true;
                evenline = true; 
            }
        }

        for (int i = 0; i<D; i++) {
            if (!firstline) sb.append("\n");
            else firstline = false;

            for (int j = 0; j<n+L+R; j++) {
                if (hash) {
                    sb.append('#');
                    hash = false;
                } else {
                    sb.append('.');
                    hash = true;
                }
            }
            if (evenline) {
                hash = false;
                evenline = false;
            } else {
                hash = true;
                evenline = true; 
            }
            
        }

        System.out.println(sb.toString());
    }
}
