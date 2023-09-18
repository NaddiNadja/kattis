import java.util.HashMap;

public class VirtualFriends {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();

        int tests = io.getInt();
        for (int t = 0; t<tests; t++) {
            int f = io.getInt();
            WeightedQuickUnionUF uf = new WeightedQuickUnionUF(f*2);
            HashMap<String, Integer> people = new HashMap<>();
            for (int i = 0; i<f; i++) {
                String name1 = io.getWord();
                String name2 = io.getWord();
                if (!people.containsKey(name1)) people.put(name1, people.size());
                if (!people.containsKey(name2)) people.put(name2, people.size());

                uf.union(people.get(name1), people.get(name2));
                sb.append(uf.size[uf.find(people.get(name1))]).append("\n");
            }
        }
        System.out.print(sb);
    }
}