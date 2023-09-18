// dependent on: Queue, Stack, MaxPQ
import java.util.Scanner;

public class ICanGuessTheDataStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Stack<Integer> st = new Stack<>();
            Queue<Integer> qu = new Queue<>();
            MaxPQ<Integer> pq = new MaxPQ<>();
            boolean isstack = true;
            boolean isqueue = true;
            boolean ismaxpq = true;
            for (int i = 0; i<n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (a == 1) {
                    st.push(b);
                    qu.enqueue(b);
                    pq.insert(b);
                } else {
                    if (st.isEmpty() || qu.isEmpty() || pq.isEmpty()) {
                        isstack = false;
                        isqueue = false;
                        ismaxpq = false;
                    } else {
                        if (st.pop() != b) isstack = false;
                        if (qu.dequeue() != b) isqueue = false;
                        if (pq.delMax() != b) ismaxpq = false;
                    }
                }
            }
            if (isstack && isqueue || isstack && ismaxpq || isqueue && ismaxpq) System.out.println("not sure");
            else if (isstack) System.out.println("stack");
            else if (isqueue) System.out.println("queue");
            else if (ismaxpq) System.out.println("priority queue");
            else System.out.println("impossible");
        }
        sc.close();
    }
}
