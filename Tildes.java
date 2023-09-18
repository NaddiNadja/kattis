import java.util.Scanner;

public class Tildes {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        int[] sizes = new int[n];

        for (int i = 0; i<n;i++) sizes[i]=1;

        for (int i = 0; i<q; i++){
            sc.nextLine();
            char ts = sc.next().charAt(0);
            int s = sc.nextInt()-1;
            int rootS = uf.find(s);

            if (ts=='t') {
                int t = sc.nextInt()-1;
                int rootT = uf.find(t);
                if (rootT!=rootS) {
                    uf.union(s,t);
                    if (sizes[rootS]>=sizes[rootT]) {
                        sizes[rootS]+=sizes[rootT];
                        sizes[rootT]=0;
                    } else {
                        sizes[rootT]+=sizes[rootS];
                        sizes[rootS]=0;
                    }
                }
            } else {
                sb.append(sizes[rootS]+"\n");
                // sb.append(uf.size[uf.find(s)]+"\n");
            }
        }
        sc.close();
        System.out.println(sb);
    }
}