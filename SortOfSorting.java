import java.util.Scanner;

public class SortOfSorting {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<500 ; i++) {
            int n = sc.nextInt();
            if (n==0) break;
            Person[] people = new Person[n];
            for (int j = 0; j<n; j++) {
                people[j] = new Person(sc.next());
            }

            Insertion.sort(people);
            if (sb.length()>0) sb.append("\n");
            for (int j = 0; j<n; j++) {
                Person x = people[j];
                sb.append(x.name);
                sb.append("\n");
            }          
        }
        sc.close();
        System.out.print(sb);
    } 
}

/*
3
Mozart
beethoven
Bach
5
Hilbert
Godel
Poincare
Ramanujan
Pochhammmer
0
*/