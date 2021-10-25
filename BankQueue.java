import java.util.Arrays;

public class BankQueue {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int t = io.getInt();

        Customer[] customers = new Customer[n];
        for (int i = 0; i<n; i++) {
            customers[i] = new Customer(io.getInt(), io.getInt());
        }
        Arrays.sort(customers);
        boolean[] visited = new boolean[t];
        int numserved = 0;
        int pos = 0;
        int sum = 0;
        while (numserved<t && pos < n) {
            while (customers[pos].time >= 0) {
                if (visited[customers[pos].time]) customers[pos].time--;
                else break;
            }
            if (customers[pos].time >= 0) {
                visited[customers[pos].time] = true;
                sum += customers[pos].money;
                numserved++;
            }
            pos++;
        }
        System.out.println(sum);
    }

    private static class Customer implements Comparable<Customer> {
        int money;
        int time;

        public Customer(int m, int t) {
            money = m;
            time = t;
        }

        public int compareTo(Customer that) {
            return that.money-this.money;
        }
    }
}
