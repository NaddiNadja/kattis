public class SumKindOfPeople {
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int p = sc.getInt();

        for (int i = 0; i<p; i++) {
            int k = sc.getInt();
            int n = sc.getInt();

            int s1 = ((n*(n+1)) / 2);
            int s2 = 2*((n*(n+1)) / 2) - n;
            int s3 = 2*((n*(n+1)) / 2);

            sb.append(k);
            sb.append(" ");
            sb.append(s1);
            sb.append(" ");
            sb.append(s2);
            sb.append(" ");
            sb.append(s3);
            if (i!=p-1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

