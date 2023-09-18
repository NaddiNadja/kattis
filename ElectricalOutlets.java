public class ElectricalOutlets {
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.getInt();
        for (int i = 0; i<n; i++) {
            int k = sc.getInt();
            int sum = 0;
            for (int j = 0; j<k; j++) {
                int o = sc.getInt();
                sum += (j < k-1)? o-1 : o;
            }
            sb.append(sum);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}