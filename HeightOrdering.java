import java.util.Scanner;

public class HeightOrdering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int p = 0; p<n; p++) {
            if (p!=0) sb.append("\n");
            sb.append(sc.nextInt());
            sb.append(" ");
            HList l = new HList();

            int steps = 0;

            for (int i = 0; i<20; i++) {
                int k = sc.nextInt();
                steps += l.add(k);
            }
            sb.append(steps);
        }
        sc.close();
        System.out.println(sb.toString());
    }

    static class HList {
        int[] list;
        int size;

        public HList() {
            list = new int[20];
            size = 0;
        }

        public int add(int x) {
            int pos = 0;
            for (int i = 0; i <= size; i++) {
                if (list[i] > x) {
                    pos = i;
                    shift(pos);
                    break;
                } else pos = i;
            }
            list[pos] = x;
            int steps = size-pos;
            size++;
            return steps;
        }

        private void shift(int pos) {
            for (int i = size; i>pos; i--) {
                list[i] = list[i-1];
            }
        }
    }
}
